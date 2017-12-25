#!/usr/bin/env groovy
package com.github.exelexe.jenkins

class SampleConfig implements Serializable {

  def res

  public SampleConfig() {
    def jsonStr = libraryResource 'com/github/exelexe/jenkins/sample.json'
    this.res = new groovy.json.JsonSlurperClassic().parseText(jsonStr)
  }

  def getGitUrlFormat() {
    return this.res["git"]["url-format"]
  }
}

