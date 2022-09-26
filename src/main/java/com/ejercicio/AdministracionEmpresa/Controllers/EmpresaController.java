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
import com.ejercicio.AdministracionEmpresa.Entities.Empresa;
import com.ejercicio.AdministracionEmpresa.Services.EmpresaService;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {
	
	
	@Autowired
	EmpresaService empresaService;
	
	@GetMapping
    public List<Empresa> listaEmpresa(){
        return empresaService.listarEmpresa();
    }
	
	@GetMapping(value= "/{id}")
    public Empresa obtenerEmpresa(@PathVariable Long id){
        return  empresaService.buscarEmpresa(id);
    }
	
	@PostMapping()
	public Empresa crearEmpresa(@RequestBody Empresa empresa) {
		return empresaService.crearEmpresa(empresa);
	}


    @PutMapping("/{id}")
    public void modificarEmpresa(@PathVariable Long id,@RequestBody Empresa empresa){
    	empresaService.editarEmpresa(empresa, id);
    }

    @DeleteMapping("/{id}")
    public void borrarEmpresa(@PathVariable Long id){
    	empresaService.borrarEmpresa(id) ;
    }

}
