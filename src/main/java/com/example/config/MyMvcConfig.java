package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//如果要扩展springmvc，官方建议这么写！
@Configuration
//@EnableWebMvc //这个注解就是导入一个类:DelegatingWebMvcConfiguration:从容器中获取所有的wevmvcconfig；
public class MyMvcConfig implements WebMvcConfigurer {
    //添加一个自定义视图跳转
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("index");
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/login.html","/","/login",
                        "/user/login","/css/*","/js/**","/image/**",
                        "/images/**","/font/**","/picture/**","/file/**");
    }
}
