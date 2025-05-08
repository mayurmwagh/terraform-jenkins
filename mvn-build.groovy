pipeline {
    agent {
        label 'demo_slave'
    }
    stages{
        stage('code-pull'){
            steps{
                git 'https://github.com/mayurmwagh/onlinebookstore.git'
            }
        }
        stage('Maven-Install'){
            steps{
                sh '''sudo apt update
                    sudo apt install maven -y
                   '''
            }
        }
    }
}