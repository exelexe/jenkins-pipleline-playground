#!/usr/bin/env groovy
import com.github.exelexe.jenkins.SampleConfig

def jsonStr = libraryResource 'com/github/exelexe/jenkins/sample.json'
final MYCONSTANT = new SampleConfig(jsonStr)

def getGitUrlFormat() {
  return MYCONSTANT.getGitUrlFormat()
}
