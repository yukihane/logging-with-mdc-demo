package com.example.loggingwithmdcdemo;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

@Configuration
public class MyConfig {

    // https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#howto-add-a-servlet-filter-or-listener
    @Bean
    public FilterRegistrationBean<MDCFilter> mdcFilter() {
        final FilterRegistrationBean<MDCFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new MDCFilter());
        bean.addUrlPatterns("/*");
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }
}
