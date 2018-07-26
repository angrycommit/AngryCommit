pipeline {
  agent any
  stages {
    stage('wait') {
      steps {
        waitUntil() {
          sh 'echo hello'
          waitUntil() {
            sh 'sleep 4'
            sh 'sleep 5'
          }

        }

      }
    }
    stage('over') {
      steps {
        sleep 4
      }
    }
  }
}