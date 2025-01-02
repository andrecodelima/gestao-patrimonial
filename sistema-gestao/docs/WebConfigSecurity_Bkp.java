package net.sys.gest.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import net.sys.gest.service.UsuarioDetailsServiceImplementation;

@Configuration
public class WebConfigSecurity {
	
	@Autowired
	private UsuarioDetailsServiceImplementation usuarioDetailsServiceImplementation;
	

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
	
	
//	ADAPTADO MAS SEM PERMITIR AINDA ACESSO AO PAINEL DO H2
	
////	@Bean
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
//	        )
//	        
//	        .csrf(csrf -> csrf
//	                .ignoringRequestMatchers("/h2-console/**") // Desativar CSRF para o H2
//	            )
//	        .headers(headers -> headers
//	                .frameOptions(frameOptions -> frameOptions.sameOrigin()) // Permitir exibição de frames do H2
//	            )
//	        .formLogin(form -> form // Configurar o login manualmente
//	                .permitAll() // Permitir acesso à página de login sem autenticação
//	            );
//	    
//	    return http.build();
//	}
	
	/*Irá consultar o user no banco com Spring Security*/
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usuarioDetailsServiceImplementation).passwordEncoder(new BCryptPasswordEncoder());
		
	}

	
}
