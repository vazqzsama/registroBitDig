<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
$(document).ready(function(){
	var reg = JSON.parse('${object.dato}');

	function setProperties (id,value) {
		$("#R"+id).html(value);
	}

	if (reg.soNombreStr)	setProperties ("soNomStr",reg.soNombreStr);
	if (reg.soPaternoStr)	setProperties ("soApatStr",reg.soPaternoStr);
	if (reg.soMaternoStr)	setProperties ("soAmatStr",reg.soMaternoStr);
	if(reg.soFnacDt)		setProperties ("soFnacStr",function () {	var date = new Date(reg.soFnacDt);
			return ("0"+date.getDate()).slice(-2)+"/"+("0"+(date.getMonth()+1)).slice(-2)+"/"+date.getFullYear(); });
	if(reg.soSexoStr)		setProperties ("soSexoStr",reg.soSexoStr == 'M' ? 'Masculino' : 'Femenino');
	if(reg.soEmailStr)		setProperties ("soEmailStr",reg.soEmailStr);
	if(reg.soTel4Str)		setProperties ("soCelStr",reg.soTel4Str);
	if(reg.soCalleStr)		setProperties ("soCalleStr",reg.soCalleStr);
	if(reg.soNumStr)		setProperties ("soNumStr",reg.soNumStr);
	if(reg.soInteriorStr)	setProperties ("soInteriorStr",reg.soInteriorStr);
	if(reg.soCpStr)			setProperties ("soCpStr",reg.soCpStr);
	if(reg.soIdStr)			setProperties ("soIdStr",reg.soIdStr);
	if(reg.soColStr)		setProperties ("soColStr",reg.soColStr);
	if(reg.soSoRfcStr)		setProperties ("soSoRfcStr",reg.soSoRfcStr);
	
}); 
</script>

<div>
    <div class="caption">
    	<!-- <div class="alert alert-danger text-center" role="alert">Favor de verificar.<br>* Para corregir los datos de busqueda
    	de click en el boton verde o el rojo para regresar a la ventana anterior</div> -->
<!--       <h3>Información obtenida del documento</h3> -->
       <table class="table table-condensed">
		<thead>
		    <tr class="active">
		      <th colspan="2" class="text-center">Datos generales</th>
		    </tr>
	    </thead>
	    <tbody>
    	  <tr>
	        <td style="font-weight: bold;">Id Socio</td> 
	        <td id="RsoIdStr"></td>
	      </tr>
	      <tr>
	        <td style="font-weight: bold;">RFCPrice</td> 
	        <td id="RsoSoRfcStr"></td>
	      </tr>
	      <tr>
	        <td style="font-weight: bold;">Nombre(s)</td> 
	        <td id="RsoNomStr"></td>
	      </tr>
	      <tr>
	        <td style="font-weight: bold;">A. Paterno</td> 
	        <td id="RsoApatStr"></td>
	      </tr>
	      <tr>
	        <td style="font-weight: bold;">A. Materno</td> 
	        <td id="RsoAmatStr"></td>
	      </tr>
	      <tr>
	        <td style="font-weight: bold;">Email</td>
	        <td id="RsoEmailStr"></td>
	      </tr>
	      <tr>
	        <td style="font-weight: bold;">Fecha Nac.</td>
	        <td id="RsoFnacStr"></td>
	      </tr>
	      <tr>
	        <td style="font-weight: bold;">Sexo</td>
	        <td id="sexoShow"></td>
	      </tr>
	      </tbody>
	  </table>
      <table class="table table-condensed">
		<thead>
		    <tr class="active">
		      <th colspan="2" class="text-center">Dirección Socio</th>
		    </tr>
	    </thead>
	    <tbody>
	      <tr>
	        <td style="font-weight: bold;">Calle</td>
	        <td id="RsoCalleStr"></td>
	      </tr>
	      <tr>
	        <td style="font-weight: bold;">Num. Exterior</td>
	        <td id="RsoNumStr"></td>
	      </tr>
	      <tr>
	        <td style="font-weight: bold;">Num. Interior</td>
	        <td id="RsoInteriorStr"></td>
	      </tr>
	      <tr>
	        <td style="font-weight: bold;">Código Postal</td>
	        <td id="RsoCpStr"></td>
	      </tr>
	      <tr>
	        <td style="font-weight: bold;">Colonia</td>
	        <td id="RsoColStr"></td>
	      </tr>
	      <tr>
	        <td style="font-weight: bold;">Municipio</td>
	        <td id="RsoMunicStr"></td>
	      </tr>
	      <tr>
	        <td style="font-weight: bold;">Estado</td>
	        <td id="Restado"></td>
	      </tr>
	   </tbody>
	  </table>
    </div>
</div>

