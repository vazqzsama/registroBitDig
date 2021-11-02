<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<script type="text/javascript">
$(document).ready(function(){
	$.each(cliente.direccionTmp, function (tag, value) {
		try {
			if (tag == 'soTipoStr')
				value = value == 'N' ? 'Cliente' : 'Socio';
			$("#D"+tag).html(value);
		} catch (e) {}
		
	});
}); 
</script>
    
<div class="panel panel-blue">
	<div class="panel-body padding-0" style="margin-left: 5px;margin-right: 5px">
		<table class="table table-condensed">
		    <tbody>
		      <tr>
		        <td><b>Nombre</b></td> 
		        <td id="DfullName"></td>
		      </tr>
		      <tr>
		        <td><b>Id Socio</b></td>
		        <td id="DidSocio"></td>
		      </tr>
		      <tr>
		        <td><b>Email</b></td>
		        <td id="Demail"></td>
		      </tr>
		      <tr>
		        <td><b>Teléfono</b></td>
		        <td id="Dtelefono"></td>
		      </tr>
		      <tr>
		        <td><b>Estatus Socio</b></td>
		        <td id="DsoTipoStr"></td>
		      </tr>
		      <tr>
		        <td><b>Referencia</b></td>
		        <td id="Dref"></td>
		      </tr>
		   </tbody>
	  </table>
	</div>
	<div class="panel-body" style="padding-bottom: 0px; margin-bottom: 0px;padding-top: 0px; margin-top: 0px;">
		<table class="table table-condensed">
		    <tbody>
	    	  <thead>
			    <tr >
			      <th>Campo</th>
			      <th>Dato</th>
			    </tr>
		      </thead>
		      <tr>
		        <td><b>Calle</b></td> 
		        <td id="Dcalle"></td>
		      </tr>
		      <tr>
		        <td><b>Número Exterior</b></td>
		        <td id="DnoExterior"></td>
		      </tr>
		      <tr>
		        <td><b>Número Interior</b></td>
		        <td id="DnoInterior"></td>
		      </tr>
		      <tr>
		        <td><b>Colonia</b></td>
		        <td id="Dcolonia"></td>
		      </tr>
		      <tr>
		        <td><b>Municipio</b></td>
		        <td id="DmunicipioDesc"></td>
		      </tr>
		      <tr>
		        <td><b>Estado</b></td>
		        <td id="DestadoDesc"></td>
		      </tr>
		      <tr>
		        <td><b>Ciudad</b></td>
		        <td id="Dciudad"></td>
		      </tr>
		      <tr>
		        <td><b>Código Postal</b></td>
		        <td id="Dcp"></td>
		      </tr>
		      <tr>
		        <td><b>Referencia</b></td>
		        <td id="Dreferencia"></td>
		      </tr>
		      <tr>
		        <td><b>Entre Calles</b></td>
		        <td id="DentreCalles"></td>
		      </tr>
		      
		   </tbody>
	  </table>
	</div>
</div>