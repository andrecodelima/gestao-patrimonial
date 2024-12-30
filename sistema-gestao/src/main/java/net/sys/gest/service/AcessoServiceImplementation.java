package net.sys.gest.service;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import net.sys.gest.model.Acesso;
import net.sys.gest.repository.AcessoRepository;

@Service
@Transactional
public class AcessoServiceImplementation implements AcessoServiceInterface {

	@Autowired
	private AcessoRepository acessoRepository;
	
	
	@Override
	public Acesso saveAcesso(Acesso acesso) {
		
		return acessoRepository.save(acesso);
	}


	@Override
	public Boolean deleteAcesso(Long id) {
		 
		Optional<Acesso> temp = acessoRepository.findById(id);
		if(temp.isPresent()) {
			acessoRepository.deleteById(id);
			return true;
		}
		return false;
	}

	

	@Override
	public Acesso findAcessoById(Long id) {
		Optional<Acesso> temp = acessoRepository.findById(id);
		if(temp.isEmpty()) {
			throw new NoSuchElementException("Acesso não encontrado" + id);
		}
		
		return temp.get();
	}


	@Override
	public Acesso editAcesso(Acesso acesso) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Collection<Acesso> getAllAcesso() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	// Teste de Inserir
/*	@EventListener(ApplicationReadyEvent.class)
	 public void testarSalvarAcesso() {
		 Acesso acesso = new Acesso();
		 acesso.setDescricao("Teste Acesso");
		 
		 try {
			 Acesso acessoSalvo = this.saveAcesso(acesso);
			 System.out.println("Registro salvo com sucesso: "  + acessoSalvo);
		 }catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao salvar registro");
		}
	 
	 }
*/
	
}
