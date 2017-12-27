#!/usr/bin/env groovy
import com.github.exelexe.jenkins.SampleConfig

def getGitUrlFormat() {
  def jsonStr = libraryResource 'com/github/exelexe/jenkins/sample.json'
  //final props = new SampleConfig(jsonStr)
  props = new SampleConfig(this)
  return props.getGitUrlFormat()
}
