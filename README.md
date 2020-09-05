# Hello Spring Framework


## Description
A simple Maven project to work with different Spring modules.


### Modules

The following modules work with Spring Framework:
- **hello-spring-framework-boot** module runs and tests a simple Spring Boot application based on Spring IOC;
- **hello-spring-framework-mvcboot** module runs and tests a simple Spring MVC application in Tomcat;
- **hello-spring-framework-mvc** runs a simple e-shop application based on JPA persistence.

**hello-spring-framework-mvc** module works with Asynchronous processing supported by Servlet 3.0 version.
Also the module works with **PushBuilder** supported by Servlet 4.0 version.

## Build

Clone and install <a href="https://github.com/StepanMelnik/Parent.git">Parent</a> project before building.

### Maven

Add hello-spring-framework-mvc\src\main\resources\datasource.properties:

> sh "rm -f datasource.properties> /dev/null"

> sh "echo spring.datasource.driverClassName=com.microsoft.sqlserver.jdbc.SQLServerDriver >> datasource.properties"

> sh "echo spring.datasource.url=jdbc:sqlserver://repository.sme.com\\;databaseName=SpringTestCust >> datasource.properties"

> sh "echo spring.datasource.username=developer >> datasource.properties"

> sh "echo spring.datasource.password=secret >> datasource.properties"

> sh "echo spring.jpa.show-sql=true >> datasource.properties"

> sh "cp datasource.properties hello-spring-framework-mvc/src/main/resources/datasource.properties"

Build by maven

> mvn clean install

### Docker
Check Header in the Dockerfile how to create and run an image of the project.

### Kubernetes
**hello-spring-framework-mvcboot** project creates allows to create a docker image and allows to deploy the image in MiniKube.

All scripts are in "hello-spring-framework-mvcboot\src\main\docker" folder:

- **Dockerfile** - docker file to create an image
- **run.sh** - runs simple-mvcboot application
- **simple-mvcboot-pod.yaml** - creates a pod in MiniKube
- **simple-mvcboot-service.yaml** - creates a service in MiniKube
- **simple-mvcboot-replicationcontroller.yaml** - creates a replication controller in MiniKube.
- **DockerReadme.txt** describes all steps to build, create, check sme/simple-mvc-boot:0.1 docker image
- **MiniCubeReadme.txt** descibes all steps to deploy a pod, service and replication controller in MiniKube and check/describe the entities.


#### Production

Do not create Pod (sudo kubectl create -f simple-mvcboot-pod.yaml) in production.

Use the following command instead as follow:

1. **create a Deployment** (pod + replication controller):
    - kubectl apply -f simple-mvcboot-deployment.yaml
    - kubectl get pods
    - kubectl describe pod simple-mvcboot
2. **create a service**:
    - kubectl apply -f simple-mvcboot-service.yaml
    - kubectl get services
3. **open service in browser**: 10.98.48.233:8040
4. **cleanup**
    - kubectl delete -f simple-mvcboot-service.yaml
    - kubectl delete -f simple-mvcboot-deployment.yaml
