#!/usr/bin/env groovy

def getResource() {
  def jsonStr = libraryResource 'com/github/exelexe/jenkins/sample.json'
  echo jsonStr
  return new groovy.json.JsonSlurperClassic().parseText(jsonStr)
}

def getGitUrlFormat() {
  def res = getResource()
  return res["git"]["url-format"]
}

