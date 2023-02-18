package com.zhang.springboot.config;

import org.apache.tomcat.util.descriptor.LocalResolver;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
import java.util.Map;

public class MyLocalResolver implements LocaleResolver {

    //解析清求
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String lanuage = request.getParameter("l");
        Locale locale = Locale.getDefault(); //默认
        //不为空，携带国际化参数
        if (!StringUtils.isEmpty(lanuage)){
            String[] split = lanuage.split("_");
            locale = new Locale(split[0], split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
