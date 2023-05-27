package com.protocolManagement.backend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
public class ResourceServerConfig {

	@Value("${cors.origins}")
	private String corsOrigins;

	@Autowired
	private Environment env;

	@Autowired
	private JwtTokenStore tokenStore;

	private static final String[] USER = {
			"/products/**",
			"/categories/**",
			"/oauth/token",
			"/h2-console/**",
			"/register/**",
			"/users/**",
			"/account/**",
			"/adresses/**",
			"/orders/**",
			"/checkout/**",
			"/reviews/**",
			"/discounts/**",
			"/api/v2/**"
	};

	private static final String[] OPERATOR = { };

	private static final String[] ADMIN = { "/admin/**" };

	@Bean
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.tokenStore(tokenStore);
	}

	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests((authorize) -> authorize
						.requestMatchers(USER).permitAll()
						.requestMatchers(HttpMethod.POST, USER).permitAll()
						.requestMatchers(USER).hasAnyRole("USER", "ADMIN")
						.requestMatchers(ADMIN).hasRole("ADMIN")
						.anyRequest().authenticated())
				.cors(cors -> {
					UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
					CorsConfiguration config = new CorsConfiguration();
					// Configurar as opções permitidas para o CORS
					source.registerCorsConfiguration("/**", config);
					cors.configurationSource(source);
				});

		return http.build();
	}


	@Bean
	CorsConfigurationSource corsConfigurationSource() {

		String[] origins = corsOrigins.split(",");

	    CorsConfiguration corsConfig = new CorsConfiguration();
	    corsConfig.setAllowedOriginPatterns(Arrays.asList(origins));
	    corsConfig.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "PATCH"));
	    corsConfig.setAllowCredentials(true);
		//corsConfig.addAllowedHeader("*");
	    corsConfig.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));

	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", corsConfig);
	    return source;
	}
	@Bean
	FilterRegistrationBean<CorsFilter> corsFilter() {
	    FilterRegistrationBean<CorsFilter> bean
	            = new FilterRegistrationBean<>(new CorsFilter(corsConfigurationSource()));
	    bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
	    return bean;
	}
}

