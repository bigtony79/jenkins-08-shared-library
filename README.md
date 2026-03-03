# Create a Jenkins Shared Library
This project provides a reusable Jenkins Shared Library designed to centralize and standardize pipeline logic across multiple Jenkins jobs and repositories. By moving common pipeline stages, functions, and utilities into a shared library, teams can simplify their Jenkinsfiles, reduce duplication, and ensure consistent CI/CD best practices across projects.

## Technologies used
Jenkins, Groovy, Docker, Git, Java, Maven

## Project Description: 
Create a Jenkins Shared Library to extract common build logic: 
 -  Create separate Git repository for Jenkins Shared Library project
 -  Create functions in the JSL to use in the Jenkins pipeline
 -  Integrate and use the JSL in Jenkins Pipeline (globally and for a specific project in Jenkinsfile)
