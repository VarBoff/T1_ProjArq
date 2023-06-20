package com.engsoft2.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {
	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p.path("/currency-exchange/**")
					.uri("lb://currency-exchange"))
				.route(p -> p.path("/currency-conversion/**")
					.filters(f -> f.circuitBreaker(c ->
						c.setName("circuitbreaker_conversion")
						.setFallbackUri("forward:/fallback/currency-conversion")))
					.uri("lb://currency-conversion"))
				.route(p -> p.path("/currency-conversion-feign/**")
					.uri("lb://currency-conversion"))
				.build();
	}
	/*
	@Bean
	public Customizer<Resilience4JCircuitBreakerFactory> defaulCustomizer() {
		return f -> f.configureDefault(id -> new Resilience4JConfigBuilder(id)
			.circuitBreakerConfig(CircuitBreakerConfig.custom()
				.slidingWindowSize(5)
				.permittedNumberOfCallsInHalfOpenState(3)
				.failureRateThreshold(50.0F)
				.build()
			)
			.timeLimiterConfig(TimeLimiterConfig.custom()
				.timeoutDuration(Duration.ofMillis(200))
				.build()
			)
			.build()
		);
	}
	*/
}
