package com.ejercicio.AdministracionEmpresa.Dao;

import org.springframework.data.repository.CrudRepository;

import com.ejercicio.AdministracionEmpresa.Entities.Empresa;


public interface EmpresaDao extends CrudRepository<Empresa,Long>{

}
