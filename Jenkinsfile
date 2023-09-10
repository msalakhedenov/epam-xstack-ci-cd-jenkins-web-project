pipeline {
    agent any

    stages {
        stage ('Build') {
            steps {
               sh './gradlew bootWar --exclude-task test'
            }
        }
        stage ('Test') {
            steps {
                sh './gradlew test'
            }
        }
        stage ('Deploy') {
            steps {
                sh './gradlew bootWar --exclude-task test'
                sh 'ls -la build/libs'
                sh 'mv -f build/libs/*.war /usr/local/tomcat/webapps'
            }
        }
    }
}