package com.ejercicio.AdministracionEmpresa.Services;

import java.util.List;

import com.ejercicio.AdministracionEmpresa.Dto.ColaboradorDto;
import com.ejercicio.AdministracionEmpresa.Entities.Colaborador;

public interface ColaboradorService {
	
	public List<ColaboradorDto> listarColaborador();
	
    public ColaboradorDto buscarColaborador(Long id);
    
    public ColaboradorDto crearColaborador(ColaboradorDto colaboradordto);

    public void editarColaborador(ColaboradorDto colaboradorDto);

    public void borrarColaborador(Long id);
}
