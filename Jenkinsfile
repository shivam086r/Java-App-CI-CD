pipeline {
    agent any
    
    tools {
        // Use the 'Maven' tool to build the Java application
        maven 'Maven'
    }
    
    stages {
        stage('Build') {
            steps {
                // Build the Java application using Maven
                sh 'mvn clean package'
            }
        }
        
        stage('Build Docker Image') {
            environment {
                // Set environment variables for the Docker image name and tag
                DOCKER_IMAGE_NAME = "shivam086r/java-app"
                DOCKER_IMAGE_TAG = "java-2.0"
            }
            steps {
                // Build the Docker image using the Dockerfile and application JAR file
                sh 'docker build -t ${DOCKER_IMAGE_NAME}:${DOCKER_IMAGE_TAG} .'
                
                // Login to Docker Hub and push the Docker image
                withCredentials([usernamePassword(credentialsId: 'docker-cred', passwordVariable: 'DOCKERHUB_PASSWORD', usernameVariable: 'DOCKERHUB_USERNAME')]) {
                    sh "echo ${DOCKERHUB_PASSWORD} | docker login -u ${DOCKERHUB_USERNAME} --password-stdin"
                    sh "docker push ${DOCKER_IMAGE_NAME}:${DOCKER_IMAGE_TAG}"
                }
            }
        }
    }
}
