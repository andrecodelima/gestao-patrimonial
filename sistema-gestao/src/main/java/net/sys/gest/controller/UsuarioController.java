package net.sys.gest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import net.sys.gest.model.LoginRequest;
import net.sys.gest.model.Usuario;
import net.sys.gest.service.UsuarioDetailsServiceImplementation;
import net.sys.gest.service.UsuarioServiceInterface;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {


	@Autowired
	private UsuarioServiceInterface usuarioServiceInterface;
	
	@PostMapping("/login")
	public ResponseEntity<?>login(@RequestBody LoginRequest loginRequest){
		
		try {
			 Usuario usuario = usuarioServiceInterface.autenticaUsuario(loginRequest.getLogin(), loginRequest.getSenha());
			 return ResponseEntity.ok("Login realizado com sucesso para o usuário: " + usuario.getLogin() );
			 
		}catch (UsernameNotFoundException e) {
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado");
		
		}catch(RuntimeException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
		}
	}

	@PostMapping("/insertUsuarios")
	public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario){
		Usuario novoUsuario = usuarioServiceInterface.saveUsuario(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
	}

}