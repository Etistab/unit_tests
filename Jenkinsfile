pipeline { 
    agent any  
    stages { 
        stage('Build') { 
            steps { 
               echo 'Build' 
            }
        }
        stage('Test'){
            steps {
                sh 'mvn test'
            }
        }
    }
    post {
        always {
            emailext body: 'A Test EMail', recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']], subject: 'Test'
        }
    }
}
