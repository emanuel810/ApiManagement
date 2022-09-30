package com.ejercicio.AdministracionEmpresa.Services;

import java.util.List;

import com.ejercicio.AdministracionEmpresa.Dto.SucursalDto;
import com.ejercicio.AdministracionEmpresa.Entities.Sucursal;

public interface SucursalService {
	
	
	public List<SucursalDto> listarSucursales();
	
    public SucursalDto buscarSucursales(Long id);
    
    public SucursalDto crearSucursales(SucursalDto sucursales);

    public void editarSucursales(SucursalDto sucursalDto);

    public void borrarSucursales(Long id);
}
