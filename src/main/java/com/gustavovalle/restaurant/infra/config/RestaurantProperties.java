package com.gustavovalle.restaurant.infra.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
@ConfigurationProperties(prefix = "restaurant")
public class RestaurantProperties {
    private CorsConfiguration cors;

    public CorsConfiguration getCors() {
        return cors;
    }

    public void setCors(CorsConfiguration cors) {
        this.cors = cors;
    }
}
