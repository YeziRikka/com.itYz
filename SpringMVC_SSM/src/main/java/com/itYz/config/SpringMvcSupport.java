package com.itYz.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class SpringMvcSupport extends WebMvcConfigurationSupport {
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
        registry.addResourceHandler("/pages/**").addResourceLocations("/pages/");
        registry.addResourceHandler("/plugins/**").addResourceLocations("/plugins/");
    }

//    //设置静态资源访问过滤，当前类需要设置为配置类，并被扫描加载
//
//    @Override
//    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//        //当访问/pages/????时候，从/pages目录下查找内容
//        registry.addResourceHandler("/pages/**").addResourceLocations("/pages/");
//        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
//        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
//        registry.addResourceHandler("/plugins/**").addResourceLocations("/plugins/");
//    }
}
