pipeline {
    agent any

    tools {
        jdk 'jdk-21'
        maven 'maven-3.9.6'
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

//         stage('Archive Artifacts') {
//             steps {
//                 archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
//             }
//         }

        stage('Deploy') {
            steps {
                sh '''
                    # Copy JAR into app directory
                    cp target/my-blog.jar /opt/apps/my-blog/

                    # Call local deploy script
                    bash /opt/apps/my-blog/deploy.sh
                '''
            }
        }
    }
}
