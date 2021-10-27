<script>
var paqueteria={};
(function() {
	var $dato = '${object.dato}';
	var $tablePaqueteria = $("#tablePaqueteria");
	/*this.service=function(params) {  
	    var defaults = {
	            url:null,
	            data:{},
	            callback:null,
	            beforeSend:function(xhr) {
	            	//xhr.setRequestHeader("Authorization", "Basic YXBwcHM6MTIz");
	            	xhr.setRequestHeader("Authorization", "Basic YWZpbGlhLXNlcnZpY2VzOjRmMWwxNHMzcnYxYzNzUFM=");
	            	//xhr.setRequestHeader("Authorization", "Basic YWZpbGlhLXNlcnZpY2VzOjRmMWwxNHMzcnYxYzNzUFM=");
	            }
	        };
	    var options = $.extend(defaults, params);

	    if (options.url === null || $.trim(options.url) === ""){	return null;	}
	    else {
			var data = options.data;
	      	var type = "POST";
	      	//var url = "http://192.168.1.234:7171/afiliapsQA/service/paqueteria/"+options.url;
		    var url = "http://odc.portalweb.priceshoes.com/fsw/afilia-services/service/paqueteria/"+options.url;
		    //var url = "http://192.168.1.235:7373/afilia-services/service/paqueteria/"+options.url;
	      	var dataType = "JSON";
	      
	      	return $.ajax ({
                url:url,
                beforeSend:options.beforeSend,
                type:type,
                data:JSON.stringify(data),
                dataType:dataType,
                contentType:"application/json",cache:false
            }) .done(function(response) {   
              { 
                  if (options.callback != null) {options.callback(response);} 
              }
	      }).fail(function(jqXHR, textStatus) {
              psDialog.error("Servicio no disponible "+ textStatus);
          });
	    }
	  };*/
	  
		function loadData() {
			var loading = psDialog.loading();
			loading.open();
			//paqueteria.service ({
				//url:"cobertura",
			system.service ({
				url:"getCobertura",
				data:{codigoPostal:$dato},
				callback:function(response) {
					var data=response;
					var existePaqeteria = false;
					
					$.each( data, function(i,paq) {
						try {
							if ( paq.aplicaServicio==1 ) existePaqeteria=true;
						} catch (e) { }
					});
					
					if ( !existePaqeteria ) {
						psDialog.error("No existe cobertura de ninguna paquetería, no se puede afiliar este cliente");
						loading.close();
						ecommerce.getDialog().close();
						return false;
					}
					$tablePaqueteria.bootstrapTable('load',data);
				},onError: function(){
					psDialog.error("No se pudo obtener la cobertura de ninguna paquetería");
					loading.close();
					ecommerce.getDialog().close();
					return false;
				}
			}).always(function(){ loading.close();	}); 
		}
		
		this.validaPaqueteria = function() {
			$("#spanPaqErr").val("");
			var obj = {valido:true};
			var radioValue = $("input[name='cvePaqueteria']:checked"). val();
			
			if ( radioValue == undefined || radioValue == 5 ||radioValue == 13) {
				obj.valido = false; 
				$("#spanPaqErr").html("Por favor seleccione una paquetería");
			} else {
				var row = $tablePaqueteria.bootstrapTable('getRowByUniqueId',radioValue);
				obj.paqueteria = row.cvePaqueteria;
				obj.gastosEnvio = row.gastosEnvio;
				obj.pctSeguroMensajeria = row.pctSeguroMensajeria;
			}
			return obj;
		};
	
	function createTablePaqueteria() {
		if(!psPermiso.eval("UPDATE")){$("#thEditRegistro").remove();	}	
		if(!psPermiso.eval("DELETE")){$("#thEliminarRegistro").remove();}
		
		$tablePaqueteria.bootstrapTable ({
		     onClickRow:function (row, $element, field) {
		    	 $tablePaqueteria.find('.success').removeClass('success');
		    	 $element.addClass("success");
		     }
		});
		
		if (psPermiso.eval("CREATE")) {
			var id = null;
			var icon='<i class="fa fa-plus"></i>';
			var onclick = ' onclick="paqueteria.editRowTipo('+id+')" '; 
			var title = ' title="Nuevo tipo de ticket" ';
			var btn='<button '+onclick+title+' class="btn btn-default">'+icon+'</button>';
			$("#toolbarPaqueteris").prepend(btn);
		}
	}
	
	this.servicioFormatter = function(value,row) {
		if (value == null) {
			return '<div id= "servicioFormatter'+row.cvePaqueteria+'"> <i class=""('+row.cvePaqueteria+')" > </i></div>';
		}
		if(value =='0') {
			return '<div style="text-align: center" id= "servicioFormatter'+row.cvePaqueteria+'"> <i class="fa fa-times fa-lg ps-color-red" title="No" style="cursor:pointer;"('+row.cvePaqueteria+')" > </i></div>';
		} else {
			return '<div style="text-align: center" id= "servicioFormatter'+row.cvePaqueteria+'"> <i class="fa fa-check fa-lg ps-color-green" title="Si" style="cursor:pointer;"('+row.cvePaqueteria+')" > </i></div>';
		}
	}
	
	this.domicilioFormatter = function(value,row) {
		if (value == null){
			return '<div id= "domicilioFormatter'+row.cvePaqueteria+'"> <i class=""('+row.cvePaqueteria+')" > </i></div>';
		}
		if(value =='0'){
			return '<div style="text-align: center" id= "domicilioFormatter'+row.cvePaqueteria+'"> <i class="fa fa-times fa-lg ps-color-red" title="No" style="cursor:pointer;"('+row.cvePaqueteria+')" > </i></div>';
		} else {
			return '<div style="text-align: center" id= "domicilioFormatter'+row.cvePaqueteria+'"> <i class="fa fa-check fa-lg ps-color-green" title="Si" style="cursor:pointer;"('+row.cvePaqueteria+')" > </i></div>';
		}
	}
	
	this.oficinasFormatter = function(value,row) {
		if (value == null) {
			return '<div id= "oficinasFormatter'+row.cvePaqueteria+'"> <i class=""('+row.cvePaqueteria+')" > </i></div>';
		}
		if(value =='0') {
			return '<div style="text-align: center" id= "oficinasFormatter'+row.cvePaqueteria+'"> <i class="fa fa-times fa-lg ps-color-red" title="No" style="cursor:pointer;"('+row.cvePaqueteria+')" > </i></div>';
		} else {
			return '<div style="text-align: center" id= "oficinasFormatter'+row.cvePaqueteria+'"> <i class="fa fa-check fa-lg ps-color-green" title="Si" style="cursor:pointer;"('+row.cvePaqueteria+')" > </i></div>';
		}
	}
	
	this.entregaFormatter = function(value,row) {
		if (value == null){
			return '<div id= "entregaFormatter'+row.cvePaqueteria+'"> <i class=""('+row.cvePaqueteria+')" > </i></div>';
		}
		if(value =='L-M-M-J-V-S'){
			return '<div style="text-align: center" class= "bg-success" style="text-align: center" id="entregaFormatter'+row.cvePaqueteria+'">'+value+'</div>';
		} else {
			return '<div style="text-align: center" class= "bg-success" style="text-align: center" id="entregaFormatter'+row.cvePaqueteria+'">'+value+'</div>';
		}
	}

	this.init = function() {		
		createTablePaqueteria();
		loadData();
	};
	
}).apply(paqueteria);

$(document).ready(function() {
	try {
		paqueteria.init();
	} catch (e) {
		console.log(e)
	}
});
</script>

<div id="divPaqueterias">
	<div class="panel panel-blue padding-0" style="border: none;">
		<div class="panel-body padding-0">
			<table id="tablePaqueteria" data-show-columns="false"
				data-show-toggle="false" data-search="false"
				data-icons="system.icons" data-toolbar-name="toolbarPaqueteria"
				data-striped="true" data-page-size="5" data-page-list="[5,10,15,20]"
				data-unique-id="cvePaqueteria" data-id-field="cvePaqueteria"
				data-select-item-name="cvePaqueteria">
				<thead>
					<tr>

						<th data-radio="true" data-switchable="false" data-visible="true"
							data-align="center" data-width="75">Check</th>

						<th data-field="cvePaqueteria"
							data-formatter="system.nameFormatter" data-switchable="false"
							data-visible="false" data-align="center" data-width="75">idPaq</th>

						<th data-field="paqueteria" data-switchable="false"
							data-visible="true" data-align="center" data-width="75">Paqueteria</th>

						<th data-field="aplicaServicio"
							data-formatter="paqueteria.servicioFormatter"
							data-sortable="true" data-visible="true" data-align="left">Servicio</th>

						<th data-field="servicioDomicilio"
							data-formatter="paqueteria.domicilioFormatter"
							data-visible="true" data-align="left">Domicilio</th>

						<th data-field="servicioOficina"
							data-formatter="paqueteria.oficinasFormatter" data-visible="true"
							data-align="left">Oficinas</th>

						<th data-field="frecuencia" data-formatter="system.nameFormatter"
							data-visible="true" data-align="left">Frecuencia</th>

						<th data-field="diasEntrega"
							data-formatter="paqueteria.entregaFormatter" data-visible="true"
							data-align="left">Entrega</th>

						<th data-field="gastosEnvio"
							data-formatter="system.moneyFormatter" data-visible="true"
							data-align="left">Gastos</th>

						<th data-field="pctSeguroMensajeria" data-visible="true"
							data-align="left">Seguro</th>
					</tr>
				</thead>
			</table>
		</div>
		<label class="ps-color-red" id="spanPaqErr"></label>
	</div>

</div>