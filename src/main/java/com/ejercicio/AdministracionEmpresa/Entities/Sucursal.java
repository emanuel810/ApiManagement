package com.ejercicio.AdministracionEmpresa.Entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity 
@Table(name="sucursales") 
public class Sucursal {
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_sucursal;
	
    @Column(name = "nombre")
	private String nombre;
	
    @Column(name = "direccion")
	private String direccion;
	
    @Column(name = "telefono")
	private String telefono;
        
    @JsonIgnore
    @ManyToOne(cascade= CascadeType.MERGE)
    @JoinColumn(name="id_empresa")
    private Empresa empresa;
    
    
    @JsonIgnore
    @OneToMany(mappedBy="sucursal",cascade= CascadeType.MERGE)
    List<Colaborador> colaboradores;


    
    public boolean validacionDatos(){
    	boolean retorno = false;
    	if(empresa!=null || empresa.validarDatos()) {
    		retorno = true;
    	}
    	
    	return retorno;
    } 
    
	public long getId_sucursal() {
		return id_sucursal;
	}

	public void setId_sucursal(long id_sucursal) {
		this.id_sucursal = id_sucursal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<Colaborador> getColaboradores() {
		return colaboradores;
	}

	public void setColaboradores(List<Colaborador> colaboradores) {
		this.colaboradores = colaboradores;
	}


	@Override
	public String toString() {
		return "Sucursal{" +
				"id_sucursal=" + id_sucursal +
				", nombre='" + nombre + '\'' +
				", direccion='" + direccion + '\'' +
				", telefono='" + telefono + '\'' +
				", empresa=" + empresa +
				", colaboradores=" + colaboradores +
				'}';
	}
}
