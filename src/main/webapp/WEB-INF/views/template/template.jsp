<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
var $cntr = {};
(function() {
	var cliente   = {};
	this.table = function () {
		system.getForm({
			url: "template/lista"
		}).done(function (form) {
			$('#listado').html(form);
			$('#listado').show();
			$('#formulario').hide();
		});
	}
	
	this.formulario = function (datos) {
		sessionStorage.setItem('infoSocioTmp', JSON.stringify(datos) );
		system.getForm({
			url: "formulario/aDigital"
		}).done(function (form) {
			$('#formulario').html(form);
			$('#listado').hide();
			$('#formulario').show();
		});
	}
	
	this.init = function() {
		var loading = psDialog.loading().open();		
		$.when(
			$cntr.table()
		).done(function() {
			
		}).always(function(){ loading.close(); });
	};
	
}).apply($cntr);
$(document).ready($cntr.init);
</script>

<div id="mainContainer" class="panel panel-blue">

	<div id="listado"></div>
	<div id="formulario"></div>

</div>