#!/usr/bin/env groovy

import com.github.exelexe.jenkins.SampleConfig

def getGitUrlFormat() {
  def res = new SampleConfig()
  return res.getGitUrlFormat()
}

