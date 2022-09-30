package com.ejercicio.AdministracionEmpresa.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ejercicio.AdministracionEmpresa.Entities.Colaborador;
import com.ejercicio.AdministracionEmpresa.Entities.Empresa;
import com.ejercicio.AdministracionEmpresa.Entities.Sucursal;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ejercicio.AdministracionEmpresa.Dao.PersonaDao;
import com.ejercicio.AdministracionEmpresa.Dto.PersonaDto;
import com.ejercicio.AdministracionEmpresa.Entities.Persona;


@Service
public class PersonaServiceImpl implements PersonaService{

	
	private final PersonaDao personaDao;
	
	private final ModelMapper modeloObject;
	
	@Autowired
	public PersonaServiceImpl(PersonaDao personaDao) {
		this.personaDao = personaDao;
		this.modeloObject = new ModelMapper();	
	}
	
	
	public PersonaDto mappedPersonaDto(Persona persona) {
		
		return modeloObject.map(persona, PersonaDto.class);
	}

	public Persona mappedPersona(PersonaDto personaDto){
		return modeloObject.map(personaDto, Persona.class);
	}
	
	@Override
	public List<PersonaDto> listarPersona() {

		List<Persona> personas = (List<Persona>) personaDao.findAll();
		List<PersonaDto> personaDto = new ArrayList<>();
		for (Persona persona : personas) {
			personaDto.add(mappedPersonaDto(persona));
		}
		return personaDto;
	}

	@Override
	public PersonaDto buscarPersonas(Long id) {

		Persona persona = personaDao.findById(id).orElse(null);
		
		PersonaDto personaDto = new PersonaDto();
		if(persona==null) {
			
			personaDto.setCodigoError(1);
			personaDto.setMensajeError("Empresa no encontrada");
			return personaDto;
		}
		personaDto = mappedPersonaDto(persona);
		personaDto.setCodigoError(0);
		return personaDto;
	}

	@Override
	public PersonaDto crearPersona(PersonaDto personaDto) {

		Persona persona = mappedPersona(personaDto);
		
		if(persona.validarDatos()) {
			Persona personaSave= personaDao.save(persona);
			personaDto.setId_Persona(personaSave.getId_Persona());
			personaDto.setMensajeError("Guardado correctamente");
			personaDto.setCodigoError(0);
			return personaDto;
		}else {
			personaDto.setCodigoError(1);
			personaDto.setMensajeError("No fue posible guardar el objeto");
			return personaDto;
		}
	}

	@Override
	public void editarPersona(Persona persona, Long id) {


	}

	@Override
	public void borrarPersona(Long id) {

		if(personaDao.existsById(id)){
			personaDao.deleteById(id);
        }
	}

}
