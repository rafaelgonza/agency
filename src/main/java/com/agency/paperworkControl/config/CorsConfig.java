package com.agency.paperworkControl.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {
  @Bean
  public FilterRegistrationBean<CorsFilter> corsFilterRegistrationBean() {

    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

    CorsConfiguration config = new CorsConfiguration();
    config.setAllowCredentials(true);
    config.addAllowedOrigin("*");
    config.addAllowedHeader("Authorization");
    config.addAllowedHeader("Content-Type");
    config.addAllowedHeader("accidentCode");
    config.addAllowedHeader("companyCode");
    config.addAllowedHeader("provenanceCode");
    config.addAllowedHeader("Accept");
    config.addAllowedMethod("POST");
    config.addAllowedMethod("PATCH");
    config.addAllowedMethod("GET");
    config.addAllowedMethod("DELETE");
    config.addAllowedMethod("PUT");
    config.addAllowedMethod("OPTIONS");
    config.addAllowedMethod("PATCH");
    source.registerCorsConfiguration("/**", config); // Global for all paths

    FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
    bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
    return bean;
  }
}
