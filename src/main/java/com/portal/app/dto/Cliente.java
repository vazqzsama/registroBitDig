package com.portal.app.dto;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	private String socioId;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String sexo;
	private String email;
	private String fechaNacimiento;
	private String telefono;
	private String telefonoWhats;
	private int tiCveN;

	private List<DireccionCliente> direcciones;

	/**
	 * @return the socioId
	 */
	public String getSocioId() {
		return socioId;
	}

	/**
	 * @param socioId the socioId to set
	 */
	public void setSocioId(String socioId) {
		this.socioId = socioId;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellidoPaterno
	 */
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	/**
	 * @param apellidoPaterno the apellidoPaterno to set
	 */
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	/**
	 * @return the apellidoMaterno
	 */
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	/**
	 * @param apellidoMaterno the apellidoMaterno to set
	 */
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	/**
	 * @return the sexo
	 */
	public String getSexo() {
		return sexo;
	}

	/**
	 * @param sexo the sexo to set
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the fechaNacimiento
	 */
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * @param fechaNacimiento the fechaNacimiento to set
	 */
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the telefonoWhats
	 */
	public String getTelefonoWhats() {
		return telefonoWhats;
	}

	/**
	 * @param telefonoWhats the telefonoWhats to set
	 */
	public void setTelefonoWhats(String telefonoWhats) {
		this.telefonoWhats = telefonoWhats;
	}

	/**
	 * @return the direcciones
	 */
	public List<DireccionCliente> getDirecciones() {
		return Collections.unmodifiableList(direcciones);
	}

	/**
	 * @param direcciones the direcciones to set
	 */
	public void setDirecciones(List<DireccionCliente> direcciones) {
		this.direcciones = direcciones;
	}

	/**
	 * @return the tiCveN
	 */
	public int getTiCveN() {
		return tiCveN;
	}

	/**
	 * @param tiCveN the tiCveN to set
	 */
	public void setTiCveN(int tiCveN) {
		this.tiCveN = tiCveN;
	}

}
