package com.portal.app.dto;

import java.io.Serializable;
import java.util.Arrays;

public class CoberturaPaqueteria implements Serializable {

	private static final long serialVersionUID = 1L;
	private int cvePaqueteria;
	private String paqueteria;
	private int aplicaServicio;
	private int servicioDomicilio;
	private int servicioOficina;
	private String[] colonias;
	private String frecuencia;
	private String diasEntrega;
	private double gastosEnvio;
	private double pctSeguroMensajeria;

	/**
	 * Constructor default
	 */
	public CoberturaPaqueteria() {

	}

	/**
	 * @param cvePaqueteria
	 * @param descripcionPaqueteria
	 */
	public CoberturaPaqueteria(final int cvePaqueteria, final String descripcionPaqueteria) {
		this.cvePaqueteria = cvePaqueteria;
		this.paqueteria = descripcionPaqueteria;
		aplicaServicio = 0;
		servicioDomicilio = 0;
		servicioOficina = 0;
		colonias = new String[] {};
		frecuencia = "";
		gastosEnvio = 0;
		pctSeguroMensajeria = 0;
	}

	public int getCvePaqueteria() {
		return cvePaqueteria;
	}

	public void setCvePaqueteria(int cvePaqueteria) {
		this.cvePaqueteria = cvePaqueteria;
	}

	public String getPaqueteria() {
		return paqueteria;
	}

	public void setPaqueteria(String paqueteria) {
		this.paqueteria = paqueteria;
	}

	public int getAplicaServicio() {
		return aplicaServicio;
	}

	public void setAplicaServicio(int aplicaServicio) {
		this.aplicaServicio = aplicaServicio;
	}

	public int getServicioDomicilio() {
		return servicioDomicilio;
	}

	public void setServicioDomicilio(int servicioDomicilio) {
		this.servicioDomicilio = servicioDomicilio;
	}

	public int getServicioOficina() {
		return servicioOficina;
	}

	public void setServicioOficina(int servicioOficina) {
		this.servicioOficina = servicioOficina;
	}

	public String[] getColonias() {
		return colonias;
	}

	public void setColonias(String[] colonias) {
		this.colonias = colonias;
	}

	public String getFrecuencia() {
		return frecuencia;
	}

	public void setFrecuencia(String frecuencia) {
		this.frecuencia = frecuencia;
	}

	public String getDiasEntrega() {
		return diasEntrega;
	}

	public void setDiasEntrega(String diasEntrega) {
		this.diasEntrega = diasEntrega;
	}

	public double getGastosEnvio() {
		return gastosEnvio;
	}

	public void setGastosEnvio(double gastosEnvio) {
		this.gastosEnvio = gastosEnvio;
	}

	public double getPctSeguroMensajeria() {
		return pctSeguroMensajeria;
	}

	public void setPctSeguroMensajeria(double pctSeguroMensajeria) {
		this.pctSeguroMensajeria = pctSeguroMensajeria;
	}

	@Override
	public String toString() {
		return String.format(
				"CoberturaPaqueteria [cvePaqueteria=%s, paqueteria=%s, aplicaServicio=%s, servicioDomicilio=%s, servicioOficina=%s, colonias=%s, frecuencia=%s, diasEntrega=%s, gastosEnvio=%s, pctSeguroMensajeria=%s]",
				cvePaqueteria, paqueteria, aplicaServicio, servicioDomicilio, servicioOficina,
				Arrays.toString(colonias), frecuencia, diasEntrega, gastosEnvio, pctSeguroMensajeria);
	}

}
