#!/usr/bin/env groovy
import com.github.exelexe.jenkins.SampleConfig

def getGitUrlFormat() {
  def jsonStr = libraryResource 'com/github/exelexe/jenkins/sample.json'
  def con = new SampleConfig(jsonStr)
  return con.getGitUrlFormat()
}

