package net.sys.gest.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.http.HttpMethod;

@Configuration
public class PublicEndpointsConfig {

    public void configure(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry auth) {
        auth
            .requestMatchers("/h2-console/**").permitAll()
            .requestMatchers(HttpMethod.POST, "/saveAcesso").permitAll()
            .requestMatchers(HttpMethod.POST, "/usuarios/login", "/usuarios/insertUsuarios").permitAll()
            .requestMatchers(HttpMethod.POST, "/empresa/insertEmpresa").permitAll()
            
            .requestMatchers(HttpMethod.GET, "/acessos", "/getAllAcessos", "/findAcessoById/**", "/empresa/getAllEmpresa").permitAll()
            
            .requestMatchers(HttpMethod.DELETE, "/deleteAcesso/**").permitAll()
            
            .requestMatchers(HttpMethod.PUT, "/editAcesso/**").permitAll()
            
            .requestMatchers("/api/**").permitAll()
            .anyRequest().authenticated();
    }

    public String[] getCsrfIgnoredEndpoints() {
        return new String[]{
            "/h2-console/**", 
            "/saveAcesso", 
            "/editAcesso/**", 
            "/deleteAcesso/**", 
            "/usuarios/insertUsuarios",  
            "/usuarios/login",
            "/empresa/insertEmpresa"
        };
    }
}
