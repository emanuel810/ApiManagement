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
import com.ejercicio.AdministracionEmpresa.Entities.Sucursal;
import com.ejercicio.AdministracionEmpresa.Services.SucursalService;

@RestController
@RequestMapping("/sucursal")
public class SucursalController {

	
	@Autowired
	SucursalService sucursalService;
	
	@GetMapping
    public List<Sucursal> listaSucursal(){
        return sucursalService.listarSucursales();
    }
	
	@GetMapping(value= "/{id}")
    public Sucursal obtenerSucursal(@PathVariable Long id){
        return  sucursalService.buscarSucursales(id);
    }

	@PostMapping()
	public Sucursal crearSucursal(@RequestBody Sucursal sucursales) {
		return sucursalService.crearSucursales(sucursales);
	}
	
    @PutMapping("/{id}")
    public void modificarSucursal(@PathVariable Long id,@RequestBody Sucursal sucursales){
    	sucursalService.editarSucursales(sucursales, id);
    }

    @DeleteMapping("/{id}")
    public void borrarSucursal(@PathVariable Long id){
    	sucursalService.borrarSucursales(id) ;
    }
}
