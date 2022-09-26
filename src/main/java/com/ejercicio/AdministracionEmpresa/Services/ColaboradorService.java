package com.ejercicio.AdministracionEmpresa.Services;

import java.util.List;

import com.ejercicio.AdministracionEmpresa.Entities.Colaborador;

public interface ColaboradorService {
	
	public List<Colaborador> listarColaborador();
	
    public Colaborador buscarColaborador(Long id);
    
    public Colaborador crearColaborador(Colaborador colaborador);

    public void editarColaborador(Colaborador colaborador, Long id);

    public void borrarColaborador(Long id);
}
