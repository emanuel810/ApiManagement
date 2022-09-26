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
import com.ejercicio.AdministracionEmpresa.Entities.Colaborador;
import com.ejercicio.AdministracionEmpresa.Services.ColaboradorService;

@RestController
@RequestMapping("/colaborador")
public class ColaboradorController {
	
	
	@Autowired
	ColaboradorService colaboradorService;
	
	@GetMapping
    public List<Colaborador> listaColaborador(){
        return colaboradorService.listarColaborador();
    }
	
	@GetMapping(value= "/{id}")
    public Colaborador obtenerColaborador(@PathVariable Long id){
        return  colaboradorService.buscarColaborador(id);
    }
	
	@PostMapping()
	public Colaborador crearColaborador(@RequestBody Colaborador colaborador) {
		return colaboradorService.crearColaborador(colaborador);
	}


    @PutMapping("/{id}")
    public void modificarColaborador(@PathVariable Long id,@RequestBody Colaborador colaborador){
    	colaboradorService.editarColaborador(colaborador, id);
    }

    @DeleteMapping("/{id}")
    public void borrarColaborador(@PathVariable Long id){
    	colaboradorService.borrarColaborador(id) ;
    }
}
