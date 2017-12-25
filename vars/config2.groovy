#!/usr/bin/env groovy

def getGitUrlFormat() {
  def jsonStr = libraryResource 'com/github/exelexe/jenkins/sample.json'
  def res = new SampleConfig(jsonStr)
  return res.getGitUrlFormat()
}

