package com.sme.spring.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Simple SpringMVC application thatprovides simple e-shop implementation.
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.sme.spring.mvc"})
@Configuration(proxyBeanMethods = false)
public class SimpleMvcApplication
{
    /**
     * Main entry point.
     * 
     * @param args The list of arguments.
     */
    public static void main(String[] args)
    {
        SpringApplication.run(SimpleMvcApplication.class, args);
    }
}
