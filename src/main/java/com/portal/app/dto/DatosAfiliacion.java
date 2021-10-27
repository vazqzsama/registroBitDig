package com.portal.app.dto;

import java.io.Serializable;

import com.portal.app.response.Response;

/**
 * @author jchr
 * 
 * 
 *
 */
public class DatosAfiliacion extends Response implements Serializable {

	private static final long serialVersionUID = -1;

	private String nombre;
	private String email;
	private String telefono;
	private String dirEnvio;
	private String socioId;
	private String idPedidoPs;
	private String articulos;
	private Double importe;
	private String refPedido;
	private String refDepositoBancario;
	private Long idBitacora;
	private String estatus;
	private Integer sucursal;

	public DatosAfiliacion() {
		super();
	}
	
	public DatosAfiliacion(String message,int status) {
		super();
		setStatus(status);
		setMessage(message);
	}
	
	/**
	 * @return the sucursal
	 */
	public Integer getSucursal() {
		return sucursal;
	}

	/**
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(Integer sucursal) {
		this.sucursal = sucursal;
	}
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
	 * @return the idPedidoPs
	 */
	public String getIdPedidoPs() {
		return idPedidoPs;
	}

	/**
	 * @param idPedidoPs the idPedidoPs to set
	 */
	public void setIdPedidoPs(String idPedidoPs) {
		this.idPedidoPs = idPedidoPs;
	}

	/**
	 * @return the refDepositoBancario
	 */
	public String getRefDepositoBancario() {
		return refDepositoBancario;
	}

	/**
	 * @param refDepositoBancario the refDepositoBancario to set
	 */
	public void setRefDepositoBancario(String refDepositoBancario) {
		this.refDepositoBancario = refDepositoBancario;
	}

	public Long getIdBitacora() {
		return idBitacora;
	}

	public void setIdBitacora(Long idBitacora) {
		this.idBitacora = idBitacora;
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
	 * @return the dirEnvio
	 */
	public String getDirEnvio() {
		return dirEnvio;
	}

	/**
	 * @param dirEnvio the dirEnvio to set
	 */
	public void setDirEnvio(String dirEnvio) {
		this.dirEnvio = dirEnvio;
	}

	/**
	 * @return the articulos
	 */
	public String getArticulos() {
		return articulos;
	}

	/**
	 * @param articulos the articulos to set
	 */
	public void setArticulos(String articulos) {
		this.articulos = articulos;
	}

	/**
	 * @return the importe
	 */
	public Double getImporte() {
		return importe;
	}

	/**
	 * @param importe the importe to set
	 */
	public void setImporte(Double importe) {
		this.importe = importe;
	}

	/**
	 * @return the estatus
	 */
	public String getEstatus() {
		return estatus;
	}

	/**
	 * @param estatus the estatus to set
	 */
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	/**
	 * @return the refPedido
	 */
	public String getRefPedido() {
		return refPedido;
	}

	/**
	 * @param refPedido the refPedido to set
	 */
	public void setRefPedido(String refPedido) {
		this.refPedido = refPedido;
	}

}
