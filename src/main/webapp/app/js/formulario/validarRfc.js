var rfc  = {};

(function () {
	
	this.updateSocio = function() {
		console.log("Actualizar socio");
		system.service({
			url: "rfc/socioUpdate",
			data: getRequestUpdateSocio(),
			callback: function (response) {
				console.log(response.message);
			},onError: function (response) {
				console.error(response.message);
			}
		}).always(function(){ });
	}
	
	function getRequestUpdateSocio(){
		return {
			soIdStr  	: $("#idsocio").val(),
			soNomStr  	: $("#nombre").val(),
			soApatStr  	: $("#paterno").val(),
			soAmatStr  	: $("#materno").val(),
			fecNacDt  	: $("#nacimiento").val(),
			soCalle  	: $("#calle").val(),
			soNumExt  	: $("#numeroExt").val(),
			soNumInt  	: $("#numeroInt").val(),
			soColStr  	: $("#colonia option:selected").text(),
			soCdStr  	: $("#ciudad").val(),
			soMunN  	: $('#colonia option:selected').data('mucven'),
			soEdoN  	: $('#colonia option:selected').data('edcven'),
			soCpStr  	: $("#cp").val(),
			soEmailStr  : $("#email").val(),
			soSexoStr  	: $("#genero").val(),
			soCelStr  	: $("#celular").val()
		}
	}
	
	function setDatosRegistro(response,loading) {
		if (response.existe) {
			var datosSocio = null;
			system.getForm({
				url: "formulario/rfcSocioEncontrado",
				data: { dato: JSON.stringify(response.registro) }
			}).done(function (form) {
				datosSocio = psDialog.dialog({
					title: "Información de Socio Encontrada",
					message: form,
					showBtnOK: false,
					btnCancel: "btnRegresar",
					btnCancelLabel: 'Continuar'
				}).open();
	
				datosSocio.getButton("btnRegresar").click(function () { 
					datosSocio.close();
				});
			});
			
			var reg = response.registro;
			if(reg.soNombreStr)		setProperties ("nombre",reg.soNombreStr);
			if(reg.soPaternoStr)	setProperties ("paterno",reg.soPaternoStr);
			if(reg.soMaternoStr)	setProperties ("materno",reg.soMaternoStr);
			if(reg.soFnacDt)		setProperties ("nacimiento",function () {	var date = new Date(reg.soFnacDt);
							return ("0"+date.getDate()).slice(-2)+"/"+("0"+(date.getMonth()+1)).slice(-2)+"/"+date.getFullYear(); });
			if(reg.genero)			setProperties ("genero",reg.genero);
			if(reg.soEmailStr)		setProperties ("email",reg.soEmailStr);
			if(reg.soTel4Str)		setProperties ("celular",reg.soTel4Str);
			if(reg.soCalleStr)		setProperties ("calle",reg.soCalleStr);
			if(reg.soNumStr)		setProperties ("numeroExt",reg.soNumStr);
			if(reg.soInteriorStr)	setProperties ("numeroInt",reg.soInteriorStr);
			if(reg.soCpStr)			$("#cp").val(reg.soCpStr);
			if(reg.soIdStr)			$("#idsocio").val(reg.soIdStr);
			if(reg.soSoRfcStr)		$("#rfcPrice").val(reg.soSoRfcStr);
			$("#divRfc").show();
		} else {
			$("#divRfc").show();
			$("#rfcPrice").val(response.rfcPrice);
			//unsetProperties();
		}
		loading.close();
	}
	
	function unsetProperties () {
		var lista = ["nombre","paterno","materno","nacimiento","genero","email","celular","calle","numeroExt","numeroInt"];
		lista.forEach(id => { 
			$("#"+id).attr('readonly', false);
			$("#"+id).attr('title', '');
			$("#"+id).off('dblclick');
		});
	}
	
	function setProperties (id,value) {
		$("#"+id).val(value);
		$("#"+id).attr('readonly', true);
		$("#"+id).attr('title', 'Doble click para desbloquear');
		$("#"+id).dblclick(function() {
			$("#"+id).attr('readonly', false);
		}); 
	}
	
	function validateCampos() {
		if ($("#nombre").val() && $("#paterno").val() && $("#materno").val() && $("#nacimiento").val() && 
			$("#genero").val() ) {
			$("#notaDesblq").hide();
			rfc.createRfc(setDatosRegistro);
		}
	}
	
	this.createRfc = function(funcCallBack) {
		var loading = psDialog.loading().open();
		system.service({
			url: "rfc/create",
			data: getParametrosRfc(),
			callback: function (response) {
				funcCallBack(response,loading);
			}, onError: function (response) {
				psDialog.error(response.message);
			}
		});
	}
	
	function getParametrosRfc() {
		return {
		  nombre: $("#nombre").val(),
		  apellidoPaterno: $("#paterno").val(),
		  apellidoMaterno: $("#materno").val(),
		  fechaNacimiento: $("#nacimiento").val(),
		  sexo: $("#genero").val()
		}
	}
	
	this.init = function () {
		var loading = psDialog.loading().open();
		$.when()
		.then(function () {
			$("#genero").change(validateCampos);
		}).always(function () {
			loading.close();
		});
	};
	
}).apply(rfc);

$(document).ready(function () {
	rfc.init();
}); 
