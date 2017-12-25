#!/usr/bin/env groovy
package com.github.exelexe.jenkins

import groovy.json.JsonSlurper

class SampleConfig implements Serializable {

  public SampleConfig() {
    def jsonStr = libraryResource 'com/github/exelexe/jenkins/sample.json'
    def config = new JsonSlurper().parse(jsonStr)
  }

  def getGitUrlFormat() {
    return config["git"]["fablic-url-format"]
  }
}

