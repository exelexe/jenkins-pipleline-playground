#!/usr/bin/env groovy

node {
  stage('sayHello') {
    sayHello('dude')
  }

  stage('pwd') {
    pwd
  }
}

