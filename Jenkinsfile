pipeline {
    /* insert Declarative Pipeline here */
    agent {
        docker {
            image 'maven:3-alpine'
            label 'my-defined-label'
            args  '-v /tmp:/tmp'
        }
        dockerfile {
                filename 'Dockerfile.build'
                dir 'build'
                label 'my-defined-label'
                additionalBuildArgs  '--build-arg version=1.0.2'
            }
    }
        stages {
                   stage('Example Build') {
                       agent { docker 'maven:3-alpine' }
                       steps {
                           echo 'Hello, Maven'
                           sh 'mvn --version'
                       }
                   }
                   stage('Example Test') {
                       agent { docker 'openjdk:8-jre' }
                       steps {
                           echo 'Hello, JDK'
                           sh 'java -version'
                       }
                   }
                   stage('Example end') {
                        steps {
                           echo 'Hello, cleanDir'
                           cleanDir
                   }
                   }
        }
}