package com.sme.spring.boot;

import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Simple application started by spring boot.
 * <p>
 * The application creates {@link SimpleApplicationEventData} component in Spring IOC and initializes data by
 * {@link SimpleSpringApplicationRunListener} listener.
 * </p>
 */
@SpringBootApplication
public class SimpleApplication
{
    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleSpringApplicationRunListener.class);

    /**
     * Main entry point.
     * 
     * @param args The list of arguments.
     */
    public static void main(String[] args)
    {
        ConfigurableApplicationContext context = SpringApplication.run(SimpleApplication.class, args);
        SimpleApplicationEventData simpleApplicationEventData = context.getBean(SimpleApplicationEventData.class);
        LOGGER.info("Started at {} and finished at {}", new Timestamp(simpleApplicationEventData.getStart()).toLocalDateTime(),
                new Timestamp(simpleApplicationEventData.getFinish()).toLocalDateTime());
    }
}
