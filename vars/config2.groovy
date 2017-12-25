#!/usr/bin/env groovy

import com.github.exelexe.json.*

def getGitUrlFormat() {
  config = new SampleConfig()
  return config.getGitUrlFormat()
}

