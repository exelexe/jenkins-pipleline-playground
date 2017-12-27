#!/usr/bin/env groovy
package com.github.exelexe.jenkins

class SampleConfig implements Serializable {

  def res

  public SampleConfig() {
    this.res = new groovy.json.JsonSlurperClassic().parseText(
                     this.getClass().getResource( 'com/github/exelexe/jenkins/sample.json').text
                   )
  }

  public SampleConfig(jsonStr) {
    this.res = new groovy.json.JsonSlurperClassic().parseText(jsonStr)
  }

  def getGitUrlFormat() {
    return this.res["git"]["url-format"]
  }
}

