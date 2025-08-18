pipeline {
    agent any

    tools {
        jdk 'JDK_21'
        maven 'maven_3911'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/shailahir/my-blog.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Deploy') {
            steps {
                sh '''
                    mv target/my-blog-0.0.1-SNAPSHOT.jar target/my-blog.jar
                '''
                sh 'sudo /usr/local/bin/deploy-myblog.sh'
            }
        }
    }
}
