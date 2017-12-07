#!/usr/bin/env groovy

def call(String name) {
  if (!name) {
    currentBuild.result = 'FAILURE'    
  }

  echo "Hello, ${name}."
}

