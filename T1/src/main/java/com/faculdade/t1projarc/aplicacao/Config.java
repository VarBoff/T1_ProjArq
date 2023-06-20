package com.faculdade.t1projarc.aplicacao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;

import java.nio.charset.Charset;
import java.util.Collections;

@Configuration
    public class Config {
        @Bean
        public StringHttpMessageConverter stringHttpMessageConverter() {
            StringHttpMessageConverter converter = new StringHttpMessageConverter();
            converter.setDefaultCharset(Charset.forName("UTF-8"));
            converter.setSupportedMediaTypes(Collections.singletonList(MediaType.TEXT_PLAIN));
            return converter;
        }

}
