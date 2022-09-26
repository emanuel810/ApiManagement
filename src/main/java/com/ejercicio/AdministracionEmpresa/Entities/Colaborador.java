package com.ejercicio.AdministracionEmpresa.Entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity 
@Table(name="Colaboradores") 
public class Colaborador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_Colaborador;
	 
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "cui")
	private String cui;
	
	
	
	@JsonIgnore
    @ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name="id_sucursal")
    private Sucursal sucursal;
	
	

	public long getId_Colaborador() {
		return id_Colaborador;
	}

	public void setId_Colaborador(long id_Colaborador) {
		this.id_Colaborador = id_Colaborador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCui() {
		return cui;
	}

	public void setCui(String cui) {
		this.cui = cui;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}
	
	
	
	 
}
