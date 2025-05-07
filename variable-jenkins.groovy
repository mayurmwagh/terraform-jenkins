pipeline {
    agent any 
    stages {
        stage('code-pull'){
            steps {
                echo "this is my first pipelin"
            }
        }
    }
}