#!/usr/bin/env groovy

import com.github.exelexe.jenkins.SampleConfig

def jsonStr = libraryResource 'com/github/exelexe/jenkins/sample.json'
def res = new SampleConfig(jsonStr)

def getGitUrlFormat() {
  echo jsonStr
  echo res
  //return res.getGitUrlFormat()
}

