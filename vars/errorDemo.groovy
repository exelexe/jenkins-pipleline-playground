#!/usr/bin/env groovy

def call() {
  node {
    try {
      stage('errorDemo') {
        error()
      }
      stage('foo') {
        echo 'foo'
      }
    } catch (err) {
      currentBuild.result = 'FAILED'
      throw err
    }
  }
}

