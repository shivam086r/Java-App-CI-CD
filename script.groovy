def buildJar() {
    echo "building the application..."
    sh 'mvn package'
} 

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'dockerhub-cred', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t shivam086r/java-app:java-1.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push shivam086r/java-app:java-1.0'
    }
} 

def deployApp() {
    echo 'deploying the application...'
} 

return this
