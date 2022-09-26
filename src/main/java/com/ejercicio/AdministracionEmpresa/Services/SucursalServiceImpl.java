package com.ejercicio.AdministracionEmpresa.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ejercicio.AdministracionEmpresa.Dao.SucursalDao;
import com.ejercicio.AdministracionEmpresa.Entities.Sucursal;

@Service
public class SucursalServiceImpl implements SucursalService {
	@Autowired
	SucursalDao sucursalDao;

	@Override
	public List<Sucursal> listarSucursales() {
		// TODO Auto-generated method stub
		return (List<Sucursal>) sucursalDao.findAll();
	}

	@Override
	public Sucursal buscarSucursales(Long id) {
		// TODO Auto-generated method stub
		return sucursalDao.findById(id).orElse(null);
	}

	@Override
	public void editarSucursales(Sucursal sucursales, Long id) {
		// TODO Auto-generated method stub
		 if(sucursalDao.existsById(id)){
			 	sucursales.setId_sucursal(id);
			 	sucursalDao.save(sucursales);
	        }
	}

	@Override
	public void borrarSucursales(Long id) {
		// TODO Auto-generated method stub
		if(sucursalDao.existsById(id)){
			sucursalDao.deleteById(id);
        }
	}

	@Override
	public Sucursal crearSucursales(Sucursal sucursales) {
		// TODO Auto-generated method stub
		sucursalDao.save(sucursales);
		return sucursales;
	}
}
