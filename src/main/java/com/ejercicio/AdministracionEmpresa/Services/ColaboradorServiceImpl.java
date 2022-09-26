package com.ejercicio.AdministracionEmpresa.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicio.AdministracionEmpresa.Dao.ColaboradorDao;
import com.ejercicio.AdministracionEmpresa.Entities.Colaborador;

@Service
public class ColaboradorServiceImpl implements ColaboradorService{

	
	@Autowired
	ColaboradorDao colaboradorDao;
	
	@Override
	public List<Colaborador> listarColaborador() {
		// TODO Auto-generated method stub
		return (List<Colaborador>) colaboradorDao.findAll();
	}

	@Override
	public Colaborador buscarColaborador(Long id) {
		// TODO Auto-generated method stub
		return colaboradorDao.findById(id).orElse(null);
	}

	@Override
	public Colaborador crearColaborador(Colaborador colaborador) {
		// TODO Auto-generated method stub
		colaboradorDao.save(colaborador);
		return colaborador;
	}

	@Override
	public void editarColaborador(Colaborador colaborador, Long id) {
		// TODO Auto-generated method stub
		if(colaboradorDao.existsById(id)){
			colaborador.setId_Colaborador(id);;
		 	colaboradorDao.save(colaborador);
        }
	}

	@Override
	public void borrarColaborador(Long id) {
		// TODO Auto-generated method stub
		if(colaboradorDao.existsById(id)){
			colaboradorDao.deleteById(id);
        }
	}

}
