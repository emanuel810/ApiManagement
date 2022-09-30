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

import com.ejercicio.AdministracionEmpresa.Dto.SucursalDto;
import com.ejercicio.AdministracionEmpresa.Entities.Empresa;
import com.ejercicio.AdministracionEmpresa.Entities.Sucursal;
import com.ejercicio.AdministracionEmpresa.Services.SucursalService;

@RestController
@RequestMapping("/sucursal")
public class SucursalController {

	
	@Autowired
	SucursalService sucursalService;
	
	@GetMapping
    public List<SucursalDto> listaSucursal(){
        return sucursalService.listarSucursales();
    }
	
	@GetMapping(value= "/{id}")
    public SucursalDto obtenerSucursal(@PathVariable Long id){
        return  sucursalService.buscarSucursales(id);
    }

	@PostMapping()
	public SucursalDto crearSucursal(@RequestBody SucursalDto sucursales) {
		return sucursalService.crearSucursales(sucursales);
	}
	
    @PutMapping()
    public void modificarSucursal(@RequestBody SucursalDto sucursalDto){
    	sucursalService.editarSucursales(sucursalDto);
    }

    @DeleteMapping("/{id}")
    public void borrarSucursal(@PathVariable Long id){
    	sucursalService.borrarSucursales(id) ;
    }
}
