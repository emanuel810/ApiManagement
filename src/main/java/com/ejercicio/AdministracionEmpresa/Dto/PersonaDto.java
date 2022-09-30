package com.ejercicio.AdministracionEmpresa.Dto;


public class PersonaDto {
	
	private long id_Persona;
	 
	private String edad;
	
	private String sexo;

	private int codigoError;
	
	private String mensajeError;

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
	
	
}
