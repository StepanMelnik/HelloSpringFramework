package com.sme.spring.mvc.configuration;

import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.server.Compression;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.stereotype.Component;

/**
 * Server container configuration.
 */
@Component
public class ServerCustomizer implements WebServerFactoryCustomizer<ConfigurableWebServerFactory>
{
    private static final int PORT = 8088;

    @Override
    public void customize(ConfigurableWebServerFactory factory)
    {
        factory.setPort(PORT);

        Compression compression = new Compression();
        compression.setEnabled(true);
        factory.setCompression(compression);
    }

    /**
     * Create Jetty server.
     * 
     * @return Returns {@link ConfigurableServletWebServerFactory} instance.
     */
    // @Bean
    public ConfigurableServletWebServerFactory webServerFactory()
    {
        JettyServletWebServerFactory factory = new JettyServletWebServerFactory();
        factory.setPort(PORT);
        factory.setContextPath("");
        return factory;
    }
}
