#!/usr/bin/env groovy

def call(String imageName) {

    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-creds', usernameVariable: 'DOCKERHUB_USERNAME', passwordVariable: 'DOCKERHUB_PASSWORD')])
            {
                sh 'echo $DOCKERHUB_PASSWORD | docker login -u $DOCKERHUB_USERNAME --password-stdin'
                sh "docker build -t $imageName ."
                sh "docker push $imageName"
            }
}
