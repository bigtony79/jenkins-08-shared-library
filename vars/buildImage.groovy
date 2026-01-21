#!/usr/bin/env groovy

def call() {

    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-creds', usernameVariable: 'DOCKERHUB_USERNAME', passwordVariable: 'DOCKERHUB_PASSWORD')])
            {
                sh 'echo $DOCKERHUB_PASSWORD | docker login -u $DOCKERHUB_USERNAME --password-stdin'
                sh 'docker build -t tonyjacob79/java-maven-app:2.0 .'
                sh 'docker push tonyjacob79/java-maven-app:2.0'
            }
}
