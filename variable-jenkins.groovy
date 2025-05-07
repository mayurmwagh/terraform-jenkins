pipeline {
    agent any 
    environment {
        Prod_Ip = '192.168.9.0'
        UAT_Ip    = '192.186.2.1'
    }
    stages {
        stage('code-pull'){
            steps {
                echo "this is my first pipelin"
            }
        }
        stage('printing-dir'){
            steps {
                sh 'pwd' 
                sh 'ls -ltr'
            }
        }
        stage('print-default-variable'){
            steps {
                sh 'printenv' 
                
            }
        }
        stage('Printing-environment-variable'){
            steps {
                echo "prod ip is {$Prod_Ip}"
                echo "UAT ip is {$UAT_Ip}"
                
            }
        }
    }
}