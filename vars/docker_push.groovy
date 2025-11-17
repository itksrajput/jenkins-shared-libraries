def call(String Project, String ImageTag, String dockerhubuser){
  withCredentials([usernamePassword(credentialsId: 'dockerhubcred', passwordVariable: "dockerHubPass", usernameVariable: "dockerHubUser")]) {
      sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
      sh "docker image tag ${Project}:${ImageTag} ${dockerhubuser}/${Project}:${ImageTag}"
      sh "docker push ${dockerhubuser}/${Project}:${ImageTag}"
}

