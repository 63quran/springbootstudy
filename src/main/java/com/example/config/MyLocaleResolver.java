package com.example.config;

import com.sun.corba.se.spi.resolver.LocalResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        //获取参数
        String l = request.getParameter("l");
        Locale locale = Locale.getDefault();//如果没有就使用默认的
        if (!StringUtils.isEmpty(l)){
            //解析参数
            String[] split = l.split("_");

            locale = new Locale(split[0],split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
