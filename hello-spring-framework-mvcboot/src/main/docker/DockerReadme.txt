# Create docker by hand:

# mvn install
# cp target/hello-spring-framework-mvcboot-0.0.0.Dev-SNAPSHOT.jar src/main/docker
# cd src/main/docker
# sudo docker build --tag sme/simple-mvc-boot:0.1 .

# Check created image
sudo docker images | grep sme/simple-mvc-boot

sudo docker run --rm -it sme/simple-mvc-boot:0.1 bash
> cd /usr/local/simplemvcboot
> java -version
> ps aux | grep java
> exit

# Start image in Docker
sudo docker run -p 8040:8040 --rm -it sme/simple-mvc-boot:0.1 ./run.sh
sudo docker run -p 8040:8040 -v /var/log/microservices:/ --rm -it sme/simple-mvc-boot:0.1 ./run.sh	<-- share logs

# Connect to image
sudo docker ps | grep simple-mvc-boot
sudo docker exec -it 018c944eb45f /bin/bash
top
ps aux | greo java
ip route list
route
netstat
exit