package net.sys.gest.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

	@Bean
	public WebMvcConfigurer  corsConfigurer() {
		return new WebMvcConfigurer() {
			
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				 // Permite requisições de Angular rodando em http://localhost:4200
		        registry.addMapping("/api/**") // Define o padrão para os endpoints que você deseja liberar
		                .allowedOrigins("http://localhost:4200") // Permite o frontend do Angular
		                .allowedMethods("GET", "POST", "PUT", "DELETE") // Permite os métodos especificados
		                .allowCredentials(true) // Permite credenciais como cookies ou headers de autorização
		                .maxAge(3600); // Define o tempo de cache para as configurações de CORS
			}
		
		};
	}
}
