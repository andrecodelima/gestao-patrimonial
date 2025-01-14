package net.sys.gest.service;

import net.sys.gest.model.Usuario;

public interface UsuarioServiceInterface {

	Usuario saveUsuario(Usuario usuario);
	Usuario autenticaUsuario(String login, String senha);
	
}
