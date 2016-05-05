package com.lifeix.football.timeline;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.lifeix.football.timeline.interceptor.UserSecurityInterceptor;

/**
 * 拦截器配置
 * 
 * @author zengguangwei
 *
 */
@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {
    private Logger logger = LoggerFactory.getLogger(WebConfiguration.class);

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserSecurityInterceptor());
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        logger.info("register cors start .....");
        registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowCredentials(false).maxAge(3600);
        logger.info("register cors end ..... ");
    }

}