#!/usr/bin/env groovy

def info(String message) {
  notify(getPayload(message))
}

def error(String message) {
  notify(getPayload(message, 'error'))
}

def success(String message) {
  notify(getPayload(message, 'success'))
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
    case 'success':
      color = 'good'
      break
    case 'error':
      color = 'danger'
      break
  }

  return color
}

private def getTitleLink(String status) {
  return (status == 'error') 
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
          "title": "${env.JOB_NAME} #${env.BUILD_NUMBER} By ${buildUser}",
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

