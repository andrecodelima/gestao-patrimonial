package net.sys.gest.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebConfigSecurity {
	
// CONFIGURAÇÃO DO JWT ADIADA
	
//	ADAPTADO MAS SEM PERMITIR AINDA ACESSO AO PAINEL DO H2
	
@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	 http
	 		.csrf(csrf -> csrf.disable()) // Desativa CSRF globalmente
		     .authorizeHttpRequests(auth -> auth
		         .requestMatchers("/h2-console/**").permitAll() // Permite acesso ao H2 Console
		         .requestMatchers(HttpMethod.POST, "/saveAcesso").permitAll() // Permite acesso sem autenticação
		         .requestMatchers(HttpMethod.POST, "/usuarios/login", "/usuarios/insertUsuarios").permitAll() // Permite acesso sem autenticação
		         
		         .requestMatchers(HttpMethod.GET, "/acessos", "/getAllAcessos", "/findAcessoById/**").permitAll() // Permite acesso sem autenticação
		         .requestMatchers(HttpMethod.DELETE, "/acessos", "/deleteAcesso/**").permitAll() // Permite acesso sem autenticação
		         .requestMatchers(HttpMethod.PUT, "/editAcesso/**").permitAll() // Permite acesso sem autenticação
		         .requestMatchers("/api/**").permitAll() // Permite requisições para a API sem autenticação
		         .anyRequest().authenticated() // Exige autenticação para outras URLs
		     )
		     .httpBasic(httpBasic -> httpBasic.disable()) // Desabilita autenticação HTTP básica
		     .formLogin(form -> form.disable()) // Desativa formulário de login
		     .csrf(csrf -> csrf
		         .ignoringRequestMatchers("/h2-console/**", "/saveAcesso", "/editAcesso/**", "/deleteAcesso/**","/usuarios/insertUsuarios" ) // Desativa CSRF para o H2 Console
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
