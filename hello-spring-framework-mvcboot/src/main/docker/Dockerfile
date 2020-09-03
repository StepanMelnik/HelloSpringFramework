FROM openjdk:8-jdk-alpine

LABEL maintainer="stepan.melnik@gmail.com"
LABEL version="0.1"
LABEL description="The Docker image to start a simple spring mvc boot application"

RUN  apk update && apk upgrade && apk add netcat-openbsd bash
RUN mkdir -p /usr/local/simplemvcboot
ADD hello-spring-framework-mvcboot-0.0.0.Dev-SNAPSHOT.jar /usr/local/simplemvcboot/
ADD run.sh run.sh
RUN chmod +x run.sh
CMD ./run.sh
