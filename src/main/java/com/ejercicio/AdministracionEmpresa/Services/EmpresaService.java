package com.ejercicio.AdministracionEmpresa.Services;

import java.util.List;

import com.ejercicio.AdministracionEmpresa.Entities.Empresa;


public interface EmpresaService {
	
	
	public List<Empresa> listarEmpresa();
	
    public Empresa buscarEmpresa(Long id);
    
    public Empresa crearEmpresa(Empresa empresa);

    public void editarEmpresa(Empresa empresa, Long id);

    public void borrarEmpresa(Long id);

}
