#!/bin/sh

echo "********************************************************"
echo "Starting the articleservice"
echo "********************************************************"
java -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=default -Dserver.port=8040 -jar /usr/local/simplemvcboot/hello-spring-framework-mvcboot-0.0.0.Dev-SNAPSHOT.jar
