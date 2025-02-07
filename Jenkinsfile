pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git "mvnhttps://github.com/Ant198/testmatick_test1.git'
            }
        }
        stage('Run Selenium Tests') {
            steps {
                sh 'mvn test'  /
            }
        }
    }
}