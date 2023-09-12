pipeline {
    agent any

    tools {
        gradle 'Gradle-7.6.2'
    }

    stages {
        stage ('Build & Analysis') {
            steps {
                sh './gradlew build --exclude-task test'
                sh './gradlew jacocoTestReport'

                withSonarQubeEnv('Local') {
                    sh './gradlew sonar'
                }
            }
        }
        stage ('Quality gate') {
            steps {
                waitForQualityGate abortPipeline: true
            }
        }
        stage ('Test') {
            steps {
                sh './gradlew test'
            }
        }
        stage ('Deploy') {
            steps {
                withCredentials([file(credentialsId: 'EPAM_XSTACK_CI_CD_JENKINS_DB_PROPERTIES', variable: 'db_properties')]) {
                    writeFile file: 'src/main/resources/db.properties', text: readFile(db_properties)
                    sh './gradlew bootWar --exclude-task test'
                }
                sh 'ls -la build/libs'
                sh 'mv -f build/libs/*.war /usr/local/tomcat/webapps'
            }
        }
    }
}