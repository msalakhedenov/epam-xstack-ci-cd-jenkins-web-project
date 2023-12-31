pipeline {
    agent any

    stages {
        stage ('Build, Test and Analysis') {
            steps {
                sh './gradlew build'
                sh './gradlew jacocoTestReport'

                withSonarQubeEnv('Local') {
                    sh './gradlew sonar'
                }
            }
            post {
                success {
                    jacoco(
                        execPattern: '**/build/jacoco/*.exec',
                        classPattern: '**/build/classes/java/main',
                        sourcePattern: '**/src/main'
                    )
                }
            }
        }
        stage ('Quality gate') {
            steps {
                timeout(time: 1, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
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