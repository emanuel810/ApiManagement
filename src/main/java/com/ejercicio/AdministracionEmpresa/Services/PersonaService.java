package com.ejercicio.AdministracionEmpresa.Services;

import java.util.List;

import com.ejercicio.AdministracionEmpresa.Dto.PersonaDto;
import com.ejercicio.AdministracionEmpresa.Entities.Persona;

public interface PersonaService {
	
	
	public List<PersonaDto> listarPersona();
	
    public PersonaDto buscarPersonas(Long id);
    
    public PersonaDto crearPersona(PersonaDto personaDto);

    public void editarPersona(Persona persona, Long id);

    public void borrarPersona(Long id);
}
