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
        stage('Deploy'){
            steps{
                echo 'Deploying...'
            }
        }
    }

}