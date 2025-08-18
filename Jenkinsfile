pipeline {
    agent any

    tools {
        jdk 'JDK_21'
        maven 'maven_3911'
    }

    stages {
        stage('Check Versions') {
            steps {
                sh 'java -version'
                sh 'mvn -v'
                sh 'which javac'
                sh 'echo $JAVA_HOME'
            }
        }

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
                    mv target/my-blog-0.0.1-SNAPSHOT.jar target/my-blog.jar

                    # Copy JAR into app directory
                    cp target/my-blog.jar /opt/apps/my-blog/

                    # Call local deploy script
                    bash /opt/apps/my-blog/deploy.sh
                '''
            }
        }
    }
}
