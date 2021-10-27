package com.hackathon.miniurl.config;

import java.io.File;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String location;
//        if (Arrays.stream(environment.getActiveProfiles())
//                .anyMatch(env -> "local".equalsIgnoreCase(env))) {
            String currentPath = new File(".").getAbsolutePath();
            location = "file:///" + currentPath + "/src/main/resources/public/";
//        } else {
//            location = "classpath:/public/";
//        }

        registry.addResourceHandler("/**")
                .addResourceLocations(location);
    }

//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        if (Arrays.stream(environment.getActiveProfiles())
//                .anyMatch(env -> "local".equalsIgnoreCase(env)
//                                        || env.equalsIgnoreCase("docker") )) {
//            registry.addMapping("/**").allowedOrigins("http://localhost:8080");
//        }
//    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.defaultContentType(MediaType.APPLICATION_JSON);
    }
}
