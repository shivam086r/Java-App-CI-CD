# Deploying Java App on dockerhub through containerized jenkins maven docker and .
# EC2 Instance conf.

Ubuntu 20.04 (LTS)x64
T2.medium 4gb ram 80gb disk
Allowing port 22 & 8080

# Connecting it through cli-
 ssh  -I Downloads/keyname.pem ubuntu@Ip

#### we are installing Jenkins as a container so we don’t need to install jdk (java) we only need docker 
sudo –i
apt update
apt install docker.io -y
docker

#### Exposing  ports , mounting volume & Setting up Jenkins through docker image
docker run -p 8080:8080 -p 50000:50000 -d -v jenkins_home:/var/jenkins_home jenkins/jenkins:lts

# coping ip and  pasting on browser and initializing Jenkins

docker exec –it containerID bash

cat jenkins path for password, coping it and pasting on Jenkins ui

exit   (exiting from container)

docker volume inspect jenkins_home 

cat /var/lib/docker/volumes/Jenkins_home/_data/secrets/initialAdminPassword 

# Creating Jenkins user installing plugins automatically

Installing Build  Tools
Jenkins > Global tool Conf.
 Installing (Name) - Maven-3.6  automatically through apache              >  Save

docker exec –u 0 –it containerID bash (logging in as a root user inside container)

docker run -p 8080:8080 -p 50000:50000 -d -v jenkins_home:/var/jenkins_home -v /var/run/docker.sock:/var/run/docker.sock -v $(which docker):/usr/bin/docker jenkins/jenkins:lts

docker exec -u 0 -it containerid bash
chmod +666 /var/run/docker.sock

#### Git credentials
#### Creating Dockerhub repo
#### Dockerhub credential
#### Writing Jenkins file
# (jenkinsfile and all the neccesary files are available on jenkins-job branch)


