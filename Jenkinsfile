pipeline {
    /* insert Declarative Pipeline here */
    agent any
        stages {
                   stage('编译') {
                       agent { docker 'maven:3-alpine' }
                       steps {
                           echo '删除app镜像'
                           docker rmi app
                           echo '编译文件'
                           sh 'mvn clean package -Dmaven.test.skip=true'
                       }
                   }
                   stage('部署') {
                       agent any
                       steps {
                           echo '启动app镜像'
                           docker run -d  --name app -P -p 18888:8080 app
                       }
                   }
        }
}