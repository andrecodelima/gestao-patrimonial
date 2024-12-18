package net.sys.gest.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebConfigSecurity {

	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/h2-console/**").permitAll() // Permitir acesso ao H2
                .anyRequest().authenticated()
            )
            .csrf(csrf -> csrf
                .ignoringRequestMatchers("/h2-console/**") // Desativar CSRF para o H2
            )
            .headers(headers -> headers
                .frameOptions(frameOptions -> frameOptions.sameOrigin()) // Permitir exibição de frames do H2
            )
            .formLogin(); // Habilitar login padrão para as outras rotas

        return http.build();
    }
	
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//	    http
//	        .csrf(csrf -> csrf.disable()) // Desativa CSRF, útil para APIs REST
//	        .authorizeHttpRequests(auth -> auth
//	        	
//	        	.requestMatchers("/h2-console/**").permitAll()
//	            .requestMatchers(HttpMethod.POST, "/saveAcesso").permitAll() // Permite acesso sem autenticação
//	            .requestMatchers(HttpMethod.GET, "/acessos").permitAll() // Permite acesso sem autenticação
//	            .requestMatchers(HttpMethod.DELETE, "/acessos", "/deleteAcesso").permitAll() // Permite acesso sem autenticação
//	            .anyRequest().authenticated() // Exige autenticação para outras URLs
//	        );
//	    return http.build();
//	}
	
	
}
