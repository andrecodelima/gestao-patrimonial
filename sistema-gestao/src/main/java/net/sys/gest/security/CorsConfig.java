package net.sys.gest.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
public class CorsConfig {

    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*"); // Permitir todas as origens
        config.addAllowedMethod("*"); // Permitir todos os métodos HTTP
        config.addAllowedHeader("*"); // Permitir todos os cabeçalhos
        config.setExposedHeaders(List.of("Authorization")); // Expor cabeçalhos necessários

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config); // Aplicar configurações globalmente
        return source;
    }
}
