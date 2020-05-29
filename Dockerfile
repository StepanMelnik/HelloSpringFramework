# The Docker file to build and run hello-spring-framework-mvc project.

## Build ##
### sudo docker build --no-cache -t hello-spring-framework-mvc:0.1" -f Dockerfile .
### sudo docker images -a | grep hello-spring-framework-mvc

## Check content ##
### sudo docker image save hello-spring-framework-mvc > hello-spring-framework-mvc.tar

## Check files in image ##
### sudo docker run --rm -it hello-spring-framework-mvc:0.1 find /home/usr/app

## Open image in bash and check all files
### sudo docker run --rm -it hello-spring-framework-mvc:0.1 bash
### cd /home/usr/app
### java -version
### exit

## Remove failed images with "none" tag if needed
### Remove all images with "none" tag or repository
### sudo docker images -a | grep none
### sudo docker rmi --force $(sudo docker images | grep "^<none" | awk '{print $3}')

## Run ##
### check what java version is in container: sudo docker run hello-spring-framework-mvc:0.1 java -version
### run: sudo docker run -p 8088:8088 hello-spring-framework-mvc:0.1 java -jar hello-spring-framework-mvc.jar


FROM maven:3.6.0-jdk-8-alpine

MAINTAINER Stepan stepan.melnik@gmail.com

LABEL maintainer="stepan.melnik@gmail.com"
LABEL version="0.1"
LABEL description="The Docker image to build Maven hello-spring-framework-mvc project"

ENV HOME=/home/usr/app/

#Possibility to set JVM options 
ENV JAVA_OPTS = ""

EXPOSE 8088

RUN echo "Create '$HOME' folder"
RUN mkdir -p $HOME 

COPY . $HOME
COPY pom.xml $HOME
RUN cat $HOME/pom.xml

RUN cat $HOME/settings.xml

WORKDIR $HOME

RUN mvn --version

RUN mvn -s settings.xml -B dependency:resolve dependency:resolve-plugins
#RUN mvn -s settings.xml -f pom.xml clean install
RUN mvn -s settings.xml -f pom.xml package

# Prepare artifact in the $HOME folder and remove all not needed sources
COPY hello-spring-framework-mvc/target/hello-spring-framework-mvc-0.0.0.Dev-SNAPSHOT.jar hello-spring-framework-mvc.jar
RUN rm -f -R -- */
RUN rm -f -R .git
RUN rm -f -R .settings

# The following section is disabled to open an image with bash or run java spring application
# Run java project
#FROM openjdk:8
#ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar hello-spring-framework-mvc.jar"]
#CMD ["java", "hello-spring-framework-mvc.jar"]

