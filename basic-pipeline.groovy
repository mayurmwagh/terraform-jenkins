pipeline {
    agent any 
    stages{
        stage('code-pull'){
            steps {
                git branch: 'main', url: 'https://github.com/mayurmwagh/terraform-jenkins.git'
            }
        }
        stage('Docker-image-build'){
            steps {
                sh ''' 
                    docker build -t tomcatjava:latest .
                '''
            }
        }
    }    
    
}
