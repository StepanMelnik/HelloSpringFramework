package com.sme.spring.mvc.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

import com.sme.spring.mvc.interceptor.SessionInterceptor;

/**
 * Spring MVC configuration.
 */
@Configuration
@EnableWebMvc
public class MvcConfiguration implements WebMvcConfigurer
{
    // CSOFF
    /*
    @Bean
    @Description("JSTL view resolver")
    public ViewResolver getViewResolver()
    {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/view/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        resolver.setViewClass(TilesView.class);
        return resolver;
    }
    */

    @Bean
    @Description("Tiles view resolver")
    public ViewResolver getViewResolver()
    {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        //        resolver.setPrefix("/WEB-INF/jsp/");
        //        resolver.setSuffix(".jsp");
        resolver.setViewClass(TilesView.class);
        return resolver;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer)
    {
        configurer.enable();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        registry.addInterceptor(new SessionInterceptor());
    }

    @Bean
    public TilesConfigurer tilesConfigurer()
    {
        TilesConfigurer configurer = new TilesConfigurer();
        configurer.setDefinitions(new String[] {"/WEB-INF/tiles/tiles.xml"});
        return configurer;
    }

    /*
    @Bean
    @Description("Thymeleaf view resolver")
    public ViewResolver getViewResolver()
    {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        resolver.setCharacterEncoding("UTF-8");
        return resolver;
    }
    @Bean
    @Description("Thymeleaf template engine with Spring integration")
    public SpringTemplateEngine templateEngine()
    {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        return templateEngine;
    }
    @Bean
    @Description("Thymeleaf template resolver serving HTML 5")
    public ClassLoaderTemplateResolver templateResolver()
    {
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix("template/");
        templateResolver.setCacheable(false);
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML5");
        templateResolver.setCharacterEncoding("UTF-8");
        return templateResolver;
    }
    */

    // CSON
}
