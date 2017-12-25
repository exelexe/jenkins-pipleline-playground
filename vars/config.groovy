#!/usr/bin/env groovy

def getResource() {
  def jsonStr = libraryResource 'com/github/exelexe/jenkins/sample.json'
  return new groovy.json.JsonSlurperClassic().parseText(jsonStr)
}

def getGitUrlFormat() {
  config = getResource()
  return config["git"]["url-format"]
}

