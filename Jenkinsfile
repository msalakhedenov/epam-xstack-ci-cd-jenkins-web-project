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
                echo 'Deploying...'
            }
        }
    }
}