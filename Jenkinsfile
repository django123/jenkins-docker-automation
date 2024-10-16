pipeline {
    agent any
    tools{
        maven 'Maven3'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/django123/jenkins-docker-automation.git']]])
                sh 'mvn clean install'
            }
        }
        stage('Build docker image'){
            steps{
                script{
                    sh 'docker build -t jenkins-docker-automation .'
                }
            }
        }
        stage('Push image to Hub'){
            steps{
                script{
                   withCredentials([string(credentialsId: 'dockerhub-credentials', variable: 'dockerhub-credentials')]) {
                      sh 'docker login -u javatechie -p ${dockerhub-credentials}'
                   }
                   sh 'docker push jenkins-docker-automation'
                }
            }
        }

    }
}