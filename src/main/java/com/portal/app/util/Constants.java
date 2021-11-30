package com.portal.app.util;

import java.time.ZoneId;

public class Constants 
{
	private Constants(){}
	/*Roles*/
	public static final String APPLICATION					   = "APPLICATION";	
	
	/*Ambiente*/
	public static final String	LOCAL							= "local";
	public static final String	TEST							= "test";
	public static final String	PRODUCCION						= "prod";
	
	/*Estatus de proceso*/
	public static final int PROCESO_CORRECTO					= 0;
	public static final int ERROR								= -1;
	public static final String FALTAN_PARAMETROS				= "Faltan parámetros de entrada";
	
	public static final String TITULO_NUM_INTERIOR_DOMICILIO 	= "NOINT";
	public static final String TITULO_REFERENCIAS_DOMICILIO 	= "REFS:";
	public static final String TITULO_ENTRE_CALLES_DOMICILIO 	= "ENTRE CALLES:";
	public static final String SEPARADOR_DATOS_DOMICILIO_OBSERVACIONES = " ; ";
	public static final String DATE_PATTERN 					= "yyyy/MM/dd";
	public static final ZoneId DEFAULT_ZONE_ID 					= ZoneId.of("America/Mexico_City");
	
	/*Correo default*/
	public static final String CORREO_DEFAULT					= "prospectosocias@priceshoes.com";
	
}
