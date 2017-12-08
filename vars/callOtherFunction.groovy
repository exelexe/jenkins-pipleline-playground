#!/usr/bin/env groovy

def call() {
  node {
    stage('sayHello') {
      sayHello('dude')
    }

    stage('pwd') {
      pwd()
    }
  }
}

