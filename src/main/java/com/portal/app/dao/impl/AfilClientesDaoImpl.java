package com.portal.app.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.portal.app.dao.AfilClientesDao;
import com.portal.app.dto.ClientesPagina;
import com.portal.app.request.BusquedaRequest;

@Repository
@Transactional(readOnly=true,rollbackFor = Exception.class)
public class AfilClientesDaoImpl implements AfilClientesDao {
	
	//@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(AfilClientesDaoImpl.class);

	@Autowired
	private SessionFactory session;

	@SuppressWarnings("unchecked")
	@Override
	public List<ClientesPagina> getClienteRegistrados(BusquedaRequest request) {
		log.info(new Gson().toJson(request));
		return session.getCurrentSession().getNamedQuery("P_GET_CLIENTES_PEND")
			.setParameter("correo", request.getFiltro().getEmail() )
			.setParameter("nombre", request.getFiltro().getSoNombre() )
			.setParameter("apaterno", request.getFiltro().getaPaterno() )
			.setParameter("amaterno", request.getFiltro().getaMaterno() )
			.setParameter("idsocio", request.getFiltro().getIdSocio() )
			.setParameter("estatus", request.getFiltro().getEstatus() )
			.setParameter("sortby", request.getPager().getData().getSort() )
			.setParameter("orderby", request.getPager().getData().getOrder() )
			.setParameter("limit", request.getPager().getData().getLimit() )
			.setParameter("offset", request.getPager().getData().getOffset() )
			.list();
	}
	
	@Override
	public Integer getCountBusqueda(BusquedaRequest request) {
		log.info("getCountBusqueda(Parametros): "+new Gson().toJson(request));
		String query = " select PKG_REC_AFL_SIT.F_GET_CLIENTES_COUNT(:correo,:nombre,:apaterno,:amaterno,:idsocio,:estatus) from dual ";
		
		BigDecimal result = (BigDecimal) session.getCurrentSession().createSQLQuery(query)
				.setParameter("correo", request.getFiltro().getEmail() )
				.setParameter("nombre", request.getFiltro().getSoNombre() )
				.setParameter("apaterno", request.getFiltro().getaPaterno() )
				.setParameter("amaterno", request.getFiltro().getaMaterno() )
				.setParameter("idsocio", request.getFiltro().getIdSocio() )
				.setParameter("estatus", request.getFiltro().getEstatus() )
			.uniqueResult();
		return result.intValue();
	}
	
} 