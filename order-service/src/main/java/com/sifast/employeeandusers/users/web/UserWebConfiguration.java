package com.sifast.employeeandusers.users.web;

import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.sifast.swagger.CommonSwaggerConfiguration;

@Configuration
@Import(CommonSwaggerConfiguration.class)
@ComponentScan
public class UserWebConfiguration {

  @Bean
  public HttpMessageConverters customConverters() {
    HttpMessageConverter<?> additional = new MappingJackson2HttpMessageConverter();
    return new HttpMessageConverters(additional);
  }

}
