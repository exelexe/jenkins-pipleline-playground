#!/usr/bin/env groovy
import com.github.exelexe.jenkins.SampleConfig

def getGitUrlFormat() {
  def con = new SampleConfig()
  return con.getGitUrlFormat()
}
