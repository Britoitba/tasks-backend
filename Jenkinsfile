pipeline{
    agent any

    stages{
        stage('Build'){
            steps{
                echo 'Building...'
                bat 'mvn clean package -DskipTests=true'
            }
        }
        stage('Unit Tests'){
            steps{
                echo 'Testing...'
                bat 'mvn test'
            }
        }
        stage('Sonar Analisys'){
            environment{
                scanner = tool 'SONAR_SCANNER'
            }
            steps{
                withSonarQubeEnv('SONAR_LOCAL'){
                    bat "${scanner}/bin/sonar-scanner -e -Dsonar.projectKey=DeployBack -Dsonar.host.url=http://localhost:9000 -Dsonar.login=d23fd321258d632c2b83d57f54066cec6f80d7ea -Dsonar.java.binaries=target -Dsonar.coverage.exclusions=**/.mvn/**,**/src/test/**,**/model/**,**Application.java"
                }
            }
        }
        stage('Quality Gate'){
            steps{
                sleep(5)
                timeout(time: 1, unit: 'HOURS') {
                    // waitForQualityGate abortPipeline: true
                }
            }

            // steps{
            //     timeout(time: 1, unit: 'HOURS') {
            //         def qg = waitForQualityGate()
            //         if (qg.status != 'OK') {
            //             abortPipeline: true
            //         }
            //      }
            // }
        }


        stage('Deploy'){
            steps{
                echo 'Deploying...'
            }
        }
    }

}

