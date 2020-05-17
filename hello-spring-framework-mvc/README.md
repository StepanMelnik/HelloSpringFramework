# Hello Spring MVC


## Description
The simple SpringMVC project to work with e-shop. 


### Run

* Update datasource.properties and setup MS Sql properties;

* Enable jpa properties in resources\jpa.properties to create sql schema;

* Open resources\sql\table\Article.sql and create data;

* Buid maven project;

* Run SimpleMvcApplication.java;

* Open http://localhost:8088/ in browser, create shopcart, customer and order.

### Useful
> JPA does not create sql schema in flexible way. Better to create sql scripts by hand like specified in resources\sql\table\Article.sql;

> The MVC project is "simple" and does not support Spring Security, error handling etc to avoid over complication;

> ServerCustomizer.java supports Tomcat or Jetty server creation;

> MvcConfiguration.java allows to work with JSTL, Tiles or Thymeleaf view.

### Asynchronous processing supported by Servlet 3.0

The project works with Asynchronous requests to get rid locking in the Pool of requests with slow services.

* http://localhost:8088/async/customers performs AsyncController controller that work with SlowService implementation to get all customers;
* http://localhost:8088/emitter/articles performs ResponseBodyEmitterController#find controller that fetches all articles step by step and sends a response to client
* http://localhost:8088/emitter/numbers performs ResponseBodyEmitterController#numbers controller that sends a piece of response to the client step by step.

### Servlet 4.0 support

PushController supports PushBuilder in http request based on Servlet4.

Do the following steps to support PushBuilder in Tomcat9:
  * generate SSL certificate by keytool: keytool -genkey -keyalg RSA -alias tomcat -keystore selfsigned.jks -validity 365 -keysize 2048
  * verfiy SSL certificate: keytool -list -v -keystore selfsigned.jks
  * put or replace selfsigned.jks in src\main\resources\ssl folder
  * update src\main\resources\ssl.properties
  * uncomment ssl.properties in PropertiesConfiguration
  * comment out "customize(ConfigurableTomcatWebServerFactory factory)" method in ServerCustomizer
  * enable "UndertowServletWebServerFactory undertowServletWebServerFactory()" bean
  * run application
  
Open Chrome browser and open https://localhost:8443/push.

The request should use HTTP2 (h2) protocol (check Protocol in Network window of DeveloperTools)
  
PushController should create PushBuilder properly in request.