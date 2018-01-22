#!/usr/bin/env groovy

import groovy.transform.Field
import com.github.exelexe.jenkins.SampleConfig

@Field def CONF = new EnvironmentConfig(this)

def getGitUrlFormat() {
  conf = new SampleConfig(this)
  return conf.getGitUrlFormat()
}

def getGitUrlFormatTmp() {
  return CONF.getGitUrlFormat()
}

