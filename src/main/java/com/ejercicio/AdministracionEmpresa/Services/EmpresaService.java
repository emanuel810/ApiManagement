package com.ejercicio.AdministracionEmpresa.Services;

import java.util.List;

import com.ejercicio.AdministracionEmpresa.Dto.EmpresasDto;
import com.ejercicio.AdministracionEmpresa.Entities.Empresa;


public interface EmpresaService {
	
	
	public List<EmpresasDto> listarEmpresa();
	
    public EmpresasDto buscarEmpresa(Long id);
    
    public EmpresasDto crearEmpresa(EmpresasDto empresa);

    public void editarEmpresa(Empresa empresa, Long id);

    public void borrarEmpresa(Long id);

}
