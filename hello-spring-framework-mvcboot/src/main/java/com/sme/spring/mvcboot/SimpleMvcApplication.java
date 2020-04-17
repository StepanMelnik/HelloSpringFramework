package com.sme.spring.mvcboot;

import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Simple Spring Boot application to start Spring MVC in Tomcat container.
 */
@RestController
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.sme.spring.mvcboot"})
@Configuration(proxyBeanMethods = false)
public class SimpleMvcApplication
{
    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleMvcApplication.class);

    @RequestMapping("/")
    String home()
    {
        return "Hello SimpleMvcApplication Boot!";
    }

    /**
     * The main entry point to start Spring MVC application by Spring Boot.
     * 
     * @param args The array of input parameters.
     */
    public static void main(String[] args)
    {
        ConfigurableApplicationContext context = SpringApplication.run(SimpleMvcApplication.class, args);
        SimpleApplicationEventData simpleApplicationEventData = context.getBean(SimpleApplicationEventData.class);
        LOGGER.info("Started at {} and finished at {}", new Timestamp(simpleApplicationEventData.getStart()).toLocalDateTime(),
                new Timestamp(simpleApplicationEventData.getFinish()).toLocalDateTime());
    }
}
