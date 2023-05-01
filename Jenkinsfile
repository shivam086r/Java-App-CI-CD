pipeline {
    agent any
    tools {
        maven 'Maven'
    }
    stages {
        stage('build') {
            steps {
                script {
                    echo "Building the application..."
                    sh 'mvn package'
                }
            }
        }

        stage('build image') {
            steps {
                script {
                    echo "building the docker image..."
                    withCredentials([usernamePassword(credentialsId: 'dockerhub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                        sh 'docker build -t docker push shivam086r/java-app:java-1.0 .'
                        sh "echo $PASS | docker login -u $USER --password-stdin"
                        sh 'docker push shivam086r/java-app:java-1.0'
                }
            }
        }
        stage('deploy') {
            steps {
                script {
                    echo "Deploying the application..."
                }
            }
        }
    }
}
