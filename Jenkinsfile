pipeline {
  agent {
    node {
      label 'jenkins-jenkins-slave'
    }
  }
  stages {
    stage('git scm update') {
      steps {
        git url: 'https://github.com/rednine9777/jobboo.git', branch: 'main'
      }
    }
    stage('docker build and push') {
      steps {
        container('jnlp') { // 지정된 컨테이너에서 빌드 및 푸시
          sh '''
          docker build -t localhost:5000/jobboo .
          docker push localhost:5000/jobboo
          '''
        }
      }
    }
    stage('deploy kubernetes') {
      steps {
        container('jnlp') {
          sh '''
          kubectl create deployment pl-bulk-prod --image=localhost:5000/jobboo
          kubectl expose deployment pl-bulk-prod --type=LoadBalancer --port=8080 \
                                                 --target-port=80 --name=pl-bulk-prod-svc
          '''
        }
      }
    }
  }
}
