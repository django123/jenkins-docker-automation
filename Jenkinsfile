pipeline {

    agent any
    stages {
        stages('Build Maven'){
            steps{
              checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/django123/jenkins-docker-automation.git']]])
              sh 'mvn clean install'
            }
        }

        stage('Build Docker image'){

            steps{
                script{
                    sh 'docker build -t jenkins-docker-automation .'
                }
            }

        }
        stage('Push image to Docker Hub'){
            steps{

                script {
                   // Se connecter à Docker Hub (nécessite des identifiants Jenkins pour Docker Hub)
                    withCredentials([string(credentialsId: 'dockerhub-credentials', variable: 'dockerhub-credentials')]) {
                          sh 'docker login -u django91 -p ${dockerhub-credentials}'
                    }
                           sh 'docker push jenkins-docker-automation'

                }
            }

        }
    }


}