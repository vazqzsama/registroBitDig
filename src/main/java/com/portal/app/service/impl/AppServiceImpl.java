package com.portal.app.service.impl;

import static com.portal.app.util.Constants.*;

import java.util.List;
import java.util.Objects;

import javax.validation.ConstraintDeclarationException;

import org.apache.catalina.connector.ClientAbortException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.portal.app.client.ReferenciaBancariaClient;
import com.portal.app.dao.AppDao;
import com.portal.app.dto.AfilRegistrar;
import com.portal.app.dto.BitacoraDigital;
import com.portal.app.request.AppRequest;
import com.portal.app.request.BitRegRequest;
import com.portal.app.request.ParametrosPendientes;
import com.portal.app.response.AppResponse;
import com.portal.app.service.AppService;

@Service
public class AppServiceImpl implements AppService {
	private static final Logger log = LoggerFactory.getLogger(AppServiceImpl.class);
	
	@Autowired 
	private AppDao dao;
	@Autowired
	private ReferenciaBancariaClient refClient;
			
	@Override
	public AppResponse testConexion(AppRequest request) {
		log.info("testConexion" + new Gson().toJson(request));
		AppResponse response = new AppResponse();
		try {
			response = dao.test(request) ;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			response.setStatus(ERROR);
			response.setMessage(e.getMessage());
		}
		return response;
	}
	
	@Override
	public BitacoraDigital createBitacora(BitRegRequest bit) throws Exception {
		BitacoraDigital bitacora = new BitacoraDigital(bit);
		
		if (dao.searchRegistro(bit.getEmail(),bit.getIdSocio(), String.format("%s %s %s ", 
				bit.getSoNombre(),bit.getApellidoPaterno(),bit.getApellidoMaterno())))
			throw new ConstraintDeclarationException(
				String.format("El socio %s tiene un registro con pedido vigente",bit.getIdSocio()));
		
		bitacora.setReferenciaPedido(dao.getReferenciaPedido());
		bitacora.setReferenciaBancaria(getReferenciaBancaria(bit.getIdSocio()));
		
		return dao.createBitacora(bitacora);
	}
	
	@Override
	public BitacoraDigital updateBitacora(BitacoraDigital bit) throws Exception {
		Objects.requireNonNull(bit.getId(),String.format("El request no contiene clave de bitácora",bit.getNumSocio()));
		Objects.requireNonNull(bit.getNumSocio(),"El request no contiene número de socio");
		Objects.requireNonNull(bit.getNumPedido(),String.format("El request del socio %s no contiene id de pedido",bit.getNumSocio()));
		Objects.requireNonNull(bit.getCveTienda(),String.format("El request del socio %s no contiene id de tienda",bit.getNumSocio()));
		Objects.requireNonNull(bit.getNombre(),String.format("El request del socio %s no contiene nombre",bit.getNumSocio()));
		Objects.requireNonNull(bit.getEmail(),String.format("El request del socio %s no contiene correo electrónico",bit.getNumSocio()));
		Objects.requireNonNull(bit.getTelefono(),String.format("El request del socio %s no contiene teléfono",bit.getNumSocio()));
		Objects.requireNonNull(bit.getEstatus(),String.format("El request del socio %s no contiene estatus de socio",bit.getNumSocio()));
		Objects.requireNonNull(bit.getEstatusPago(),String.format("El request del socio %s no contiene estatus de pago",bit.getNumSocio()));
		Objects.requireNonNull(bit.getCveTienda(),String.format("El request del socio %s no contiene id de tienda",bit.getNumSocio()));
		Objects.requireNonNull(bit.getArticulos(),String.format("El request del socio %s no contiene artículos",bit.getNumSocio()));
		Objects.requireNonNull(bit.getMetodoPago(),String.format("El request del socio %s no contiene método de pago",bit.getNumSocio()));
		Objects.requireNonNull(bit.getFormaPago(),String.format("El request del socio %s no contiene forma de pago",bit.getNumSocio()));
		Objects.requireNonNull(bit.getTipoVenta(),String.format("El request del socio %s no contiene tipo de venta",bit.getNumSocio()));
		Objects.requireNonNull(bit.getImporteTotal(),String.format("El request del socio %s no contiene importe total",bit.getNumSocio()));
		Objects.requireNonNull(bit.getImportePedido(),String.format("El request del socio %s no contiene importe del pedido",bit.getNumSocio()));
		Objects.requireNonNull(bit.getDescuento(),String.format("El request del socio %s no contiene descuento",bit.getNumSocio()));
		Objects.requireNonNull(bit.getSeguroEnvio(),String.format("El request del socio %s no contiene seguro de envío",bit.getNumSocio()));
		Objects.requireNonNull(bit.getGastoEnvio(),String.format("El request del socio %s no contiene costo de envío",bit.getNumSocio()));
		Objects.requireNonNull(bit.getFchAlta(),String.format("El request del socio %s no contiene fecha de alta",bit.getNumSocio()));
		Objects.requireNonNull(bit.getFchActualizacion(),String.format("El request del socio %s no contiene fecha de actualización",bit.getNumSocio()));
		Objects.requireNonNull(bit.getFchModEstatusPago(),String.format("El request del socio %s no contiene fecha de actualización de pago",bit.getNumSocio()));
		Objects.requireNonNull(bit.getDescuento(),String.format("El request del socio %s no contiene descuento",bit.getNumSocio()));
		Objects.requireNonNull(bit.getIdPaqueteria(),String.format("El request del socio %s no contiene id de paqueteria",bit.getNumSocio()));
		Objects.requireNonNull(bit.getReferenciaPedido(),String.format("El request del socio %s no contiene referencia",bit.getNumSocio()));
		Objects.requireNonNull(bit.getReferenciaBancaria(),String.format("El request del socio %s no contiene referencia bancaria",bit.getNumSocio()));
		// Direccion
		Objects.requireNonNull(bit.getDirEnvio(),String.format("El request del socio %s no contiene información de la direccion",bit.getNumSocio()));

		return dao.updateBitacora(bit);
	}
	
	public String getReferenciaBancaria(String idSocio) throws ClientAbortException {
		try {
			return (String) refClient.send(idSocio).getBody();
		} catch (Exception e) {
			log.info("Error referencia bancaria: "+e.getLocalizedMessage());
			throw new ClientAbortException(e.getLocalizedMessage());
			//return null;
		}
	}
	
	@Override
	public AppResponse registrarPendientes(ParametrosPendientes params) throws Exception {
		if (params.containParams())
			throw new IllegalArgumentException("No existen parametros de busqueda");
		
		AppResponse result = new AppResponse();
		List<AfilRegistrar> pndts = dao.getPendientes(params);
		log.info("tamaño: "+pndts.size());
		for (AfilRegistrar p : pndts) {
			if (!dao.searchRegistro(p.getEmail(),p.getIdSocio(), String.format("%s %s %s ", 
					p.getSoNombre(),p.getApellidoPaterno(),p.getApellidoMaterno())) ) {
				log.info("Af Recov: "+ new Gson().toJson(p));
				try {
					BitacoraDigital bit = new BitacoraDigital(p);
					bit.setReferenciaPedido(dao.getReferenciaPedido());
					bit.setReferenciaBancaria(getReferenciaBancaria(bit.getNumSocio()));
					try {
						result.getRegistrosExistosos().add(dao.createBitacora(bit)); 
					} catch (Exception e1) {
						log.error(String.format( "Error guardado socio con id: %s,con causa: %s "
								,bit.getNumSocio(),e1.getLocalizedMessage()));
						result.getRegistrosError().add(String.format( "Error guardado socio con id: %s,con causa: %s "
								,bit.getNumSocio(),e1.getLocalizedMessage()));
					}
				} catch (Exception e) {
					result.getRegistrosError().add(String.format("Error guardado socio con id: %s,con causa: %s "
								,p.getIdSocio(),e.getLocalizedMessage()));
				}
			} else {
				log.info("error: "+ new Gson().toJson(p));
				result.getRegistrosError().add(String.format("El socio %s tiene un registro con pedido vigente",
						p.getIdSocio()));
			}
		}
		return result;
	}
	
}
