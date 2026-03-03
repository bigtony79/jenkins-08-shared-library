# Create a Jenkins Shared Library
This project provides a reusable Jenkins Shared Library designed to centralize and standardize pipeline logic across multiple Jenkins jobs and repositories. By moving common pipeline stages, functions, and utilities into a shared library, teams can simplify their Jenkinsfiles, reduce duplication, and ensure consistent CI/CD best practices across projects.

## Technologies used
Jenkins, Groovy, Docker, Git, Java, Maven

## Project Description: 
Create a Jenkins Shared Library (JSL) to extract common build logic: 
 -  Create separate Git repository for Jenkins Shared Library project
 -  Create functions in the JSL to use in the Jenkins pipeline
 -  Integrate and use the JSL in Jenkins Pipeline (globally and for a specific project in Jenkinsfile)

## Steps
### Step 1 - Create the Shared Library Repository
* Create a new private repository in GitHub for Jenkins Shared Library and assign a name such as "jenkins-shared-library".
* Create a Groovy project for the JSL using VSCode or IntelliJ and create a separate **vars** folder which will store the Groovy files for each function that we call from Jenkinsfile.
* Create the following buildJar.groovy and buildImage.groovy files and save them in the **vars** folder.
  buildJar.groovy
```
    #!/usr/bin/env groovy
   
    def call() {
     echo " building the application for branch $GIT_BRANCH...."
     sh 'mvn package'
 }
```
buildImage.groovy
```
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
```
* Push the project to the newly created repository

### Step 2 - 
