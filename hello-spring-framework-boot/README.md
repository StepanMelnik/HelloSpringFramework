# Hello Spring Boot


## Description
Simple application to start Spring container by Spring Boot.


### Usage

Maven project describes all spring maven dependencies in Dependency Management and still use own parent.

SimpleApplication uses pure java launcher to start Spring IOC by Spring Boot library. 
    
    <parent>
        <groupId>com.sme.spring</groupId>
        <artifactId>hello-spring-framework</artifactId>
        <version>0.0.0.Dev-SNAPSHOT</version>
    </parent>
    <!-- The parent is imported as pom type. @see dependencies -->
    <!--parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.2.6.RELEASE</version>
        <relativePath />
    </parent-->

### Read More
https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/