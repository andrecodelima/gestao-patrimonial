package net.sys.gest.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import net.sys.gest.model.Empresa;
import net.sys.gest.service.EmpresaServiceInterface;

@Controller
@RequestMapping("/empresa")
public class EmpresaController {

	@Autowired
	private EmpresaServiceInterface empresaServiceInterface;
	
	@PostMapping("insertEmpresa")
	public ResponseEntity<Empresa>insertEmpresa(@RequestBody Empresa empresa){
		Empresa novaEmpresa = empresaServiceInterface.saveEmpresa(empresa);
		return ResponseEntity.status(HttpStatus.CREATED).body(novaEmpresa);
		
	}
	
	@PutMapping("/editEmpresa")
	public ResponseEntity<?>editEmpresa(@PathVariable Long id, @RequestBody Empresa empresa){
		
		try {
			empresa.setId(id);
			Empresa updateEmpresa = empresaServiceInterface.editEmpresa(empresa);
			
			if(updateEmpresa == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID: " + id + "não encontrado");
			}
			
			return ResponseEntity.ok(updateEmpresa);
			
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno: "  + e.getMessage());
		}
	}
	
	
	@GetMapping("/getAllEmpresa")
	public ResponseEntity<Collection<Empresa>>getAllEmpresa(){
		return ResponseEntity.ok(empresaServiceInterface.gerAllEmpresa());
	}
	
	
	
	
}
