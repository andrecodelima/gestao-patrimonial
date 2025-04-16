package net.sys.gest.service;

import net.sys.gest.model.Usuario;

public interface AuthenticationServiceInterface {
	
	
	public Usuario autenticaUsuario(String login, String senha);
}
