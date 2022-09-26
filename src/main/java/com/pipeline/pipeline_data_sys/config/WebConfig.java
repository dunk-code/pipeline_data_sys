package com.pipeline.pipeline_data_sys.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.annotation.PostConstruct;

/**
 * @author: zsy
 * @create: 2022-01-05 09:54
 **/
@Configuration
public class WebConfig {
    @Autowired
    private RequestMappingHandlerAdapter handlerAdapter;

    @PostConstruct
    public void initDateFormat() {
        ConfigurableWebBindingInitializer webBindingInitializer = (ConfigurableWebBindingInitializer) handlerAdapter.getWebBindingInitializer();
        if (webBindingInitializer.getConversionService() != null) {
            GenericConversionService conversionService = (GenericConversionService) webBindingInitializer.getConversionService();
            conversionService.addConverter(new StringToDateConverter());
        }
    }

    @Bean
    public BufferedImageHttpMessageConverter bufferedImageHttpMessageConverter() {
        return new BufferedImageHttpMessageConverter();
    }
}
