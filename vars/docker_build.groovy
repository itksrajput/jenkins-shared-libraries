docker_build(
  imageName: 'laxg66/easyshop-app',
  imageTag: '10',
  dockerfile: 'Dockerfile'
)


#def call(String Project, String ImageTag){
 # sh "docker build -t ${Project}:${ImageTag} ."
#}
