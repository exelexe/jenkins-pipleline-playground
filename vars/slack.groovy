#!/usr/bin/env groovy

import groovy.transform.Field

@Field final String STATUS_SUCCESS = 'SUCCESS'
@Field final String STATUS_ERROR = 'ERROR'

def info(String message) {
  notify(getPayload(message))
}

def error(String message) {
  notify(getPayload(message, STATUS_ERROR))
}

def success(String message) {
  notify(getPayload(message, STATUS_SUCCESS))
}

private def notify(String payload) {
  def response
  try {
    response = httpRequest acceptType: 'APPLICATION_JSON',
      contentType: 'APPLICATION_JSON',
      httpMode: 'POST',
      requestBody: payload,
      url: env.SLACK_WEBHOOK_URL;
  } catch (err) {
    echo '[WARN] Slack notify failed.'
  }
}

private def getColor(String status) {
  def color = ''

  switch (status) {
    case STATUS_SUCCESS:
      color = 'good'
      break
    case STATUS_ERROR:
      color = 'danger'
      break
  }

  return color
}

private def getTitleLink(String status) {
  return (status == STATUS_ERROR) 
    ? "${env.HUDSON_URL}job/${env.JOB_NAME}/${env.BUILD_NUMBER}/console" 
    : "${env.HUDSON_URL}blue/organizations/jenkins/${env.JOB_NAME}/detail/${env.JOB_NAME}/${env.BUILD_NUMBER}/pipeline"
}

private def getPayload(String message, String status = null) {
  echo "message: ${message}, status: ${status}"
  wrap([$class: 'BuildUser']) {
    buildUser = sh(script: 'echo -n "${BUILD_USER}"', returnStdout: true)
  }

  def color = getColor(status)
  def titleLink = getTitleLink(status)

  def payload = """
    {
      "channel": "#_hide",
      "username": "JenkinsBot-${env.APP_ENV}",
      "icon_emoji": ":jenkins_ci:",
      "attachments": [
        {
          "color": "${color}",
          "author_name": "${buildUser}",
          "title": "${env.JOB_NAME} #${env.BUILD_NUMBER}",
          "title_link": "${titleLink}",
          "text": "${message}",
          "footer": "Jenkins Bot",
          "ts": ${System.currentTimeMillis()/1000}
        }
      ]
    }
    """

  echo "Using Slack payload:\n${payload}"
  return payload
}
