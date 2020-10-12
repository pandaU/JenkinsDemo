pipeline {
    /* insert Declarative Pipeline here */
    agent any
        stages {
                   stage('清理') {
                                                  agent any
                                                  steps {
                                                      echo '停止app镜像'
                                                      sh  'docker stop app'
                                                      sh  'docker rmi app'
                                                  }
                     }
                   stage('编译') {
                       agent { docker 'maven:3-alpine' }
                       steps {
                           echo '编译文件'
                           sh 'mvn clean package -Dmaven.test.skip=true'
                       }
                   }
                   stage('部署') {
                                          agent any
                                          steps {
                                              echo '部署'
                                              sh 'docker run -d  --name app -P -p 18888:8080 app'
                                          }
                                      }
        }
}