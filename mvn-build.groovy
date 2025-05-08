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
        stage('Maven-Build'){
            steps{
                sh 'mvn clean package'
                   
            }
        }
        stage('workspace'){
            steps{
                sh '''
                    wget https://dlcdn.apache.org/tomcat/tomcat-9/v9.0.104/bin/apache-tomcat-9.0.104.tar.gz
                    tar -xvf tomcat-9.0.104.tar.gz -C /opt/tomcat
                    cp /home/ubuntu/workspace/mvn-project/target/*.war /opt/tomcat/webapps
                '''
                   
            }
        }
    }
}