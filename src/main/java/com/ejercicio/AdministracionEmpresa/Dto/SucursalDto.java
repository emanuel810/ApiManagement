package com.ejercicio.AdministracionEmpresa.Dto;


public class SucursalDto {
	

	private long id_sucursal;
	

	private String nombre;
	

	private String direccion;
	
	private String telefono;
	
	private long empresa_id;

	private int codigoError;
	
	private String mensajeError;


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

	@Override
	public String toString() {
		return "SucursalDto [id_sucursal=" + id_sucursal + ", nombre=" + nombre + ", direccion=" + direccion
				+ ", telefono=" + telefono + ", empresa_id=" + empresa_id + ", codigoError=" + codigoError
				+ ", mensajeError=" + mensajeError + "]";
	}
	
	

	
	

}
