#!/usr/bin/env groovy

import com.github.exelexe.jenkins

def config = new SampleConfig()

def call() {
  echo getGitUrlFormat()
}

