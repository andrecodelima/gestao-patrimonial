package net.sys.gest.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

	@Autowired
	private  CorsConfig corsConfig;
	
	@Autowired
	private  PublicEndpointsConfig publicEndpointsConfig;
	

	 @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http
	            .cors(cors -> cors.configurationSource(corsConfig.corsConfigurationSource()))
	            .csrf(csrf -> csrf.disable()) // Desativa CSRF globalmente
	            .authorizeHttpRequests(auth -> publicEndpointsConfig.configure(auth))
	            .httpBasic(httpBasic -> httpBasic.disable()) // Desativa autenticação básica
	            .formLogin(form -> form.disable()) // Desativa formulário de login
	            .csrf(csrf -> csrf.ignoringRequestMatchers(publicEndpointsConfig.getCsrfIgnoredEndpoints()))
	            .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.sameOrigin())); // Permite H2 Console
	        return http.build();
	    }
}
