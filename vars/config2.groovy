#!/usr/bin/env groovy

import com.github.exelexe.jenkins.*

def getGitUrlFormat() {
  config = new SampleConfig()
  return config.getGitUrlFormat()
}

