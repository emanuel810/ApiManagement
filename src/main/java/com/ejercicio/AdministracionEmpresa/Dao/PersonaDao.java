package com.ejercicio.AdministracionEmpresa.Dao;

import org.springframework.data.repository.CrudRepository;
import com.ejercicio.AdministracionEmpresa.Entities.Persona;

public interface PersonaDao extends CrudRepository<Persona,Long>{

}