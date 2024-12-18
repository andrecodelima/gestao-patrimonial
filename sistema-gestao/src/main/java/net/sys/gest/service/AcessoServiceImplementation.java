package net.sys.gest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sys.gest.model.Acesso;
import net.sys.gest.repository.AcessoRepository;

@Service
public class AcessoServiceImplementation implements AcessoServiceInterface {

	@Autowired
	private AcessoRepository acessoRepository;
	
	
	@Override
	public Acesso saveAcesso(Acesso acesso) {
		
		return acessoRepository.save(acesso);
	}

	
}
