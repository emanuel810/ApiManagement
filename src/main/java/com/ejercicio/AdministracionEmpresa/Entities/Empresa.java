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

@Entity 
@Table(name="empresa") 
public class Empresa {
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_empresa;

    @Column(name = "nombre")
	private String nombre;
 
    @Column(name = "pais")
	private String pais;
    
    @OneToMany(mappedBy="empresa",cascade= {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    List<Sucursal> sucursales;


	public long getId_empresa() {
		return id_empresa;
	}

	public void setId_empresa(long id_empresa) {
		this.id_empresa = id_empresa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public List<Sucursal> getSucursales() {
		return sucursales;
	}

	public void setSucursales(List<Sucursal> sucursal) {
		this.sucursales = sucursal;
	}
	
    
    
    
    
}
