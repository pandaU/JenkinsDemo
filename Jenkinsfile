pipeline {
    /* insert Declarative Pipeline here */
    agent any
        stages {
                   stage('清理') {
                                                  agent any
                                                  steps {
                                                      sh 'docker  rm -f app'
                                                      echo '停止app镜像'
                                                      sh  'docker rmi app'
                                                  }
                     }
                   stage('编译') {
                       agent { docker 'maven:3-alpine' }
                       steps {
                           echo '编译文件'
                           sh 'mvn clean package -Dmaven.test.skip=true'
                           sh  'docker login -u pandau -p xiong1314229'
                           sh  'docker push pandau/app:latest'

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
        post {
                always {
                    echo 'One way or another, I have finished'
                    deleteDir() /* clean up our workspace */
                }
                success {
                    echo 'I succeeeded!'
                }
                unstable {
                    echo 'I am unstable :/'
                }
                failure {
                    echo 'I failed :('
                }
                changed {
                    echo 'Things were different before...'
                }
            }
        }
}