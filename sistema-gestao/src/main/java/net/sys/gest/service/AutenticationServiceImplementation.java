package net.sys.gest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import net.sys.gest.model.Usuario;
import net.sys.gest.repository.UsuarioRepository;
import net.sys.gest.security.PasswordEncoderConfig;

@Service
public class AutenticationServiceImplementation implements AuthenticationServiceInterface{


	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PasswordEncoderConfig passEncoder;

	@Override
	public Usuario autenticaUsuario(String login, String senha) {
		Usuario usuario = usuarioRepository.findUsuarioByLogin(login);
		
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuario não encontrado");
		}
		
		
		if(!passEncoder.passwordEncoder().matches(senha, usuario.getSenha())) {
			throw new RuntimeException("Credencias inválidas");

		}
		
		return usuario;
	}
	
	
 

}
