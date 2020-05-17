package com.sme.spring.mvc.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

/**
 * Spring Properties configuration.
 */
@Configuration
public class PropertiesConfiguration
{
    /**
     * Create properties configuration bean.
     * 
     * @return Returns {@link PropertySourcesPlaceholderConfigurer} instance.
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer properties()
    {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        configurer.setLocations(new ClassPathResource("application.properties"),
                new ClassPathResource("datasource.properties"),
                new ClassPathResource("jpa.properties"),
                //new ClassPathResource("ssl.properties"),
                new ClassPathResource("view.properties"));

        return configurer;
    }
}
