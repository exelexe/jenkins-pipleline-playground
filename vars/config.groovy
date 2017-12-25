#!/usr/bin/env groovy

def jsonStr = libraryResource 'com/github/exelexe/jenkins/sample.json'
def config = new groovy.json.JsonSlurperClassic().parseText(jsonStr)

def getGitUrlFormat() {
  return config["git"]["fablic-url-format"]
}

