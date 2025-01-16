package net.sys.gest.service;

import java.util.Collection;

import net.sys.gest.model.Acesso;

public interface AcessoServiceInterface {

	public Acesso saveAcesso(Acesso acesso);
	public Boolean deleteAcesso(Long id);
	public Acesso findAcessoById(Long id);
	public Acesso editAcesso(Acesso acesso);

	public Collection<Acesso> getAllAcesso();
}
