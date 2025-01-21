package net.sys.gest.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import net.sys.gest.model.Acesso;
import net.sys.gest.repository.AcessoRepository;

@Service
@Transactional
public class AcessoServiceImplementation implements AcessoServiceInterface {

	@Autowired
	private AcessoRepository acessoRepository;
	
	LocalDateTime dataAtual = LocalDateTime.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
 	String dataFormatada = dataAtual.format(formatter);
 	
	LocalDateTime dataConvertida = LocalDateTime.parse(dataFormatada, formatter);
 	
	@Override
	public Acesso saveAcesso(Acesso acesso) {
		
		acesso.setDataCriacao(dataConvertida);
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
		 Optional<Acesso> temp = acessoRepository.findById(acesso.getId());
		 if(temp.isPresent()) {
			 Acesso acessoExistente = temp.get();
			 acessoExistente.setDescricao(acesso.getDescricao());
			 acessoExistente.setDataModificacao(dataConvertida.now());
			 
			 acesso.setDataModificacao(dataConvertida.now());
			 return acessoRepository.save(acessoExistente);
		 
		 }else if(temp.isEmpty()) {
			 throw new NoSuchElementException("Acesso não encontrado" + acesso.getId());
		 }
		 
		 return null;
	}


	@Override
	public Collection<Acesso> getAllAcesso() {
		return acessoRepository.findAll(Sort.by(Sort.Direction.ASC, "descricao"));
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
