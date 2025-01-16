package net.sys.gest.controller;

import java.util.Collection;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import net.sys.gest.model.Acesso;
import net.sys.gest.repository.AcessoRepository;
import net.sys.gest.service.AcessoServiceInterface;

@Controller
public class AcessoController {

	@Autowired
	private AcessoServiceInterface acessoServiceInterface;

	@GetMapping("/")
	public String teste() {
		return "/index";
	}
	
	 
	@PostMapping(value="/saveAcesso")
	public ResponseEntity<Acesso> saveAcesso(@Validated  @RequestBody Acesso acesso){
		
//		Acesso acessoSalvo = acessoServiceInterface.saveAcesso(acesso);
//		return ResponseEntity.status(HttpStatus.CREATED).body(acessoSalvo);
		
		try {
		    System.out.println("Payload recebido: " + acesso);
			Acesso acessoSalvo = acessoServiceInterface.saveAcesso(acesso);
			return ResponseEntity.status(HttpStatus.CREATED).body(acessoSalvo);
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	
	@PutMapping(value="/editAcesso/{id}")
	public ResponseEntity<?>editAcesso(@PathVariable Long id, @RequestBody Acesso acesso){ 
		try {
			
			acesso.setId(id);
			
			Acesso updateAcesso = acessoServiceInterface.editAcesso(acesso);
			
			if(updateAcesso == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Acesso com ID " + id + "não encotrado" );
			}
			
			return ResponseEntity.ok(updateAcesso); 
					
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno, " + e.getMessage());
		}
	}
	
	
	@GetMapping(value="/getAllAcessos")
	public ResponseEntity<Collection<Acesso>> getAllAcesso(){
		return ResponseEntity.ok(acessoServiceInterface.getAllAcesso());
	}
	
	
	@DeleteMapping(value="/deleteAcesso/{id}")
	public ResponseEntity<String> deleteAcesso(@PathVariable Long id){
				
//		try {
//			acessoRepository.deleteById(id);
//			return ResponseEntity.status(HttpStatus.OK).body("Aesso removido com sucesso");
//			
//		}catch (Exception e) {
//			 e.printStackTrace();
//			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao remover acesso");
//		}
		
		try {
			boolean registroRemovido = acessoServiceInterface.deleteAcesso(id);
			if(registroRemovido) {
				return ResponseEntity.status(HttpStatus.OK).body("Acesso removido com sucesso");
			
			}else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Acesso não encontrado");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao remover Acesso");
		}
		
	}
	
	
	
//	// 1- FORMA DE FAZER - RETORNO EXPLICITO DO OBJETO
//	@GetMapping(value="/findAcessoById/{id}")
//	public ResponseEntity<Acesso> findAcessoById(@PathVariable Long id){
//		
//		
////		try {
////			Acesso acesso = acessoServiceInterface.findAcessoById(id);
////			return ResponseEntity.status(HttpStatus.OK).body(acesso);
////			
////		}catch (Exception e) {
////			e.printStackTrace();
////			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
////		}
//		
//	}
	


	// 2- FORMA RETORNO GENÉRICO 
	@GetMapping(value="/findAcessoById/{id}")
	public ResponseEntity<?> findAcessoById(@PathVariable Long id){
		
		try {
			Acesso acesso  = acessoServiceInterface.findAcessoById(id);
			return ResponseEntity.status(HttpStatus.OK).body(acesso);
			
		} catch (NoSuchElementException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Acesso não encontrado para o Id: " + id);
		
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro encontrado ao buscar o acesso: " + e);
		}
	
	
	}
	
		
		
	

}
