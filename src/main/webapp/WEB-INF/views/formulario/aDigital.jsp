<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="${resources}app/css/afiliacion.css" rel="stylesheet">
<link href="${resources}app/css/ecommerce.css" rel="stylesheet">

<script type="text/javascript">
$.getScript("${resources}app/js/formulario/aDigital.js");
</script>

<div id="divPersonales">
<div id='btnBackProcesar' style="padding: 3px;">
	<button class='btn btn-warning'><i class="fa fa-arrow-left fa-lg" aria-hidden="true"></i> Regresar a listado</button>
</div>
<div class="panel panel-blue">
	<!-- <div class="panel-heading">
		<label class="panel-title" > Generación de pedido a cliente registrado </label>
	</div> -->			
<div class="panel-body">							   
<form id="formEcommerceAfilia" class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
<div class="titleDirecciones col-lg-12 col-md-12 col-sm-12 col-xs-12"><p class=direcciones>Información General</p></div>
<div id="divPrimerosDatos" class="col-xs-12 col-sm-12 col-md-12 col-lg-12  div-form-padding-0">

	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 " style="padding: 0px;">
			<div class="col-lg-8 col-md-12 col-sm-12 col-xs-12 col-lg-offset-2 div-form-padding-0">		
				<div class="form-group">
					<label class="label-form control-label" for="nombre">
						<span class="ps-color-red"><i class="fa fa-asterisk ast-required"></i></span>
							Id Socio:
						<span class="ps-span-error"></span>	
					</label>
					<input id="idsocio" name="idsocio" class="form-control" placeholder="Id de Socio" maxlength="15">
				</div>
			</div>
	</div>

	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 " style="padding: 0px;">
			<div class="col-lg-8 col-md-12 col-sm-12 col-xs-12 col-lg-offset-2 div-form-padding-0">		
				<div class="form-group">
					<label class="label-form control-label" for="nombre">
						<span class="ps-color-red"><i class="fa fa-asterisk ast-required"></i></span>
							Nombre:
						<span class="ps-span-error"></span>	
					</label>
							<input id="nombre" name="nombre" class="form-control" placeholder="Apellido Paterno" maxlength="29">
				</div>
			</div>
	</div>
	
	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 " style="padding: 0px;">
			<div class="col-lg-8 col-md-12 col-sm-12 col-xs-12 col-lg-offset-2 div-form-padding-0">		
				<div class="form-group">
					<label class="label-form control-label" for="paterno">
						<span class="ps-color-red"><i class="fa fa-asterisk ast-required"></i></span>
							Apellido Paterno:
						<span class="ps-span-error"></span>	
					</label>
							<input id="paterno" name="paterno" class="form-control" placeholder="Apellido Paterno" maxlength="29">
				</div>
			</div>
	</div>
		
	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 " style="padding: 0px;">
			<div class="col-lg-8 col-md-12 col-sm-12 col-xs-12 col-lg-offset-2 div-form-padding-0">		
				<div class="form-group">
					<label class="label-form control-label" for="materno">
						<span class="ps-color-red"><i class="fa fa-asterisk ast-required"></i></span>
							Apellido Materno:
					</label>
							<input id="materno" name="materno" class="form-control" placeholder="Apellido Materno" maxlength="29">
				</div>
			</div>
	</div>
			
	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 ">
			<div class="col-lg-4 col-md-6 col-sm-6 col-xs-12 col-lg-offset-2 div-form-padding-0">
				<div class="form-group">
					<label class="label-form control-label" for="genero">Género</label>
					<select id="genero" name="genero" class="form-control">
							<option value="-1" selected="selected" disabled>¿Selecciona género?</option>
							<option value="M">Masculino</option>
							<option value="F">Femenino</option>
					</select>
				</div>
			</div>
		
			<div class=" col-lg-4 col-md-6 col-sm-6 col-xs-12 div-form-padding-0">
				<div class="form-group">
					<label class="label-form control-label" for="email">Correo electrónico</label>
						<input id="email" name="email" type="email" class="form-control" maxlength="100" placeholder="Email">
				</div>
			</div>
	</div>
</div>
<!-- DOCUMENTACION -->
<div id="divDocumentacion" class="col-xs-12 col-sm-12 col-md-12 col-lg-12  div-form-padding-0">
	<div class="encabezado-seccion" style="padding-bottom:10px;"></div>		
			
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 " style="padding: 0px;">
				<div class="col-lg-8 col-md-12 col-sm-12 col-xs-12 col-lg-offset-2 div-form-padding-0">
						<div class="form-group float-label">
							<label class="label-form control-label">Celular (10 dígitos)
							<span class="ps-span-error"></span>	
							</label>
							<input id="celular" name="celular" maxlength="10" class="form-control" placeholder="Celular (10 dígitos-sin espacios)">
						</div>
				</div>
			</div>
				
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 " style="padding: 0px;">
				<div class="col-lg-8 col-md-12 col-sm-12 col-xs-12 col-lg-offset-2 div-form-padding-0">
						<div class="form-group float-label">
							<label id="lblFN" class="label-form control-label header-label" for="nacimiento">Fecha de nacimiento </label>
							<input id="nacimiento" type="text" name="nacimiento" class="form-control" placeholder="Fecha de nacimiento" readonly="readonly">
						</div>
				</div>
			</div>
			
<div class="titleDirecciones col-lg-12 col-md-12 col-sm-12 col-xs-12"><p class=direcciones>Direcciones</p></div>	
					
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 " style="padding: 0px;">
				<div class="col-lg-8 col-md-12 col-sm-12 col-xs-12 col-lg-offset-2 div-form-padding-0">		
					<div class="form-group float-label">
						<label class="label-form control-label" for="calle">Calle</label>
						<input id="calle" name="calle" class="form-control" maxlength="99" placeholder="Calle">
					</div>
				</div>
			</div>
			
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 " style="padding: 0px;">
				<div class="col-lg-4 col-md-6 col-sm-6 col-xs-6 div-input col-lg-offset-2 div-form-padding-l-0">
					<div class="form-group float-label num-ext">
						<label class="label-form control-label" for="numeroExt">Número exterior</label>
						<input id="numeroExt" maxlength="10" name="numeroExt" class="form-control" placeholder="Núm. ext.">
					</div>
	            </div>
	            
	            <div class="col-lg-4 col-md-6 col-sm-6 col-xs-6 div-input div-form-padding-r-0">
					<div class="form-group float-label">
						<label class="label-form control-label" for="numeroInt">Número interior</label>
						<input id="numeroInt"  maxlength="10" name="numeroInt" class="form-control" placeholder="Núm. int.">
					</div>
				</div>
			</div>
			
			<div class="col-lg-8 col-md-12 col-sm-12 col-xs-12 col-lg-offset-2 div-form-padding-0">
				<ul class="nav nav-tabs"> 
					<li class="active"><a data-toggle="tab" href="#dirByCP" style="outline: none;">Busca C.P.</a></li>
				</ul>
			</div>
			
			<div class="tab-content">
			 	<div id="dirByCP" class="tab-pane  in active">
   					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 " style="padding: 0px;">
						<div class="col-lg-4 col-md-6 col-sm-6 col-xs-6 div-input col-lg-offset-2 div-form-padding-l-0">
							<label class="label-form control-label" for="cp">Código postal</label>
							<div class="input-group">
							 <input id="cp" name="cp" class="form-control" placeholder="C.P." maxlength="7" type="number">
						      <span class="input-group-btn">
						        <button id="clearSoCpStr" class="btn btn-default" type="button"><i class="fa fa-times" aria-hidden="true"></i></button>
						      </span>
						    </div>
						</div>
						
						<div class="form-group col-lg-4 col-md-6 col-sm-6 col-xs-6 div-input div-form-padding-r-0"  style="padding-bottom:10px;">
							<label class="label-form control-label">&nbsp;</label>
							<button id="btnBuscar" class="btn btn-primary" style="width:100%;" type="button">Buscar</button>
						</div>
					</div>
		  		</div>

			</div>
			
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 " style="padding: 0px;">
						<div class="col-lg-4 col-md-6 col-sm-6 col-xs-12 col-lg-offset-2 div-form-padding-0">
							<div class="form-group">
								<label class="label-form control-label" for="colonia">Colonia</label>
								<select id="colonia" name="colonia" class="form-control">
								</select>
							</div>
						</div>
					
						<div class=" col-lg-4 col-md-6 col-sm-6 col-xs-12 div-form-padding-0">
							<div class="form-group">
								<label class="label-form control-label" for="municipio">Municipio</label>
									<input id="municipio" name="municipio" class="form-control" maxlength="50" placeholder="Municipio" readonly="readonly">
							</div>
						</div>
					</div>
					
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 " style="padding: 0px;">
						<div class=" col-lg-4 col-md-6 col-sm-6 col-xs-12 col-lg-offset-2 div-form-padding-0">
							<div class="form-group">
								<label class="label-form control-label" for="estado">Estado</label>
								<input id="estado" name="estado" class="form-control" placeholder="Estado" readonly="readonly">
							</div>
						</div>
							
						<div class=" col-lg-4 col-md-6 col-sm-6 col-xs-12 div-form-padding-0 ">
							<div class="form-group ">
								<label class="label-form control-label" for="ciudad">Ciudad</label>
								<input id="ciudad" name="ciudad" class="form-control" placeholder="Ciudad" maxlength="49" readonly="readonly">
							</div>
						</div>
					</div>
						
</div>	

<div id="divTercerBloque" class="col-xs-12 col-sm-12 col-md-12 col-lg-12  div-form-padding-0">	
		<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 " style="padding: 0px;">
				<div class="col-lg-8 col-md-12 col-sm-12 col-xs-12 col-lg-offset-2 div-form-padding-0">
					<div class="form-group">
						<select id="mismoDom" name="mismoDom" class="form-control">
								<option value="-1" selected="selected" disabled>¿En este domicilio se le haría llegar su paquete de afiliación?</option>
								<option value="1">Misma dirección para envío</option>
								<option value="2">Agregar una dirección diferente para envío</option>
						</select>
					</div>				
				</div>
		</div>
		
		<div id="referencias" class="col-lg-12 col-md-12 col-sm-12 col-xs-12 " style="display: none;">
				<div class="col-lg-8 col-md-12 col-sm-12 col-xs-12 col-lg-offset-2 div-form-padding-0">		
					<div class="form-group float-label">
						<label class="label-form control-label" for="referencias">
							<span class="ps-color-red"><i class="fa fa-asterisk ast-required"></i></span>
								Referencias:
							<span class="ps-span-error"></span>	
						</label>
							<input id="referencias" name="referencias" class="form-control" placeholder="Referencias" maxlength="50">
					</div>
				</div>
		</div>	
		
		<div id="entreCalles" class="col-lg-12 col-md-12 col-sm-12 col-xs-12 " style="display: none;">
					<div class="col-lg-8 col-md-12 col-sm-12 col-xs-12 col-lg-offset-2 div-form-padding-0">		
						<div class="form-group float-label">
							<label class="label-form control-label" for="entreCalles">
								<span class="ps-color-red"><i class="fa fa-asterisk ast-required"></i></span>
									Entre calles:
								<span class="ps-span-error"></span>	
							</label>
								<input id="entreCalles" name="entreCalles" class="form-control" placeholder="Entre calles" maxlength="30">
						</div>
					</div>
			</div>		
</div>		

<div id="divCuertoBloque" class="col-xs-12 col-sm-12 col-md-12 col-lg-12  div-form-padding-0">				
	<div id="domEnvio" class="col-xs-12 col-sm-12 col-md-12 col-lg-12 padding-left-0 padding-right-0" style="display: none;">	
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 " style="padding: 0px;">
					<div class="col-lg-8 col-md-12 col-sm-12 col-xs-12 col-lg-offset-2 div-form-padding-0">		
						<div class="form-group float-label">
							<label class="label-form control-label" for="calleO">Calle</label>
							<input id="calleO" name="calleO" class="form-control" maxlength="99" placeholder="Calle">
						</div>
					</div>
			</div>
			
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 " style="padding: 0px;">
				<div class="col-lg-4 col-md-6 col-sm-6 col-xs-6 div-input col-lg-offset-2 div-form-padding-l-0">
					<div class="form-group float-label num-ext">
						<label class="label-form control-label" for="numeroExtO">Número exterior</label>
						<input id="numeroExtO" maxlength="10" name="numeroExtO" class="form-control" placeholder="Núm. ext.">
					</div>
	            </div>
	            
	            <div class="col-lg-4 col-md-6 col-sm-6 col-xs-6 div-input div-form-padding-r-0">
					<div class="form-group float-label">
						<label class="label-form control-label" for="numeroIntO">Número interior</label>
						<input id="numeroIntO" maxlength="10" name="numeroIntO" class="form-control" placeholder="Núm. int.">
					</div>
				</div>
			</div>
			
			<div class="col-lg-8 col-md-12 col-sm-12 col-xs-12 col-lg-offset-2 div-form-padding-0">
				<ul class="nav nav-tabs"> 
					<li class="active"><a data-toggle="tab" href="#dirByCP" style="outline: none;">Busca C.P.</a></li>
<!-- 					<li ><a data-toggle="tab" href="#dirByCol" style="outline: none;">Buscar Colonia</a></li>  -->
				</ul>
			</div>
			
			<div class="tab-content">
			 	<div id="dirByCP" class="tab-pane  in active">
   					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 " style="padding: 0px;">
						<div class="col-lg-4 col-md-6 col-sm-6 col-xs-6 div-input col-lg-offset-2 div-form-padding-l-0">
							<label class="label-form control-label" for="cpO">Código postal</label>
							<div class="input-group">
							 <input id="cpO" name="cpO" class="form-control" placeholder="C.P." maxlength="7" type="number">
						      <span class="input-group-btn">
						        <button id="clearSoCpStr" class="btn btn-default" type="button"><i class="fa fa-times" aria-hidden="true"></i></button>
						      </span>
						    </div>
						</div>
						
						<div class="form-group col-lg-4 col-md-6 col-sm-6 col-xs-6 div-input div-form-padding-r-0"  style="padding-bottom:10px;">
							<label class="label-form control-label">&nbsp;</label>
							<button id="btnBuscarO" class="btn btn-primary" style="width:100%;" type="button">Buscar</button>
						</div>
					</div>
		  		</div>

			</div>
			
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 " style="padding: 0px;">
				<div class="col-lg-4 col-md-6 col-sm-6 col-xs-12 col-lg-offset-2 div-form-padding-0">
					<div class="form-group">
						<label class="label-form control-label" for="coloniaO">Colonia</label>
						<select id="coloniaO" name="coloniaO" class="form-control">
						</select>
					</div>
				</div>
			
				<div class=" col-lg-4 col-md-6 col-sm-6 col-xs-12 div-form-padding-0">
					<div class="form-group">
						<label class="label-form control-label" for="municipioO">Municipio</label>
							<input id="municipioO" name="municipioO" class="form-control" maxlength="49" placeholder="Municipio" readonly="readonly">
					</div>
				</div>
			</div>
					
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 " style="padding: 0px;">
				<div class=" col-lg-4 col-md-6 col-sm-6 col-xs-12 col-lg-offset-2 div-form-padding-0">
					<div class="form-group">
						<label class="label-form control-label" for="estadoO">Estado</label>
						<input id="estadoO" name="estadoO" class="form-control" placeholder="Estado" readonly="readonly">
					</div>
				</div>
					
				<div class=" col-lg-4 col-md-6 col-sm-6 col-xs-12 div-form-padding-0 ">
					<div class="form-group ">
						<label class="label-form control-label" for="ciudadO">Ciudad</label>
						<input id="ciudadO" name="ciudadO" class="form-control" placeholder="Ciudad" maxlength="49" readonly="readonly">
					</div>
				</div>
			</div>
					
			<div id="referenciasO"  class="col-lg-12 col-md-12 col-sm-12 col-xs-12 " style="padding: 0px;">
					<div class="col-lg-8 col-md-12 col-sm-12 col-xs-12 col-lg-offset-2 div-form-padding-0">		
						<div class="form-group float-label">
							<label class="label-form control-label" for="referenciasO">
								<span class="ps-color-red"><i class="fa fa-asterisk ast-required"></i></span>
									Referencias:
								<span class="ps-span-error"></span>	
							</label>
								<input id="referenciasO" type="tel" name="referenciasO" class="form-control" placeholder="Referencias" maxlength="50">
						</div>
					</div>
			</div>
			
			<div id="entreCallesO"  class="col-lg-12 col-md-12 col-sm-12 col-xs-12 " style="display: none;">
					<div class="col-lg-8 col-md-12 col-sm-12 col-xs-12 col-lg-offset-2 div-form-padding-0">		
						<div class="form-group float-label">
							<label class="label-form control-label" for="entreCallesO">
								<span class="ps-color-red"><i class="fa fa-asterisk ast-required"></i></span>
									Entre calles:
								<span class="ps-span-error"></span>	
							</label>
								<input id="entreCallesO" type="tel" name="entreCallesO" class="form-control" placeholder="Entre calles" maxlength="30">
						</div>
					</div>
			</div>
	</div>
</div>
	
	<!-- CATALOGOS/PAQUETES -->
	<div id="divCatalogos" class="col-xs-12 col-sm-12 col-md-12 col-lg-12 padding-left-0 padding-right-0" style="display: none;">
		
		<div id="tabPaqCatContainer"></div>
		
			<div class="tab-content">
				<div id="paquetes" class="tab-pane fade in active">
			    	<div style="padding-right:15px; padding-left:15px; padding-top: 10px;">
			    		<label class="text-normal">Al comprar los catálogos aceptas los <b>Términos y Condiciones</b>. Elige uno de los paquetes disponibles.</label>
			    	</div>
			    	<div id="divPaquetesContainer" style="height: 58vh; overflow: auto; border: solid 1px #DA0080; padding: 0px;">
			    	
			    	</div>
			  	</div>
			  	
			  	<div id="catalogos" class="tab-pane fade">
			    	<div style="padding-right:15px; padding-left:15px; padding-top: 10px;">
			    		<label class="text-normal">Al comprar los catálogos aceptas los <b>Términos y Condiciones</b>. Elige mínimo 4 catálogos incluyendo uno de temporada.</label>
			    	</div>
			    	<div id="divCatalogosContainer" style="height: 58vh; overflow: auto; border: solid 1px #DA0080; padding: 0px;">
			    	</div>
			  	</div>
			</div>
	</div>	
	<!-- Enviar Solicitud style="display: none;"-->
	<div id="divConfirmaEnvia" style="display: none;"
		class="col-lg-6 col-md-6 col-sm-12 col-xs-12 col-lg-offset-3 col-md-offset-3 div-form-padding-0" align="center">
		<div class="panel panel-blue">
			<div class="panel-heading">
				<label style="font-size: 1.1em;">Pedido</label>
			</div>
			<div class="panel-body" id="">
				
				<div id="divResumenPaqCat" class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				</div>				
				
				<label style="font-size: 1.2em; " class="col-lg-12 col-sm-12 col-md-12 col-xs-12"> 
					Afiliación: <span id="spanTotalPagar" style="color: #DA0080;"></span>
				</label>
				
				<label style="font-size: 1.2em; " class="col-lg-12 col-sm-12 col-md-12 col-xs-12"> 
					Costo envió: <span id="spanEnvio" style="color: #DA0080;"></span>
				</label>
				
				<label style="font-size: 1.2em; " class="col-lg-12 col-sm-12 col-md-12 col-xs-12"> 
					Costo seguro: <span id="spanSeguro" style="color: #DA0080;"></span>
				</label>
				
				<label style="font-size: 1.2em; " class="col-lg-12 col-sm-12 col-md-12 col-xs-12"> 
					Importe Total: <span id="spanTotal" style="color: #DA0080;"></span>
				</label>
				<span id="spanAhorro"></span>				
			</div>
		</div>
	</div>
	
	<!-- Formas de pago	 style="display: none;"-->
 	<div id="divFormasPagoReferencia" class="col-xs-12 col-sm-12 padding-left-0 padding-right-0"style="display: none;" > 
		<div class="panel panel-blue">
			<div class="panel-heading">
				<label class="panel-title" >Formas de pago</label>
			</div>
		</div>
		<br/>
		<br/>
		<br/>
		<div id="divTiposPago" class="col-lg-6 col-md-6 col-sm-12 col-xs-12 " style="padding: 0px;">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="form-group">
						<label class="label-form control-label" for="formaPago">Tipo de pago</label>
						<select id="formaPago" name="formaPago" class="form-control">
							<option value="-1" selected="selected" disabled>¿Forma de pago utilizada?</option>
							<option value="1">Efectivo(OXXO, 7ELEVEN)</option>
							<option value="5">Tarjeta de credito/debito</option>
							<option value="19">Depósito (BANCOMER, BANAMEX)</option>
						</select>
					</div>
				</div>
		</div>
		
		<div id="divReferencia" class="col-lg-6 col-md-6 col-sm-12 col-xs-12 "style="display: none;">	
				<div class=" col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="form-group">
						<label class="label-form control-label" for="metodoPago">JesusValor</label>
							<input id="metodoPago" name="metodoPago" class="form-control" maxlength="75" readonly="readonly">
					</div>
				</div>
		</div>
		
		<div id="divReferencia" class="col-lg-6 col-md-6 col-sm-12 col-xs-12 " style="padding: 0px;">	
				<div class=" col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="form-group">
						<label class="label-form control-label" for="referencia">Referencia</label>
							<input id="referencia" name="referencia" class="form-control" maxlength="75" readonly="readonly">
					</div>
				</div>
		</div>
		
		
		<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12" id="divBtnGuardar" style="display: none;">	
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="form-group">
						<label class="label-form control-label" for="referencia">Guardar afiliación</label>
						<button id="btnGuardar" class="btn btn-success form-control">Afiliar</button>
					</div>	
				</div>
				
		</div>
		
		<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12" id="divBtnTerminarAfiliacion" style="display: none;">	
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="form-group">
						<button id="btnFinalizarProceso" class="btn btn-success form-control">Finalizar proceso</button>
					</div>	
				</div>
				
		</div>
		
		<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12" id="divBtnPagar" style="display: none;">	
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="form-group">
						<label class="label-form control-label" for="btnPagar" onclick='console.log("Hello")'>Mercado Pago</label>
						<button id="btnPagar" class="btn btn-info form-control" style="display: none;">Pagar</button>
					</div>	
				</div>
				
		</div>
<!-- DEPOSITO BANCARIO	 style="display: none;"-->
			<div id="depositoBancario" class="col-lg-6 col-md-6 col-sm-12 col-xs-12 " style="display: none;">	
					<div class=" col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<div class="form-group">
							<label class="label-form control-label" for="abeDepBanStr">Referencia bancaria</label>
								<input id="abeDepBanStr" name="abeDepBanStr" class="form-control" maxlength="75" readonly="readonly">
						</div>
					</div>
			</div>
			<div id="tabladepositoBancario" style="display: none;" class="container">
			  <table class="table">
			    <thead>
			      <tr>
			        <th>Banco</th>
			        <th>Cuenta</th>
			        <th>Razón social</th>
			      </tr>
			    </thead>
			    <tbody>
			      <tr class="info">
			        <td>Bancomer</td>
			        <td>Convenio 628565</td>
			        <td>Grupo Empresarial SJ, S.A. de C.V.</td>
			      </tr>      
			      <tr class="info">
			        <td>Banamex</td>
			        <td>Sucursal 218 Cuenta7408337</td>
			        <td>Grupo Empresarial SJ, S.A. de C.V.</td>
			      </tr>
			      <tr class="info">
			        <td></td>
			        <td>Total</td>
			        <td id="tdTotalTransfer">$</td>
			      </tr>         
			    </tbody>
			  </table>
			</div>
	</div>
</form>	
</div>
</div>
</div>
<!--Botones siguiente y atras-->
<div id="divControls" class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
	
		<div class="col-lg-2 col-md-2 col-sm-12 col-xs-12">
			<button id="btnValidar" class="btn btn-primary btn-sm form-control">Validar formulario</button>
		</div>
		
		<div class="col-lg-2 col-md-2 col-sm-12 col-xs-12">
			<button id="btnPaquetes" class="btn btn-primary btn-sm form-control" style="display:none;">Validar paquetes</button>
		</div>
		
		<div class="col-lg-2 col-md-2 col-sm-12 col-xs-12">
			<button id="btnRegresarDatos" class="btn btn-info btn-sm form-control" style="display:none;">Regresar a datos</button>
		</div>
		
		<div class="col-lg-2 col-md-2 col-sm-12 col-xs-12">
			<button id="btnRegresar" class="btn btn-info btn-sm form-control" style="display:none;">Regresar paquetes</button>
		</div>
		
		<div class="col-lg-2 col-md-2 col-sm-12 col-xs-12">
			<button id="btnSiguiente" class="btn btn-success btn-sm form-control" style="display:none;">Pasar a pagar</button>
		</div>				
</div>
	



