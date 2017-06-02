node {
  def mvnHome = tool 'Maven-3.3'
  
  stage('Checkout') {
    git url: 'https://github.com/kifj/camunda-wildfly-logging.git', branch: 'master'
  }
  
  stage('Build') {
    sh "${mvnHome}/bin/mvn clean package"
  }
  
  stage('Publish') {
    sh "${mvnHome}/bin/mvn deploy site-deploy -DskipTests"
  }
}
