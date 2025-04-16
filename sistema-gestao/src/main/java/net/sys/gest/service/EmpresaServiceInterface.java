package net.sys.gest.service;

import java.util.Collection;

import net.sys.gest.model.Empresa;

public interface EmpresaServiceInterface {

	public Empresa saveEmpresa(Empresa empresa);
	public Boolean deleteEmpresa(Long id);
	public Empresa editEmpresa(Empresa empresa);
	
	public Collection<Empresa>gerAllEmpresa();
	
}
