# Hello Spring MVC Boot


## Description
Simple application to start a simple web application in Tomcat.


### How it works 

SimpleMvcApplication performs Spring boot:
- WebApplicationType looks for javax.servlet.Servlet or org.springframework.web.context.ConfigurableWebApplicationContext in classpath
- StandardServletEnvironment creates ServletContext and ServletConfig
- SpringApplication#createApplicationContext creates AnnotationConfigServletWebServerApplicationContext instance
- StandardServletEnvironment created by AnnotationConfigServletWebServerApplicationContext instance
- ServletWebServerApplicationContext#createWebServer initializes Tomcat as default server by ServletWebServerFactory
- ServletWebServerApplicationContext#finishRefresh starts Tomcat (creates connector and binds context) 
