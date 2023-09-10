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
        stage ('Static analysis') {
            steps {
                withSonarQubeEnv() {
                    sh './gradlew sonar'
                }
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