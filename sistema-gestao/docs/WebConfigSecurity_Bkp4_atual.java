package net.sys.gest.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import java.util.List;

@Configuration
public class WebConfigSecurity {
	
// CONFIGURAÇÃO DO JWT ADIADA
	
//	ADAPTADO MAS SEM PERMITIR AINDA ACESSO AO PAINEL DO H2
	
@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	 http
	 
			 .cors(cors -> cors.configurationSource(request -> {
		         CorsConfiguration config = new CorsConfiguration();
		         config.addAllowedOrigin("*"); // Permitir todas as origens. Use domínios específicos em produção.
		         config.addAllowedMethod("*"); // Permitir todos os métodos HTTP.
		         config.addAllowedHeader("*"); // Permitir todos os cabeçalhos.
		         config.setExposedHeaders(List.of("Authorization")); // Exponha cabeçalhos específicos, se necessário.
		         return config;
		     }))
	 		.csrf(csrf -> csrf.disable()) // Desativa CSRF globalmente
		     .authorizeHttpRequests(auth -> auth
		         .requestMatchers("/h2-console/**").permitAll()  
		         .requestMatchers(HttpMethod.POST, "/saveAcesso").permitAll()  
		         .requestMatchers(HttpMethod.POST, "/usuarios/login", "/usuarios/insertUsuarios", " /usuarios/login").permitAll()  
		         
		         .requestMatchers(HttpMethod.GET, "/acessos", "/getAllAcessos", "/findAcessoById/**").permitAll()  
		         .requestMatchers(HttpMethod.DELETE, "/acessos", "/deleteAcesso/**").permitAll() 
		         .requestMatchers(HttpMethod.PUT, "/editAcesso/**").permitAll()  
		         .requestMatchers("/api/**").permitAll()  
		         .anyRequest().authenticated()  
		     )
		     .httpBasic(httpBasic -> httpBasic.disable())  
		     .formLogin(form -> form.disable())  
		     .csrf(csrf -> csrf
		         .ignoringRequestMatchers("/h2-console/**", "/saveAcesso", "/editAcesso/**", "/deleteAcesso/**","/usuarios/insertUsuarios",  "/usuarios/login" ) // Desativa CSRF para o H2 Console
		     )
		     .headers(headers -> headers
		         .frameOptions(frameOptions -> frameOptions.sameOrigin()) // Permite exibição de frames do H2 Console
		     );

	 return http.build();	
	}
	
	
    @Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	
}
