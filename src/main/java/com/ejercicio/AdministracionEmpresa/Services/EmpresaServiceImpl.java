package com.ejercicio.AdministracionEmpresa.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicio.AdministracionEmpresa.Dao.EmpresaDao;
import com.ejercicio.AdministracionEmpresa.Entities.Empresa;


@Service
public class EmpresaServiceImpl implements EmpresaService{
	
	@Autowired
	EmpresaDao empresaDao;

	@Override
	public List<Empresa> listarEmpresa() {
		// TODO Auto-generated method stub
		return (List<Empresa>) empresaDao.findAll();
	}

	@Override
	public Empresa buscarEmpresa(Long id) {
		// TODO Auto-generated method stub
		return empresaDao.findById(id).orElse(null);
	}

	@Override
	public void editarEmpresa(Empresa empresa, Long id) {
		// TODO Auto-generated method stub
		 if(empresaDao.existsById(id)){
			 	empresa.setId_empresa(id);
	            empresaDao.save(empresa);
	        }
	}

	@Override
	public void borrarEmpresa(Long id) {
		// TODO Auto-generated method stub
		if(empresaDao.existsById(id)){
			empresaDao.deleteById(id);
        }
	}

	@Override
	public Empresa crearEmpresa(Empresa empresa) {
		// TODO Auto-generated method stub
		empresaDao.save(empresa);
		return empresa;
	}

}
