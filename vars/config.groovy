#!/usr/bin/env groovy
import com.github.exelexe.jenkins.SampleConfig

def getGitUrlFormat() {
  conf = new SampleConfig(this)
  return conf.getGitUrlFormat()
}

