#!/usr/bin/env groovy

def call(String name) {
  if (!name) {
    error 'name is required'
  }

  echo "Hello, ${name}."
}

