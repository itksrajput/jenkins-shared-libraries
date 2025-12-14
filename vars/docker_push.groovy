 def call(Map args) {
    def imageName = args.imageName
    def imageTag  = args.imageTag

    echo "Pushing Docker image: ${imageName}:${imageTag}"

    withCredentials([
        usernamePassword(
            credentialsId: 'dockerhub-credentials',
            usernameVariable: 'DOCKER_USER',
            passwordVariable: 'DOCKER_PASS'
        )
    ]) {
        sh """
          set -x
          echo "\$DOCKER_PASS" | docker login -u "\$DOCKER_USER" --password-stdin
          docker push ${imageName}:${imageTag}
        """
    }
}
