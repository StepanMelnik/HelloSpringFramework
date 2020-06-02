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
