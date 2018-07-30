pipeline {
  agent any
  stages {
    stage('checkout') {
      steps {
        git(url: 'https://github.com/angrycommit/AngryCommit.git', branch: 'new')
      }
    }
    stage('Build') {
      steps {
        sh 'mvn clean compile'
      }
    }
    stage('Run unit tests') {
      steps {
        sh 'mvn test'
      }
    }
    stage('build & SonarQube Scan') {
      steps{
          script{
              scannerHome = tool 'SonarScanner'
          }
    withSonarQubeEnv('Sonar') {
         sh "echo The workspace is: ${WORKSPACE}"
      sh "${scannerHome}/bin/sonar-scanner"
     
    }
    } // SonarQube taskId is automatically attached to the pipeline context
  }
  stage("Quality Gate") {
            steps {
                timeout(time: 1, unit: 'HOURS') {
                    // Parameter indicates whether to set pipeline to UNSTABLE if Quality Gate fails
                    // true = set pipeline to UNSTABLE, false = don't
                    // Requires SonarQube Scanner for Jenkins 2.7+
                    waitForQualityGate abortPipeline: true
                }
            }
  }
    stage('Package') {
      steps {
        sh 'mvn package'
      }
    }
    stage('Deploy To Weblogic Server') {
      steps {
        build 'TestWeblogic'
      }
    }
    stage('Functional Testing') {
      parallel {
        stage('Functional Testing') {
          steps {
            sh 'testthis'
          }
        }
        stage('SwitchTest') {
          steps {
            sh 'echo hello world'
          }
        }
        stage('Android Test') {
          steps {
            sh 'echo android test'
          }
        }
        stage('Non-Android Test') {
          steps {
            sh 'echo non android test'
          }
        }
      }
    }
    stage('Start nodejs') {
      parallel {
        stage('Start nodejs') {
          steps {
            sh 'echo start nodejs'
          }
        }
        stage('Display live report') {
          steps {
            sh 'echo display report'
          }
        }
      }
    }
    stage('Email ') {
      steps {
        sh 'echo email report'
      }
    }
    stage('Greet Goodbye') {
      steps {
        sh 'echo goodbye!'
      }
    }
  }
}
