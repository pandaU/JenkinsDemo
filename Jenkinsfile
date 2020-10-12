pipeline {
    /* insert Declarative Pipeline here */
    agent {
           docker {
                   image 'app'
                   label 'my-app'
                   args  '-d  --name app -P -p 18888:8080'
                   }
           }
        stages {
                   stage('部署') {
                       agent { docker 'maven:3-alpine' }
                       steps {
                           echo '删除app镜像'
                           sh  'docker rmi app '
                           echo '编译文件'
                           sh 'mvn clean package -Dmaven.test.skip=true'
                       }
                   }
        }
}