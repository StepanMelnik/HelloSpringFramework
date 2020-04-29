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

