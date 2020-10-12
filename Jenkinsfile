pipeline {
    /* insert Declarative Pipeline here */
    agent any
        stages {
                   stage('编译') {
                       agent { docker 'maven:3-alpine' }
                       steps {
                           echo 'Hello, Maven'
                           sh 'mvn clean package -Dmaven.test.skip=true'
                       }
                   }
                   stage('Example Test') {
                       agent { docker 'openjdk:8-jre' }
                       steps {
                           echo 'Hello, JDK'
                           sh 'java -version'
                       }
                   }
        }
}