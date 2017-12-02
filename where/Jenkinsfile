pipeline {
  agent any
  stages {
    stage('pwd') {
      agent any
      environment {
        Neme = 'hoge'
      }
      steps {
        sh 'pwd'
      }
    }
  }
}