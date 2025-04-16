package net.sys.gest.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import net.sys.gest.model.Usuario;
import net.sys.gest.repository.UsuarioRepository;
import net.sys.gest.security.PasswordEncoderConfig;
import net.sys.gest.utils.DateUtils;

@Service
public class UsuarioServiceImplementation implements UsuarioServiceInterface {

	@Autowired
	private  UsuarioRepository usuarioRepository;
	
	LocalDateTime dataAtual = DateUtils.getCurrentDateTime();
	String dataFormatada = DateUtils.format(dataAtual);
	LocalDateTime dataConvertida = DateUtils.parse(dataFormatada);
	
	
	@Override
	public Usuario saveUsuario(Usuario usuario) {
		 usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
		 usuario.setDataCriacao(dataConvertida);
		return usuarioRepository.save(usuario);
	}



	
	
}
