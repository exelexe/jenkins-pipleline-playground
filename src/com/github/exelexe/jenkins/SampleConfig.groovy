#!/usr/bin/env groovy
package com.github.exelexe.jenkins

//import groovy.text.SimpleTemplateEngine

class SampleConfig implements Serializable {

  def res

  public SampleConfig(Script script) {
    this.res = new groovy.json.JsonSlurperClassic().parseText(
                       script.libraryResource('com/github/exelexe/jenkins/sample.json')
//                     this.class.getResource( 'com/github/exelexe/jenkins/sample.json').getText()
                   )
  }

  public SampleConfig(jsonStr) {
    this.res = new groovy.json.JsonSlurperClassic().parseText(jsonStr)
  }

  def getGitUrlFormat() {
    return this.res["git"]["url-format"]
  }
}

