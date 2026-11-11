package com.yomna.gatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayserverApplication.class, args);
    }


    @Bean
    public RouteLocator myRouteConfig(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(route -> route
                        .path("/api/evenements/**")
                        .filters(f -> f.circuitBreaker(config -> config
                                .setName("evenementCircuitBreaker")
                                .setFallbackUri("forward:/contactAdmin")))
                        .uri("lb://EVENEMENT"))
                .route(route -> route
                        .path("/api/genres/**")
                        .uri("lb://GENRE"))
                .build();
    }

}