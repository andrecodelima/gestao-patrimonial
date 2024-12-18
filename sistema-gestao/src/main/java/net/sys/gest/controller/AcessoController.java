package net.sys.gest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.sys.gest.model.Acesso;
import net.sys.gest.repository.AcessoRepository;
import net.sys.gest.service.AcessoServiceInterface;

@Controller
public class AcessoController {

	@Autowired
	private AcessoServiceInterface acessoServiceInterface;

	@Autowired
	private AcessoRepository acessoRepository;

	
	@GetMapping("/")
	public String teste() {
		
		return "/index";
	}
	
	 
	@PostMapping(value="/saveAcesso")
	public ResponseEntity<Acesso> saveAcesso(@RequestBody Acesso acesso){
		
		Acesso acessoSalvo = acessoServiceInterface.saveAcesso(acesso);
		return ResponseEntity.status(HttpStatus.CREATED).body(acessoSalvo);
		
	}
	
	
	@DeleteMapping(value="/deleteAcesso")
	public ResponseEntity<Acesso>deleteAcesso(@RequestBody Acesso acesso){
		acessoRepository.deleteById(acesso.getId());
		
		return new ResponseEntity("Acesso removido", HttpStatus.OK);
	}
	
	
	
	
	
	
		
	

}
