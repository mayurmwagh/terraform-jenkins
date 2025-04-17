pipeline {
    agent any 
    stages{
        stage('first-step'){
            steps {
                echo "pipeline run from github"
            }
        }
    }
}