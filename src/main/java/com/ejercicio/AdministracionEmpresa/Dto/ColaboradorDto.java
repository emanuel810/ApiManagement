package com.ejercicio.AdministracionEmpresa.Dto;


public class ColaboradorDto {
	
	private long id_Colaborador;
	 
	private String nombre;
	
	private String cui;
	
	private long sucursal_id;
	
	private long empresa_id;
	
	private int codigoError;
	
	private String mensajeError;


	private long persona_id;

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

	public long getSucursal_id() {
		return sucursal_id;
	}

	public void setSucursal_id(long sucursal_id) {
		this.sucursal_id = sucursal_id;
	}

	public long getEmpresa_id() {
		return empresa_id;
	}

	public void setEmpresa_id(long empresa_id) {
		this.empresa_id = empresa_id;
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


	public long getPersona_id() {
		return persona_id;
	}

	public void setPersona_id(long persona_id) {
		this.persona_id = persona_id;
	}
}
