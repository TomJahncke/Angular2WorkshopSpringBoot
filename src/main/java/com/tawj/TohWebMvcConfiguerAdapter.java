package com.tawj;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.concurrent.TimeUnit;

@Configuration
public class TohWebMvcConfiguerAdapter extends WebMvcConfigurerAdapter{

    private final String EXPLODED_PATH_KEY="exploded.path";

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
        if (!registry.hasMappingForPattern("/tohWebUi/**")) {
            ResourceHandlerRegistration tohWebUiResourceHandler = registry.addResourceHandler("/tohWebUi/**");

            String explodedPath = System.getProperty(EXPLODED_PATH_KEY);
            if (explodedPath != null && !explodedPath.isEmpty()) {
                tohWebUiResourceHandler.addResourceLocations(explodedPath);
                tohWebUiResourceHandler.setCacheControl(CacheControl.noCache());
            } else {
                tohWebUiResourceHandler.addResourceLocations(
                        "classpath:/META-INF/resources/tohWebUi/");
                tohWebUiResourceHandler.setCacheControl(CacheControl.maxAge(1, TimeUnit.DAYS));
            }


        }
    }
}
