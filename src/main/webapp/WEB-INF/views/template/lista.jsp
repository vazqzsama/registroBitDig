<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.1/moment.min.js"></script>
<script type="text/javascript">
var cliente   = {};
(function() {
	var server = '';
	var $tablePendientes = $("#tablePendientes");
	var isValido = false;
	var request = {};
	
	this.ajaxRequest = function(params) {
		if( !isValido ) {
			$(".fixed-table-loading").html("");
			return false;
		} else {
			var loading = psDialog.loading().open();
	        system.service ({
				url: cliente.ajaxUrl,
				data:{ filtro: getFiltro(), pager:params, total: cliente.total },
				callback:function(response) {
					var rows  = response[cliente.responseData];
					cliente.total = response.total;
					params.success({ rows: rows, total: cliente.total });
				}
			}).always(function(){ loading.close(); system.updateView(500); });
		}
	};
	
	this.reset = function() {
		cliente.table = null;
		cliente.filtro = getFiltro();
		cliente.ajaxUrl = null;
		cliente.responseData = null; 
	}
	
	this.crearTabla = function( params ) {
		var defaults = {
					table:null,
					sidePagination:'client',
					ajax:null,
					delay:500,
					setToolBarButtons:null,
					onExpandRow:null
				};
		var opts = $.extend({},defaults, params);
		var $table = opts.table;
		
		$table.bootstrapTable("destroy"); 
		$table.data("sidePagination",opts.sidePagination);
		$table.data("ajax",opts.ajax);
			
		$table.bootstrapTable ({
			 onClickRow:function (row, $element, field){ $table.find('.success').removeClass('success'); $element.addClass("success"); },
		     onPostBody:function(){ $table.bootstrapTable("resetView"); },
		     onExpandRow: function (index, row, $detail){ if( opts.onExpandRow!=null) opts.onExpandRow($detail,row); },
		     formatDetailPagination: function (totalRows) {return '  Mostrando '+totalRows+' elementos';  }
		});
		
		if( opts.setToolBarButtons != null ){ opts.setToolBarButtons(); }
		$table.innerFixDropDowns();
	};
		
	function getFiltro() {
		return {
			idSocio  : 	$("#idSocio").val().length > 0 ? $("#idSocio").val() : null,
			email 	 : 	$("#correo").val().length > 0 ? $("#correo").val() : null,
			soNombre : 	$("#soNombre").val().length > 0 ? $("#soNombre").val() : null,
			aPaterno : 	$("#aPaterno").val().length > 0 ? $("#aPaterno").val() : null,
			aMaterno : 	$("#aMaterno").val().length > 0 ? $("#aMaterno").val() : null,
			idUser	 :	system.user.idUsrN,
			estatus	 :  $("#statusP").val().length > 0 ? $("#statusP").val() : null,
		};
	}
	
	function clickConsultar() {
		system.blockButton( $(this) );
		isValido = true;
		cliente.crearTabla ({
			table:cliente.table,
			sidePagination:'server',
			ajax:'cliente.ajaxRequest',
			setToolBarButtons:setToolBarButtons
		});
	}
	
	this.accion = function(value,row) {
		row.fnac = moment(new Date(row.fnac)).format('DD/MM/YYYY');
		row.email = "iscvazqz@gmail.com";
		if (row.cp) row.cp = (row.cp.length < 5 ? '0'.concat(row.cp) : row.cp).toString();
		if (row.soTipoStr == 'N' && (row.estatusPedido == 'C' || row.estatusPedido == null)) {
			var icon = '<i class="fa fa-shopping-bag fa-lg"></i>';
			return '<a title="Crear pedido" class="btn btn-sm btn-primary" '+
					"onclick='$cntr.formulario("+JSON.stringify(row)+")'"+' >'+icon+'</a>';
		} else return '';
	}
	
	this.direccion = function(value,row) {
		if (row.cp) row.cp = (row.cp.length < 5 ? '0'.concat(row.cp) : row.cp).toString();
		var icon = '<i class="fa fa-eye fa-lg"></i>';
		return '<a title="Ver" class="btn btn-sm btn-info" '+ 
				"onclick='cliente.infoDireccion("+JSON.stringify(row)+")'"+' >'+icon+'</a>';
	}
	
	this.estatusSocio  = function(value,row) {
		return value == 'N' ? 'Cliente' : 'Socio';
	}
	
	this.pedido  = function(value,row) {
		return value ? value : 'Sin pedido de Afiliación';
	}
	
	this.estatusPedido = function(value,row) {
		switch(value){
			case "T":
				return "Apartado";
			break;
			case "C":
				return "Cancelado";
			break;
			case "V":
				return "Vendido";
			break;
			default:
				return "N/A";
			break;
		}
	}
	
	this.dateFormat = function(value,row) {
		return moment(new Date(value)).format('YYYY-MM-DD HH:mm:ss');
	}
	
	this.fullName = function(value,row) {
		return row.soNombre+" "+row.apellidoPaterno+" "+row.apellidoMaterno;
	}
	
	function setToolBarButtons() {
		var $toolbar = $("#tablePendientes");
		$toolbar.prepend('');
	}
	
	this.infoDireccion = function (datos) {
		if(datos) {
			datos.fullName = datos.soNombre+" "+datos.apellidoPaterno+" "+datos.apellidoMaterno;
			cliente.direccionTmp = datos;
			system.getForm({
				url: "template/detalleDireccion"
			}).done(function (form) {
				cliente.detalleDir = psDialog.dialog({
					title: "<b>Dirección</b>",
					message: form,
					showBtnOK: false,
					btnCancel: "btnCancelar",
					btnCancelLabel: 'Cerrrar'
				}).open();
	
				cliente.detalleDir.getButton("btnCancelar").click(function () {
					cliente.detalleDir.close();
				});
			});
		} else {
			psDialog.warning("No hay datos de cliente.");
		}
	}
	
	this.init = function() {
		var loading = psDialog.loading().open();
		cliente.reset();
		cliente.table  			= $("#tablePendientes");
		cliente.ajaxUrl 		= "getClientesRegistrados";
		cliente.responseData 	= "clientes";
		
		cliente.crearTabla({
			table:cliente.table,
			sidePagination:'server',
			ajax:'cliente.ajaxRequest',
			setToolBarButtons:setToolBarButtons
		});
		
		$.when( ).done(function() {
			$('#btnConsultar').click(clickConsultar);
			$(".form-control").keypress(function(e) {
			    if(e.which == 13) {
			      e.preventDefault();
			      clickConsultar();
			    }
			  });
			
		}).always(function(){ loading.close(); });
	};
	
}).apply(cliente);
$(document).ready(cliente.init);

</script>

<div id="divPanelPricipal" class="panel panel-blue">
	<div id="divFiltro" class="panel-body padding-1">
		<div class="col-lg-3 col-md-3 col-sm-6 col-xs-6">
			<label class="control-label lbl-filter" for="socio">Id Socio:</label>
			<input type="text" id="idSocio" class="form-control" placeholder="Número de socio"></input>
		</div>
		
		<div class="col-lg-3 col-md-3 col-sm-6 col-xs-6">
			<label class="control-label lbl-filter" for="soNombre">Nombre(s):</label>
			<input type="text" id="soNombre" class="form-control" placeholder="Nombre(s)"></input>
		</div>
		
		<div class="col-lg-3 col-md-3 col-sm-6 col-xs-6">
			<label class="control-label lbl-filter" for="aPaterno">A. Paterno:</label>
			<input type="text" id="aPaterno" class="form-control" placeholder="Apellido Paterno"></input>
		</div>
		
		<div class="col-lg-3 col-md-3 col-sm-6 col-xs-6">
			<label class="control-label lbl-filter" for="aMaterno">A. Materno:</label>
			<input type="text" id="aMaterno" class="form-control" placeholder="Apellido Materno"></input>
		</div>
		
		<div class="col-lg-3 col-md-3 col-sm-6 col-xs-6">
			<label class="control-label lbl-filter" for="correo">Email:</label>
			<input type="text" id="correo" class="form-control" placeholder="Correo Electrónico"></input>
		</div>
		
		<div class="col-lg-3 col-md-3 col-sm-6 col-xs-6">
			<label class="control-label lbl-filter" for="statusP">Estatus:</label>
			<select id="statusP" name="statusP" class="form-control">
				<option value="">Todos</option>
				<option value="N">Cliente</option>
				<option value="R">Socio</option>
			</select>
		</div>
			
		<div class="col-lg-3 col-md-3 col-sm-6 col-xs-6">
			<label class="control-label lbl-filter">
				&nbsp;
			</label>
			<button type="submit" id="btnConsultar" class="btn btn-primary form-control">
			<i class="fa fa-search" aria-hidden="true"></i> Consultar
			</button>
		</div>
	</div>

	<hr class="ps-hr-b-0">
	
	<div id="tableContainer" style="padding-top: 0em;" class="panel-body padding-0">
		<table  id="tablePendientes"
			data-toolbar-name="tablePendientesTB"
	   		data-show-columns="false"
			data-row-style="system.rowStyle"
	  		data-pagination="true"
	  		data-page-size="25"
	   		data-page-list="[25,50,75,100]"
	  		data-unique-id ="idSocio"
	  		data-maintain-selected=true
	  		data-icons="system.icons"
	  		data-sticky-header="true"
	  		data-show-export="false"
			data-export-data-type="all"
  		>
		<thead>	
			<tr>
				<th data-field="idSocio"
					data-sortable="true"
					data-switchable="false"
					data-align="center">Id Socio</th>
				
				<th data-field="falta"
					data-sortable="true"
					data-switchable="false"
					data-formatter="cliente.dateFormat"
					data-align="center">Fecha Registro</th>
				
				<th data-field="soTipoStr"
					data-align="center"	
					data-formatter="cliente.estatusSocio"
					data-sortable="true">Estatus Socio</th>
				
				<th data-field="soNombre"
					data-align="center"
					data-formatter="cliente.fullName"
					data-sortable="true">Nombre</th>
						
				<!-- <th data-field="apellidoPaterno"
					data-sortable="true"
					data-align="center"
					data-switchable="false">A. Paterno</th>
				
				<th data-field="apellidoMaterno"
					data-sortable="true"
					data-align="center"
					data-switchable="false">A. Materno</th>
					 -->
				<th data-field="email"
					data-sortable="true"
					data-align="center">Email</th>
								
				<th data-field="telefono"
					data-sortable="true"
					data-align="center">Telefono</th>
					
				<th data-field="pedido"
					data-sortable="true"
					data-formatter="cliente.pedido"
					data-align="center">Pedido</th>
				
				<th data-field="estatusPedido"
					data-align="center"	
					data-formatter="cliente.estatusPedido"
					data-sortable="false">Estatus Pedido</th>
					
				<th data-align="center"
					data-formatter="cliente.direccion"	
					data-sortable="false">Direccion</th>
					
				<th data-align="center"
					data-formatter="cliente.accion"	
					data-sortable="false">Acción</th>
					
			</tr>
		</thead>
	</table>
	</div>
	
</div>