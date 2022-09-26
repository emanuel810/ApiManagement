package com.ejercicio.AdministracionEmpresa.Services;

import java.util.List;
import com.ejercicio.AdministracionEmpresa.Entities.Sucursal;

public interface SucursalService {
	
	
	public List<Sucursal> listarSucursales();
	
    public Sucursal buscarSucursales(Long id);
    
    public Sucursal crearSucursales(Sucursal sucursales);

    public void editarSucursales(Sucursal sucursales, Long id);

    public void borrarSucursales(Long id);
}
