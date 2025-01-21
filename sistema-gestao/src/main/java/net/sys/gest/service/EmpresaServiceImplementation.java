package net.sys.gest.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sys.gest.model.Empresa;
import net.sys.gest.repository.EmpresaRepository;

@Service
public class EmpresaServiceImplementation implements EmpresaServiceInterface {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	LocalDateTime dataAtual = LocalDateTime.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	String DataFormatada = dataAtual.format(formatter);
	
	LocalDateTime dataConvertida = LocalDateTime.parse(DataFormatada, formatter);
	
	@Override
	public Empresa saveEmpresa(Empresa empresa) {
		empresa.setDataCriacao(dataConvertida.now());
		return empresaRepository.save(empresa);
	}

	@Override
	public Boolean deleteEmpresa(Long id) {
		
		Optional<Empresa>temp = empresaRepository.findById(id);
		if(temp.isPresent()) {
			empresaRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Empresa editEmpresa(Empresa empresa) {
		 Optional<Empresa>temp = empresaRepository.findById(empresa.getId());
		 if(temp.isPresent()) {
			  Empresa emp = temp.get();
			  
			  emp.setNomeFantasia(emp.getNomeFantasia());
			  emp.setRazao_social(emp.getRazao_social());
			  emp.setEmail(emp.getEmail());
			  emp.setEndereco(emp.getEndereco());
			  emp.setForo(emp.getForo());
			  emp.setFunesban(emp.getFunesban());
			  emp.setTelefone(emp.getTelefone());
			  
			 return empresaRepository.save(emp);
		 }else if(temp.isEmpty()) {
			 throw new NoSuchElementException("Empresa não encontrada" + empresa.getId());
		 }
			 
		return null;
	}

	@Override
	public Collection<Empresa> gerAllEmpresa() {
		return empresaRepository.findAll();
	}

}
