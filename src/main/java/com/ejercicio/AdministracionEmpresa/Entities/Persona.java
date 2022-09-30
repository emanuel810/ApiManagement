package com.ejercicio.AdministracionEmpresa.Entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity 
@Table(name="persona") 
public class Persona {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_Persona;
	 
	@Column(name = "edad")
	private String edad;
	
	@Column(name = "sexo")
	private String sexo;
	
	
	@JsonIgnore
    @OneToMany(mappedBy="persona",cascade= CascadeType.MERGE)
    List<Colaborador> colaboradores;
	
	
	public boolean validarDatos() {
    	boolean retorno = true;
    	if(edad==null && edad.isEmpty()) {
    		retorno = false;
    		
    	}
    	if(sexo==null && sexo.isEmpty()) {
    		retorno = false;
    	}
    	return retorno;
    }
	
	
	public long getId_Persona() {
		return id_Persona;
	}

	public void setId_Persona(long id_Persona) {
		this.id_Persona = id_Persona;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
}
