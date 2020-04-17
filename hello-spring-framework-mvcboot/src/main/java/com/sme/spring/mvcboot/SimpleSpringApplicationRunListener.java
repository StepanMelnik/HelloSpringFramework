package com.sme.spring.mvcboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Implementation of {@link SpringApplicationRunListener}.
 */
public class SimpleSpringApplicationRunListener implements SpringApplicationRunListener
{
    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleSpringApplicationRunListener.class);

    private final long start;

    @SuppressWarnings("unused")
    private final SpringApplication application;
    @SuppressWarnings("unused")
    private final String[] args;

    public SimpleSpringApplicationRunListener(SpringApplication application, String[] args)
    {
        this.application = application;
        this.args = args;
        start = System.currentTimeMillis();
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context)
    {
        LOGGER.debug("Context loaded");
    }

    @Override
    public void started(ConfigurableApplicationContext context)
    {
        LOGGER.debug("Context started");
        SimpleApplicationEventData simpleApplicationEventData = context.getBean(SimpleApplicationEventData.class);
        simpleApplicationEventData.setStart(start);
        simpleApplicationEventData.setFinish(System.currentTimeMillis());
    }

    @Override
    public void running(ConfigurableApplicationContext context)
    {
        LOGGER.debug("Context running");
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context)
    {
        LOGGER.debug("Context prepared");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception)
    {
        LOGGER.error("Context failed", exception);
    }
}
