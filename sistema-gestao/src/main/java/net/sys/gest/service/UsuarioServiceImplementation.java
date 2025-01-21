package net.sys.gest.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import net.sys.gest.model.Usuario;
import net.sys.gest.repository.UsuarioRepository;

@Service
public class UsuarioServiceImplementation implements UsuarioServiceInterface {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	LocalDateTime dataAtual = LocalDateTime.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	String dataFormatada = dataAtual.format(formatter);
	
	LocalDateTime dataConvertida = LocalDateTime.parse(dataFormatada, formatter);

	
	@Override
	public Usuario saveUsuario(Usuario usuario) {
		 usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
		 usuario.setDataCriacao(dataConvertida);
		return usuarioRepository.save(usuario);
	}

	@Override
	public Usuario autenticaUsuario(String login, String senha) {
		Usuario usuario = usuarioRepository.findUsuarioByLogin(login);
		
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuario não encontrado");
		}
		
		if(!new BCryptPasswordEncoder().matches(senha, usuario.getSenha())) {
			throw new RuntimeException("Credencias inválidas");
		}
		
		return usuario;
	}

	
	
}
