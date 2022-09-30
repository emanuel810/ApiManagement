package com.ejercicio.AdministracionEmpresa.Dto;

import lombok.Data;

@Data
public class EmpresasDto {

	private long id_empresa;

	private String nombre;
 
	private String pais;
	
	private int codigoError;
	
	private String mensajeError;

	public long getId_empresa() {
		return id_empresa;
	}

	public void setId_empresa(long id_empresa) {
		this.id_empresa = id_empresa;
	}

	public int getCodigoError() {
		return codigoError;
	}

	public void setCodigoError(int codigoError) {
		this.codigoError = codigoError;
	}

	public String getMensajeError() {
		return mensajeError;
	}

	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
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

	@Override
	public String toString() {
		return "EmpresasDto [id_empresa=" + id_empresa + ", nombre=" + nombre + ", pais=" + pais + ", codigoError="
				+ codigoError + ", mensajeError=" + mensajeError + "]";
	}
	
}
