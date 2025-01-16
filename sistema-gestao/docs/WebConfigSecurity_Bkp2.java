package net.sys.gest.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebConfigSecurity {
	
// CONFIGURAÇÃO DO JWT ADIADA
	
//	ADAPTADO MAS SEM PERMITIR AINDA ACESSO AO PAINEL DO H2
	
@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    http
	        .csrf(csrf -> csrf.disable()) // Desativa CSRF, útil para APIs REST
	        .authorizeHttpRequests(auth -> auth
	        	
	        	.requestMatchers("/h2-console/**").permitAll()
	            .requestMatchers(HttpMethod.POST, "/saveAcesso").permitAll() // Permite acesso sem autenticação
	            .requestMatchers(HttpMethod.GET, "/acessos", "/getAllAcessos","/findAcessoById/**").permitAll() // Permite acesso sem autenticação
	            .requestMatchers(HttpMethod.DELETE, "/acessos", "/deleteAcesso/**").permitAll() // Permite acesso sem autenticação
	            .requestMatchers(HttpMethod.PUT, "/editAcesso/**").permitAll() // Permite acesso sem autenticação
	            .anyRequest().authenticated() // Exige autenticação para outras URLs
	            .requestMatchers("/api/**").permitAll() // Permite requisições para a API sem autenticação

	        )
	        
	        .httpBasic(httpBasic -> httpBasic.disable()) // Desabilita autenticação HTTP básica
            .formLogin(form -> form.disable()) // Desativa formulário de login
	        
//	    .formLogin(form -> form // Configurar o login manualmente
//                .permitAll() // Permitir acesso à página de login sem autenticação
//            );
	    
	        .csrf(csrf -> csrf
	                .ignoringRequestMatchers("/h2-console/**") // Desativar CSRF para o H2
	            )
	        .headers(headers -> headers
	                .frameOptions(frameOptions -> frameOptions.sameOrigin()) // Permitir exibição de frames do H2
	            );
	       
	    
	    return http.build();
	}
	


	
}
