package com.sme.spring.mvc.configuration;

import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.ConfigurableTomcatWebServerFactory;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.boot.web.server.Compression;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.stereotype.Component;

import io.undertow.UndertowOptions;

/**
 * Server container configuration.
 */
@Component
public class ServerCustomizer implements WebServerFactoryCustomizer<ConfigurableTomcatWebServerFactory>
{
    private static final int PORT = 8088;

    @Override
    public void customize(ConfigurableTomcatWebServerFactory factory)
    {
        factory.setPort(PORT);

        Compression compression = new Compression();
        compression.setEnabled(true);
        factory.setCompression(compression);
    }

    // For SSL implementation
    //@Bean
    UndertowServletWebServerFactory undertowServletWebServerFactory()
    {
        UndertowServletWebServerFactory factory = new UndertowServletWebServerFactory();
        factory.addBuilderCustomizers();

        factory.addBuilderCustomizers(
                builder ->
                {
                    builder.setServerOption(UndertowOptions.ENABLE_HTTP2, true).setServerOption(UndertowOptions.HTTP2_SETTINGS_ENABLE_PUSH, true);
                });

        return factory;
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
