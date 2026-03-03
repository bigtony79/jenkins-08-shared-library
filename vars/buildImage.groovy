#!/usr/bin/env groovy

def call() {

    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'dockerhub-pat', usernameVariable: 'DOCKERHUB_USERNAME', passwordVariable: 'DOCKERHUB_PASSWORD')])
            {
                sh 'docker build -t $DOCKERHUB_USERNAME/demo-app:jma-1.2 .'
                sh 'echo $DOCKERHUB_PASSWORD | docker login -u $DOCKERHUB_USERNAME --password-stdin'
                sh 'docker push $DOCKERHUB_USERNAME/demo-app:jma-1.2'
            }
}
