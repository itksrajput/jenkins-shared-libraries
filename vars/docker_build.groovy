def call(Map args) {
    echo "Docker build args: ${args}"

    sh '''
      set -x
      whoami
      pwd
      ls -la
      docker --version
      docker info
    '''

    def imageName  = args.imageName
    def imageTag   = args.imageTag
    def dockerfile = args.dockerfile ?: 'Dockerfile'
    def context    = args.context ?: '.'

    sh """
      set -x
      docker build \
        -t ${imageName}:${imageTag} \
        -f ${dockerfile} \
        ${context}
    """
}


#def call(String Project, String ImageTag){
 # sh "docker build -t ${Project}:${ImageTag} ."
#}
