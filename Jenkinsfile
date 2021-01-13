pipeline {
    /* insert Declarative Pipeline here */
    agent any
        stages {
                   stage('清理') {
                                                  agent any
                                                  steps {
                                                      echo '停止app容器'
                                                      sh 'if [ $(docker ps -a -q -f"name=app") ];then docker rm -f app;fi;'
                                                      echo '删除app镜像'
                                                      /*sh  'docker rmi pandau/app'*/
                                                      sh 'if [ $(docker images pandau/app -q) ];then docker rmi pandau/app;fi;'
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
                                              echo '登录仓库'
                                              sh  'docker login -u pandau -p xiong1314229'
                                              echo 'docker push 镜像'
                                              sh  'docker push pandau/app:latest'
                                              echo 'pull 仓库镜像'
                                              sh  'docker pull pandau/app:latest'
                                              echo '部署'
                                              sh 'docker run -d  --name app -P -p 18888:8080 pandau/app'
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