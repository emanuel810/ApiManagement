package com.ejercicio.AdministracionEmpresa.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ejercicio.AdministracionEmpresa.Dto.PersonaDto;
import com.ejercicio.AdministracionEmpresa.Entities.Persona;
import com.ejercicio.AdministracionEmpresa.Services.PersonaService;

@RestController
@RequestMapping("/persona")
public class PersonaController {

	@Autowired
	PersonaService personaService;
	
	@GetMapping
    public List<PersonaDto> listaEmpresa(){
        return personaService.listarPersona();
    }
	
	@GetMapping(value= "/{id}")
    public PersonaDto obtenerEmpresa(@PathVariable Long id){
        return  personaService.buscarPersonas(id);
    }
	
	@PostMapping()
	public PersonaDto crearEmpresa(@RequestBody PersonaDto personaDto) {
		return personaService.crearPersona(personaDto);
	}


    @PutMapping("/{id}")
    public void modificarEmpresa(@PathVariable Long id,@RequestBody Persona persona){
    	personaService.editarPersona(persona, id);
    }

    @DeleteMapping("/{id}")
    public void borrarEmpresa(@PathVariable Long id){
    	personaService.borrarPersona(id) ;
    }
	
}
