var ecommerce = {};

(function()
{
	var $e = ecommerce;
	this.preregistro = null;
	var $dialogGlobal = null;

	this.getDialog=function(){ return $dialogGlobal; };

	this.rsGetEstado= [
		{"edCveN":1,"edoDescStr":"Aguascalientes"},
		{"edCveN":2,"edoDescStr":"Baja California"},
		{"edCveN":3,"edoDescStr":"Baja California Sur"},
		{"edCveN":4,"edoDescStr":"Campeche"},
		{"edCveN":7,"edoDescStr":"Chiapas"},
		{"edCveN":8,"edoDescStr":"Chihuahua"},
		{"edCveN":9,"edoDescStr":"Ciudad De Mexico"},
		{"edCveN":5,"edoDescStr":"Coahuila"},
		{"edCveN":6,"edoDescStr":"Colima"},
		{"edCveN":10,"edoDescStr":"Durango"},
		{"edCveN":15,"edoDescStr":"Edo. De Mexico"},
		{"edCveN":11,"edoDescStr":"Guanajuato"},
		{"edCveN":12,"edoDescStr":"Guerrero"},
		{"edCveN":13,"edoDescStr":"Hidalgo"},
		{"edCveN":14,"edoDescStr":"Jalisco"},
		{"edCveN":16,"edoDescStr":"Michoacan"},
		{"edCveN":17,"edoDescStr":"Morelos"},
		{"edCveN":18,"edoDescStr":"Nayarit"},
		{"edCveN":19,"edoDescStr":"Nuevo Leon"},
		{"edCveN":20,"edoDescStr":"Oaxaca"},
		{"edCveN":21,"edoDescStr":"Puebla"},
		{"edCveN":22,"edoDescStr":"Queretaro"},
		{"edCveN":23,"edoDescStr":"Quintana Roo"},
		{"edCveN":24,"edoDescStr":"San Luis Potosi"},
		{"edCveN":25,"edoDescStr":"Sinaloa"},
		{"edCveN":26,"edoDescStr":"Sonora"},
		{"edCveN":27,"edoDescStr":"Tabasco"},
		{"edCveN":28,"edoDescStr":"Tamaulipas"},
		{"edCveN":29,"edoDescStr":"Tlaxcala"},
		{"edCveN":30,"edoDescStr":"Veracruz"},
		{"edCveN":31,"edoDescStr":"Yucatan"},
		{"edCveN":32,"edoDescStr":"Zacatecas"}
		];

	var indice=1;
	var afiliaBitacora={};
	var estados = {};
	var objectForm = {};
	var paquetes = {};
	var catalogos = {};
	this.srcImgTemp = null;

	var objectAfiliacion={ socio:{ },articulos:{ },formaPago:{ } , paqueteria:{}};
	//BOTONES
	function otroDomicilio() {
		$("#mismoDom").on('change', function() {
		    var selectValue = $(this).val();
		    switch (selectValue) {
		     case "1":
		    	  $('#domEnvio').hide();
		    	  $('#referenciasO').hide();
		    	  $('#entreCallesO').hide();
		    	  $('#referencias').show();
		    	  $('#entreCalles').show();
			    break;

		      case "2":
		    	  $('#domEnvio').show();
		    	  $('#referenciasO').show();
		    	  $('#entreCallesO').show();
			    break;
		    }
		  }).change();
	};


	function addOnClickBtnPagar() {
		$('#btnPagar').click(function(v) {
			v.preventDefault();
			v.stopPropagation();
			var total=objectAfiliacion.articulos.total;
			var gastosEnv = objectAfiliacion.paqueteria.gastosEnvio;
			var propSegMens = parseFloat(objectAfiliacion.paqueteria.pctSeguroMensajeria);
			var segMens =Math.ceil(parseFloat(total)*(propSegMens/100));

			var totalPagar=totalPagar = parseFloat(total) + parseFloat(gastosEnv) + parseFloat(segMens);

			var artAux = [];
			artAux.push( {id:'AFI', desc:'Afiliacion Price Shoes', cant: 1,  precUnit: total } );

			if(gastosEnv > 0 )
				artAux.push(  {id:'GEN', desc:'Gastos de envio', cant: 1,  precUnit: gastosEnv } );

			if(segMens > 0)
					artAux.push( {id:'SEG', desc:'Seguro de mensajeria', cant: 1,  precUnit: segMens } );

			var carrito   = {
			  formaPago:  $("#formaPago").val(),
			  referencia: $("#referencia").val(),
			  plataforma:  1,
			  cliente: {email:$("#email").val(),},
			  articulos: artAux,
			  callback:function() {

				  //Ocultar landing, mostrar la tabla , refrescar dicha tabla loadData()
				  $("#tableLanding").show();
				  $("#panel-body").show();
				  $("#tabTipo").show();
				  $("#divLanding").show();
				  //landing.loadData();
				  $('#divFormAfilia').html("");
				  $("#btnMostrar").show();
				  $("#divFormAfilia").hide();
			  }
			};
			mercadoPagoPS.generarBtnPago(carrito);
		});
	}

	function addOnClickBtnFinalizarProceso() {
		$('#btnFinalizarProceso').click(function(e) {
			e.preventDefault();
			e.stopPropagation();
			/*var loading = psDialog.loading().open();
			system.getForm ({
				url: "template/lista",
				data: { response: {} }
			}).done(function(form) {
				$("#divTemplateContainer").html(form);
			}).always(function() {
 				loading.close();
			});*/
			this.regresarLista();
		});
	}

	function addOnClickBtnValidar() {
		$('#btnValidar').click(function() {
			var obj = validarFormulario();
			if ( obj.valido ) {
				var loading = psDialog.loading().open();
				system.service ({
					url:"verificaCorreo",
					data:{ correoVal:  $("#email").val().trim() },
					callback:function(response) {
						rfc.createRfc(function(resp,loading) {
							loading.close();
							if (resp.existe && $("#rfcPrice").val() != resp.rfcPrice)
								psDialog.error("Se ha generado un RFCPrice con la información introducida "+ 
								"y existe un registro con el mismo RFCPrice. Revise por favor");	
							else {
								$('#btnBackProcesar').hide();
								avanzarFormulario(obj);
							}					
						});
					}
				}).always(function(){ loading.close(); });
			} else 
				$('#btnValidar').show();
		});
	}

	function avanzarFormulario(obj) {
		objectAfiliacion.socio = obj;
		correoVal:obj.email;

		$('#btnPaquetes').show();
		$('#divCatalogos').show();
		$('#btnRegresarDatos').show();
		//read only a los campos para no editar y esconder los div
		$('#divPrimerosDatos').hide();
		$('#divDocumentacion').hide();
		$('#divTercerBloque').hide();
		$('#divCuertoBloque').hide();
		$('#btnMostrar').hide();

		$("#nombre").attr("readonly","readonly");
		$("#paterno").attr("readonly","readonly");
		$("#materno").attr("readonly","readonly");
		$("#genero").attr("readonly","readonly");
		$("#email").attr("readonly","readonly");
		$("#selectTiendas").attr("readonly","readonly");
		$("#celular").attr("readonly","readonly");
		$("#nacimiento").attr("readonly","readonly");
		//direcion
		$("#calle").attr("readonly","readonly");
		$("#numeroExt").attr("readonly","readonly");
		$("#numeroInt").attr("readonly","readonly");
		$("#colonia").attr("readonly","readonly");
		//mismo domicilio
		$("#referencias").attr("readonly","readonly");
		$("#entreCalles").attr("readonly","readonly");
		$("#mismoDom").attr("readonly","readonly");
		//regresar los campos a editar y aparecer bloques
		$('#btnValidar').hide();
		 $('html,body').animate({ scrollTop: $("#divCatalogos").offset().top},'slow');
	}

	function onclickBtnRegresarDatos() {
		$('#btnRegresarDatos').click(function() {
			$('#btnRegresarDatos').hide();
			$('#divPrimerosDatos').show();
			$('#divDocumentacion').show();
			$('#divTercerBloque').show();
			$('#divCuertoBloque').show();
			$('#btnMostrar').show();
			//remover readOnlu
			$("#nombre").removeAttr("readonly");
			$("#paterno").removeAttr("readonly");
			$("#materno").removeAttr("readonly");
			$("#genero").removeAttr("readonly");
			$("#email").removeAttr("readonly");
			$("#selectTiendas").removeAttr("readonly");
			$("#celular").removeAttr("readonly");
			$("#nacimiento").removeAttr("readonly");

			//direcion
			$("#calle").removeAttr("readonly");
			$("#numeroExt").removeAttr("readonly");
			$("#numeroInt").removeAttr("readonly");
			$("#colonia").removeAttr("readonly");

			//mismo domicilio
			$("#referencias").removeAttr("readonly");
			$("#entreCalles").removeAttr("readonly");
			$("#mismoDom").removeAttr("readonly");

			$('#btnValidar').show();
			$('#btnPaquetes').hide();
			$('#divCatalogos').hide();
		});
	}

	function onclickBtnPasoTres() {
		$('#btnPaquetes').click(function(){
			$('#btnPaquetes').hide();
			$('#btnValidar').hide();
			$('#btnRegresarDatos').hide();
			$('#btnRegresar').show();
			$('#btnSiguiente').show();
			$('#divCatalogos').hide();
			$('#btnMostrar').hide();

			pasoTres();
			$('html,body').animate({ scrollTop: $("#divConfirmaEnvia").offset().top},'slow');
		});
	}

	function onclickBtnRegresar() {
		$('#btnRegresar').click(function() {
			$('#btnPaquetes').show();
			$('#btnRegresar').hide();
			$('#btnSiguiente').hide();
			$('#btnGuardar').hide();
			$('#divConfirmaEnvia').hide();
			$('#divCatalogos').show();
			$('#btnMostrar').show();
			$('html,body').animate({ scrollTop: $("#divCatalogos").offset().top},'slow');
		});
	}

	function onclickBtnSiguiente() {
		$('#btnSiguiente').click(function() {
			$('#btnGuardar').prop('disabled', true); // Bloqueo de boton			
			$('#btnRegresar').hide();
			$('#btnSiguiente').hide();
			$('#btnRegresarDatos').hide();
			$('#btnValidar').hide();
			$('#btnGuardar').show();
			$('#divBtnGuardar').show();
			$('#btnMostrar').hide();
			$('#divFormasPago').show();
			$('#divFormasPagoImg').show();
			$('#divFormasPagoReferencia').show();
			$('#btnFormasPagoReferencia').show();
			var checked = $("#idMemDigital").prop("checked");
			if( checked ) {
				//si es por paquete
				if(objectAfiliacion.articulos.tipo==1) {
					objectAfiliacion.articulos.data.push(872823);
				} else {
					//si es por catalogos
					objectAfiliacion.articulos.data.push({id:872823,precio:0});
					console.log( JSON.stringify(objectAfiliacion) );
				}
			}

			$('html,body').animate({ scrollTop: $("#divFormasPagoReferencia").offset().top},'slow');

			$.when( getReferencia()  )
			.then(function(result) {
				if( result.referencia == undefined  ) {
					//Control de errores
					psDialog.warning("Error en el proceso. No se pudo obtener la referencia.")
					return false;
				}
				//Pedido magento
				var ref = result.referencia;
				$("#referencia").val(ref);
				$('#btnGuardar').prop('disabled', false); // Desbloqueo de boton
			});
		});
	}

	function onclickBtnCancelar() {
		$('#btnFormCancelar').click(function() {
			system.getForm ({
				url:"ecommerce/ecomCanForm",
				data:{},
			}).done(function(form) {
				var dialog = psDialog.dialog({size : "normal",title: "Cancelar",message: form,btnOKLabel:'Guardar',btnOK:"btnSaveCan",}).open();
				dialog.getButton("btnSaveCan").click(function() {
					onclickBtnSaveEcommCan();
					dialog.close();
					 $("#tableLanding").show();
					  $("#panel-body").show();
					  $("#tabTipo").show();
					  $("#divLanding").show();
					  landing.loadData();
					  $('#divFormAfilia').html("");
					  $("#btnMostrar").show();
					  $("#divFormAfilia").hide();
				});
			});
		});

	}

	function onclickBtnPaqueteria(cp) {
		system.getForm ({
			url:"template/paqueteria",
			data:{ dato:cp },
		}).done(function(form) {
			$dialogGlobal = psDialog.dialog ({
				size : "wide",
				title: "Paqueterias para envío",
				message: form,btnOKLabel:'Seleccionar',
				btnOK:"btnSavePaq",
				showBtnCancel:false
			}).open();
			$dialogGlobal.getButton("btnSavePaq").click(function() {
				var paq = paqueteria.validaPaqueteria();
				if ( paq.valido ) {
					$dialogGlobal.close();
					objectAfiliacion.paqueteria=paq;
				}
			});
		});
	}
	// VALIDAR FORMULARIO
	function cleanErrors(form) {
		form.find(".has-error").removeClass("has-error");
		form.find(".ps-span-error").html("");
	}
	function markAsError(obj,mensaje) {
		var msg = mensaje!=null ? mensaje :"requerido";
		obj.parent().addClass("has-error");
		obj.parent().parent().find('.ps-span-error').html("<br class='hidden-xs'> "+msg );
	}

	function validarFormulario() {
		var first = null;
		var obj = new Object();
		cleanErrors($('#formEcommerceAfilia'));

		$.each($("#formEcommerceAfilia").serializeArray(),function(index,element) {
			obj[element.name]= ( $.trim(element.value)==""?null: $.trim(element.value)) ;
		});

		obj.valido=true;
		//console.log(obj);
		if( obj.idsocio == null) {
			obj.valido=false;
			markAsError( $("#idsocio"));
		}
		if( obj.celular == null) {
			obj.valido=false;
			markAsError( $("#celular"));
		}
		if( obj.nombre == null) {
			obj.valido=false;
			markAsError( $("#nombre"));
		}

		if( obj.paterno == null) {
			obj.valido=false;
			markAsError( $("#paterno"));
		}

		if( obj.materno == null) {
			obj.valido=false;
			markAsError( $("#materno"));
		}
		if( obj.email == null) {
			obj.valido=false;
			markAsError($("#email"));
		} else {
			if ( !system.correoValido(obj.email) ) {
				obj.valido=false;
				markAsError($("#email")," (Correo no válido)");
			} else {
				obj.email = obj.email.toLowerCase();
			}
		}
		if( obj.nacimiento == null) {
			obj.valido=false;
			markAsError( $("#nacimiento"));
		}
		if( obj.calle == null) {
			obj.valido=false;
			markAsError( $("#calle"));
		}
		if( obj.numeroExt == null) {
			obj.valido=false;
			markAsError( $("#numeroExt"));
		}

		if( obj.colonia == null) {
			obj.valido=false;
			markAsError( $("#colonia"));
		} else {
			obj.coloniaText = $("#colonia option:selected").text();
			obj.muncven = $("#colonia option:selected").data("mucven");
			obj.edcven = $("#colonia option:selected").data("edcven");
		}
		if( obj.cp == null) {
			obj.valido=false;
			markAsError( $("#cp"));
		}
		if( obj.municipio == null) {
			obj.valido=false;
			markAsError( $("#municipio"));
		}
		if( obj.estado == null) {
			obj.valido=false;
			markAsError( $("#estado"));
		}
		if ($('#genero option:selected').val() === "-1") {
			obj.valido=false;
			markAsError( $("#genero"));
		}
		switch($('#mismoDom option:selected').val()) {
			case "-1":
				obj.valido=false;
				markAsError( $("#mismoDom"));
			break;
			case "1":
				if( obj.referencias == null) {
					obj.valido=false;
					markAsError( $("#referencias"));
				}
				if( obj.entreCalles == null) {
					obj.valido=false;
					markAsError( $("#entreCalles"));
				}
			break;
			case "2":
				if( obj.calleO == null) {
					obj.valido=false;
					markAsError( $("#calleO"));
				}
				if( obj.numeroExtO == null) {
					obj.valido=false;
					markAsError( $("#numeroExtO"));
				}
				if( obj.coloniaO == null) {
					obj.valido=false;
					markAsError( $("#coloniaO"));
				} else {
					obj.coloniaTextO = $("#colonia option:selected").text();
					obj.muncvenO = $("#colonia option:selected").data("mucven");
					obj.edcvenO = $("#colonia option:selected").data("edcven");
				}
				if( obj.cpO == null) {
					obj.valido=false;
					markAsError( $("#cpO"));
				}
				if( obj.municipioO == null) {
					obj.valido=false;
					markAsError( $("#municipioO"));
				}
				if( obj.estadoO == null) {
					obj.valido=false;
					markAsError( $("#estadoO"));
				}
			break;
		}
		return obj;
	}

	function validarFormaPago() {
		var obj={valido:true};

		obj.formaPago= $("#formaPago").val();
		obj.referencia= $("#referencia").val();

		if(obj.formaPago==null) {
			obj.valido = false;
			psDialog.warning("Por favor seleccione la forma de pago");
		}
		return obj;
	}
	
	function generarRequestYEnviar() {
		var $o = objectAfiliacion;
		var $r = { cliente:{},pedido:{} };

		$r.origen 					= '1';
		$r.cliente.socioId 			= $o.socio.idsocio;
		$r.cliente.nombre 			= $o.socio.nombre;
		$r.cliente.apellidoPaterno 	= $o.socio.paterno;
		$r.cliente.apellidoMaterno 	= $o.socio.materno;
		$r.cliente.sexo 			= $o.socio.genero;
		$r.cliente.email 			= $o.socio.email;
		$r.cliente.fechaNacimiento  = $o.socio.nacimiento;
		$r.cliente.telefono  		= $o.socio.celular;
		$r.cliente.tiCveN  			= $o.socio.selectTiendas;

		$r.cliente.direcciones=[];

		var dir1 = {
			envio: ( $o.socio.mismoDom == 1 ? true : false ),
			calle: $o.socio.calle,
			noExterior: $o.socio.numeroExt,
			noInterior: $o.socio.numeroInt,
			colonia: $o.socio.coloniaText,
			cp: $o.socio.cp,
			municipio: $o.socio.muncven,
			municipioDesc:  $o.socio.municipio,
			estado: $o.socio.edcven,
			estadoDesc: $o.socio.estado,
			ciudad: $o.socio.ciudad,
			referencia: $o.socio.referencias,
			entreCalles: $o.socio.entreCalles,

		};
		$r.cliente.direcciones.push(dir1);

		if( $o.socio.mismoDom == 2 ) {
			var dir2 = {
				envio: ( $o.socio.mismoDom == 2 ? true : false ),
				calle: $o.socio.calleO,
				noExterior: $o.socio.numeroExtO,
				noInterior: $o.socio.numeroIntO,
				colonia: $o.socio.coloniaTextO,
				cp: $o.socio.cpO,
				municipio: $o.socio.muncvenO,
				municipioDesc:  $o.socio.municipioO,
				estado: $o.socio.edcvenO,
				estadoDesc: $o.socio.estado,
				ciudad: $o.socio.ciudadO,
				referencia: $o.socio.referenciasO,
				entreCalles: $o.socio.entreCallesO,
			};
			$r.cliente.direcciones.push(dir2);
		}

		//PEDIDO
		$r.pedido.subTotal =$o.articulos.total;
		$r.pedido.gastosEnvio = ($o.paqueteria.gastosEnvio*1);
		$r.pedido.seguroMensajeria =Math.ceil($o.articulos.total*($o.paqueteria.pctSeguroMensajeria/100));
		$r.pedido.importeTotal =$o.articulos.total + $r.pedido.seguroMensajeria + $r.pedido.gastosEnvio;
		$r.pedido.descuentoPedido='0';
		console.log("****pedido****");
		$r.pedido.paqueteria=$o.paqueteria.paqueteria;
		$r.pedido.articulos = [];
		$r.pedido.seq= $o.articulos.seq;
		//pedido
		if( $o.articulos.tipo == 1 ) {//Paquete 
			console.log(" dev-fsw es paquete");
			var articulo = {
				cantidad: 1,
				idArt: 	  $o.articulos.data[0],
				talla:    48.0,
				seq:	  $o.articulos.seq,
				precio:   $o.articulos.total
			};
			//membresia digital
			if(articulo.idArt ==971394) {//971394
				console.log(" dev-fsw es idart 971394")
				$r.pedido.subTotal =$o.articulos.total;
				$r.pedido.gastosEnvio = 0;
				$r.pedido.seguroMensajeria = 0;
				$r.pedido.importeTotal =$o.articulos.total;
				$o.paqueteria.gastosEnvio = 0;
			} else {
				$r.pedido.subTotal =$o.articulos.total;
				$r.pedido.gastosEnvio = ($o.paqueteria.gastosEnvio*1);
				$r.pedido.seguroMensajeria =Math.ceil($o.articulos.total*($o.paqueteria.pctSeguroMensajeria/100));
				$r.pedido.importeTotal =$o.articulos.total + $r.pedido.seguroMensajeria + $r.pedido.gastosEnvio;
			}
			$r.pedido.articulos.push(articulo);
			if ( $o.articulos.data.length > 1 ) {
				$r.pedido.articulos.push({ 
					cantidad:1,
					idArt:$o.articulos.data[1],
					talla:48.0,
					precio:0 });
			}
		} else if( $o.articulos.tipo == 2 ) {// Catalogos
			$.each($o.articulos.data,function(i,obj) {
				var articulo = {
					cantidad: 1,
					idArt:    obj.id,
					talla:	  48.0,
					precio:   obj.precio,
				};

				$r.pedido.articulos.push(articulo);
			});
		}
		$r.pedido.tipoVenta = $o.articulos.tipo;
		if($('#formaPago').val()==='19') {
			$r.pedido.formaPago = {
				formaPago: $o.formaPago.formaPago,
				metodoPago: '2',
				cantidad: 1,
				referencia: $o.formaPago.referencia,

		    };
		} else {
			$r.pedido.formaPago = {
				formaPago: $o.formaPago.formaPago,
				metodoPago: '1',
				cantidad: 1,
				referencia: $o.formaPago.referencia,
		    };
		}

		$r.pedido.idPedido = $o.formaPago.referencia;
		$r.cliente.tiCveN = 29;
		console.log("$r: "+JSON.stringify($r));

		saveBitacoraEcommerce($r, { numPedido: '0', numSocio: $r.cliente.socioId, guiaEnvio: '0' });
		var loading = psDialog.loading().open();
		system.service ({
			url:"crearPedido",	data:$r,
			callback:function(response) {
				console.log( JSON.stringify(response));
				//TODO 	@PENDIENTE Validar estatus
				if(response.socioId && response.idPedidoPs) {
					$("#soIdStr").val(response.socioId);
					rfc.updateSocio();
					saveBitacoraEcommerce( $r, response );
				} else {
					psDialog.error(response.descripcionError);
					$("#divTiposPago").hide();
					$("#divReferencia").hide();
					$("#divBtnGuardar").hide();
					$("#divBtnTerminarAfiliacion").hide();
				}
			}
		}).always(function(){ loading.close();});
	}

	function onclickBtnSaveEcomm() {
		$('#btnGuardar').click(function(ev) {
			ev.preventDefault();
			ev.stopPropagation();
			system.blockButton( $('#btnGuardar') );

			var obj = validarFormaPago();

			if ( obj.valido ) {
				$('#divFormasPago').show();
				$('#divFormasPagoImg').show();
				$('#btnGuardar').show();
				$('#btnMostrar').hide();
				objectAfiliacion.formaPago = obj;
				generarRequestYEnviar();
			}
		});
	}

	function onclickBtnSaveEcommCan() {
			var obj=new Object();
			$.each($("#formEcommerceAfilia").serializeArray(),function(index,element) {
				obj[element.name]= ( $.trim(element.value)==""?null: $.trim(element.value)) ;
			});
			obj.formaPago= $("#formaPago").val();
			obj.referencia= $("#referencia").val();
			console.log(obj);
			var $r = { cliente:{},pedido:{} };

			$r.cliente.nombre 			= obj.nombre || '';
			$r.cliente.apellidoPaterno 	= obj.paterno  || '';
			$r.cliente.apellidoMaterno 	= obj.materno  || '';
			$r.cliente.sexo 			= obj.genero  || '';
			$r.cliente.email 			= obj.email  || '';
			$r.cliente.fechaNacimiento  = obj.nacimiento  || '';
			$r.cliente.telefono  		= obj.celular  || 0;
			$r.pedido.formaPago			= {};
			$r.pedido.formaPago.referencia=0;
			$r.pedido.formaPago.formaPago='';
			$r.pedido.articulos			= [];
			$r.cliente.direcciones = [];
			$r.bcsCveN = $("#bcsCveN").val();
			$r.abeCandescStr = $("#abeCandescStr").val();
			saveBitacoraEcommerce($r, {idPedidoPs:'0',socioId:'0',guiaPedido:'0'

			});
	}

	function saveBitacoraEcommerce( $r, response ) {
	  try {
		var dir2 = '';
		var nombre = $r.cliente.nombre+" "+$r.cliente.apellidoPaterno+" "+$r.cliente.apellidoMaterno;
		var ref =   $r.pedido.formaPago.referencia;
		var fpago = $r.pedido.formaPago.formaPago;
		var metodoPago =$r.pedido.formaPago.metodoPago;
		var articulos = [];

		$.each($r.pedido.articulos,function(i,obj) {
			articulos.push(obj.idArt);
		});

		if( $r.cliente.direcciones.length==2 ) {
			var d = $r.cliente.direcciones[1];
			dir2 = d.calle+" "+d.noExterior+" "+d.colonia+" "+d.cp+" "+d.municipio+" "+d.estado+" "+d.ciudad;
		}

		var bitRequest = {
			abeOrigenN:			$r.origen,
			abeCveN:    		($e.preregistro!=null ? $e.preregistro.seq : null),
			abePedidoN: 		response.idPedidoPs,
			abeSoIdStr:			response.socioId,
			abeGuiaN:			response.guiaPedido,
			abeDepBanStr:		response.refDepositoBancario,
			abdCveN:			response.idBitacora,
			idUsrN: 			system.user.idUsrN,
			idPerfN:			system.user.profile.idPerfN,
			abeNombreStr: 		nombre ,
			abeTelefonoN: 		$.trim( $r.cliente.telefono ),
			abeFormPagoStr:		fpago,
			metodoPago:			metodoPago,
			bcsCveN:			$r.bcsCveN,
			abeCandescStr:		$r.abeCandescStr,
			abePaqueteriaStr:	objectAfiliacion.paqueteria.cvePaqueteria
		};

		console.log("***" + JSON.stringify(bitRequest));
		//var url = ($r.bcsCveN)?'saveOrUpdateCancelacionBitacoraEcommerce':'saveOrUpdateAfiliaBitacoraEcommerce';
		var url = 'saveOrUpdateAfiliaBitacoraEcommerce';

		return system.service ({
			url:url,
			data:{ afiliaBitacoraEcommerce:bitRequest},
			callback:function(respuesta) {
				if (bitRequest.abdCveN > 0) {
					if($('#formaPago').val()==='19') {
						$('#depositoBancario').show();
						$('#tabladepositoBancario').show();
						$("#abeDepBanStr").val( response.refDepositoBancario );
						$("#tdTotalTransfer").html("$"+$r.pedido.importeTotal);
						$('#btnGuardar').hide();
						$('#divBtnGuardar').hide();
						$('#divTiposPago').hide();
						$('#formaPago').hide();
						$('#divReferencia').hide();
						$('#referencia').hide();
						$('#btnMostrar').hide();
						$('#divBtnTerminarAfiliacion').show();
						$('#btnFinalizarProceso').show();
						psDialog.info("Proceso de afiliación concluido satisfactoriamente por transferencia bancaria");
					} else {
						$('#btnGuardar').hide();
						$('#divBtnGuardar').hide();
						$('#divBtnPagar').show();
						$('#btnPagar').show();
						$('#btnMostrar').hide();
						if ($("#bcsCveN").val()) {
							psDialog.warning("Proceso de afiliación cancelado");
						} else {
							psDialog.info("Proceso de afiliación concluido satisfactoriamente, favor de generar pago");
						}
					}
				}
			}
		});
	  } catch(e) { console.log(e); }
	}

	//BUSCAR COLONIA - CODIGO POSTAL

	function getEstados() {
		var options = '<option value=-1 selected="selected" disabled>-Selecciona una opción-</option>';
		$.each(ecommerce.rsGetEstado,function(i,obj) {
			estados[obj.edCveN] = obj;
			options+= '<option value='+obj.edCveN+'>'+obj.edoDescStr+'</option>';
		});
	}

	function addOnClickBtnBuscar() {
		$('#btnBuscar').click(function(e) {
			e.preventDefault();
			system.blockButton( $(this) );
			var cp= $.trim($('#cp').val());
			if(cp!= "" && !isNaN(cp) && cp.length == 5) {
				$("#estado").val("");
				$("#municipio").val("");

				$("#cp").prop("readonly",true);

				var loading = psDialog.loading().open();
				system.service ({
					url:'getColoniaCP',
					data: {
						afiliacion: {codPostStr: cp}
					},
					callback:function(response) {
						onclickBtnPaqueteria(cp);
						$('#colonia').off("change");
						var data = response.rsGetColoniaCP;
						var options='';

						options+= '<option value=-1 selected="selected" disabled>-Selecciona una colonia-</option>';
						$.each(data, function(index, colonia) {
							options+= '<option value='+colonia.id+
							' data-paCveN='+colonia.paCveN +
							' data-edCveN='+colonia.edCveN +
							' data-muCveN='+colonia.muCveN +
							' data-codPostStr='+colonia.codPostStr +
							' data-muDescStr="'+colonia.softMuDescStr+'" '+
							' data-cdDescStr="'+colonia.sepomexCdDescStr+'"	>'+colonia.colDescStr+'</option>';
						});
						$('#colonia').html(options);

						$('#colonia').on('change',function() {
							var opt = $('#colonia option:selected');
							var edCveN = opt.data('edcven');
							var edDescStr = estados[edCveN].edoDescStr;
							$("#estado").val(edDescStr);

							var municipio = opt.data('mudescstr');
							$("#municipio").val( municipio );

							var ciudad = opt.data('cddescstr');
							if( ciudad.length > 38 ) ciudad = ciudad.substring(0,38);
							$("#ciudad").val( ciudad );

							var codpoststr = opt.data('codpoststr');
							$("#cp").val( codpoststr );
						});
					}
				}).always(function() {	loading.close();	});

			} else {
				psDialog.warning("Ingrese un código postal válido (5 dígitos)");
			}
		});
	}

	function addOnClickBtnBuscarSegDireccion() {
		$('#btnBuscarO').click(function(e) {
			e.preventDefault();

			var cp= $.trim($('#cpO').val());
			if(cp!= "" && !isNaN(cp) && cp.length == 5) {
				$("#estadoO").val("");
				$("#municipioO").val("");

				$("#cpO").prop("readonly",true);

				var loading = psDialog.loading().open();
				system.service ({
					url:'getColoniaCP',
					data:{
						afiliacion: {codPostStr: cp}
					},
					callback:function(response) {
						onclickBtnPaqueteria(cp);
						$('#coloniaO').off("change");

						var data = response.rsGetColoniaCP;
						var options='';

						options+= '<option value=-1 selected="selected" disabled>-Selecciona una colonia-</option>';
						$.each(data, function(index, colonia){
							options+= '<option value='+colonia.id+
							' data-paCveN='+colonia.paCveN +
							' data-edCveN='+colonia.edCveN +
							' data-muCveN='+colonia.muCveN +
							' data-codPostStr='+colonia.codPostStr +
							' data-muDescStr="'+colonia.softMuDescStr+'" '+
							' data-cdDescStr="'+colonia.sepomexCdDescStr+'"	>'+colonia.colDescStr+'</option>';
						});
						$('#coloniaO').html(options);

						$('#coloniaO').on('change',function() {
							var opt = $('#coloniaO option:selected');
							var edCveN = opt.data('edcven');
							var edDescStr = estados[edCveN].edoDescStr;
							$("#estadoO").val(edDescStr);

							var municipio = opt.data('mudescstr');
							$("#municipioO").val( municipio );

							var ciudad = opt.data('cddescstr');
							if( ciudad.length > 38 ) ciudad = ciudad.substring(0,38);
							$("#ciudadO").val( ciudad );

							var codpoststr = opt.data('codpoststr');
							$("#cpO").val( codpoststr );
						});
					}
				}).always(function(){	loading.close();	});

			} else {
				psDialog.warning("Ingrese un código postal válido (5 dígitos)");
			}
		});
	}

	function onclickclearSoCpStr() {
		$("#estado").val("");
		$("#municipio").val("");
		$("#ciudad").val("");
		$('#colonia').html("");
		$("#cp").val("");
		$("#cp").prop("readonly",false);
	}

	function getPaquetes() {
		return system.service ({
			url:"getPaquetesLanding",
			data:{},
			callback:function(response) {
				$("#divPaquetesContainer").html("");
				var data = response.paquetes;
				var items = '';

				$.each(data,function(i,obj) {
					var id = obj.idArt;

					items+=' <div class="col-lg-4 col-md-6 col-sm-12 col-xs-12 padding-item"> ';
					items+=' <div class="card" id="cardPaquete-'+id+'" > ';
					items+=' <table style="width: 100%;"> ';
					items+=' <tr> ';
					items+=' <td style="width:70px; height:70px;"> ';
					items+=' <img alt="" src="http://static.priceshoes.com.mx/imgs/small/articulo/'+id+'.jpg" style="width: 70px; height: 55px; cursor:pointer;" ';
					items+=' onclick="ecommerce.showImg('+id+')"  onerror="ecommerce.showDefaultImage(this)" >';
					items+=' </td> ';
					items+=' <td style="padding-left:7px;" > ';
					items+=' <label for="checkPaquete-'+id+'" class="lbl-reciente-1">'+ obj.idArt+"<br>" + obj.arDescStr+'</label> ';
					items+=' </td> ';
					items+=' <td style="width:100px;" align="center"> ';
					items+=' <table> ';
					items+=' <tr><td> ';
					items+=' <div class="checkbox col-sm-12"> ';
					items+=' <label><input id="checkPaquete-'+id+'" type="checkbox"></label> ';
					items+=' </div> ';
					items+=' </td></tr> ';
					items+=' <tr><td class="precio-card"><label for="checkPaquete-'+id+'">'+system.moneyFormatter(obj.preMayN)+'</label></td></tr> ';
					items+=' </table> ';
					items+=' </td> ';
					items+=' </tr> ';
					items+=' </table> ';
					items+=' </div> ';
					items+=' </div> ';

					paquetes[id] = obj;
				});

				$("#divPaquetesContainer").html(items);

				$("input[id^='checkPaquete-']").click(function() {
					var $this = $(this);
					var id = $this.attr("id").split("-")[1];
					if( $this.prop("checked") ) {
						$("#cardPaquete-"+id).addClass("card-selected");

						$("input[id^='checkCatalogo-']").prop("checked",false);
						$("div[id^='cardCatalogo-']").removeClass("card-selected");

						$("input[id^='checkPaquete-']").each(function() {
							var $oThis = $(this);
							var oId = $oThis.attr("id").split("-")[1];
							if ( oId != id ) {
								$oThis.prop("checked",false);
								$("#cardPaquete-"+oId).removeClass("card-selected");
							}
						});
					} else {
						$("#cardPaquete-"+id).removeClass("card-selected");
					}
				});

			}
		});
	}

	this.showImg = function( idArt ) {
		try {
			var dialog = psDialog.dialog ({
				title:"Imagen",
				message:'<div class="div-img-big" align="center" > <img  class="img-big" src="http://static.priceshoes.com.mx/imgs/original/articulo/'+idArt+'.jpg" > </div>',
				showBtnOK:false
			}).open();
		}catch(e){}
	};
	
	this.showDefaultImage = function(obj) {
		//obj.src  = "http://static.priceshoes.com.mx/imgs/small/default.png";
		obj.src = system.currentApp.baseUrl+"app/img/default.png";
		obj.onerror=null;
	};

	function getCatalogos() {
		return system.service ({
			url:"getCatalogosActivosLanding",
			data:{},
			callback:function(response) {
				$("#divCatalogosContainer").html("");

				var data = response.catalogos;
				var items = '';

				$.each(data,function(i,obj) {
					var id = obj.idArt;
					var lblLanzamiento = obj.esLanzamientoN == 1 ? '<span class="lanzamiento">Nuevo<br></span>':'';
					items+=' <div class="col-lg-4 col-md-6 col-sm-12 col-xs-12 padding-item" > ';
					items+=' <div class="card" id="cardCatalogo-'+id+'" > ';
					items+=' <table style="width: 100%;"> ';
					items+=' <tr> ';
					items+=' <td style="width:70px; height:70px;"> ';
					items+=' <img alt="" src="http://static.priceshoes.com.mx/imgs/small/articulo/'+id+'.jpg" style="width: 70px; height: 55px; cursor:pointer;" ';
					items+=' onclick="ecommerce.showImg('+id+')"  onerror="ecommerce.showDefaultImage(this)" >';
					items+=' </td> ';
					items+=' <td style="padding-left:7px; "> ';
					items+=' <label for="checkCatalogo-'+id+'" class="lbl-reciente-1">'+lblLanzamiento+ obj.idArt+"<br>" + obj.caDescStr+'</label> ';
					items+=' </td> ';
					items+=' <td style="width:100px;" align="center"> ';
					items+=' <table> ';
					items+=' <tr><td> ';
					items+=' <div class="checkbox col-sm-12"> ';
					items+=' <label><input id="checkCatalogo-'+id+'" type="checkbox"></label> ';
					items+=' </div> ';
					items+=' </td></tr> ';
					items+=' <tr><td class="precio-card"><label for="checkCatalogo-'+id+'" >'+system.moneyFormatter(obj.preMayN)+'</label></td></tr> ';
					items+=' </table> ';
					items+=' </td> ';
					items+=' </tr> ';
					items+=' </table> ';
					items+=' </div> ';
					items+=' </div> ';

					catalogos[id] = obj;
				});

				$("#divCatalogosContainer").html(items);

				$("input[id^='checkCatalogo-']").click(function(){
					var $this = $(this);
					var id = $this.attr("id").split("-")[1];

					if( $this.prop("checked") ) {
						$("input[id^='checkPaquete-']").prop("checked",false);
						$("div[id^='cardPaquete-']").removeClass("card-selected");

						$("#cardCatalogo-"+id).addClass("card-selected");
					} else {
						$("#cardCatalogo-"+id).removeClass("card-selected");
					}
				});
			}
		});
	}

	function loadCatalogosPaquetes() {
		if( psPermiso.eval("AFILIA_PAQ") && psPermiso.eval("AFILIA_CAT") ) {
			var tabController ='  ';
			tabController +=' <ul class="nav nav-tabs"> ';
			tabController +=' <li id="liTabPaquetes" class="active"><a data-toggle="tab" href="#paquetes" style="outline: none;">Paquetes</a></li> ';
			tabController +=' <li id="liTabCatalogos"><a data-toggle="tab" href="#catalogos" style="outline: none;">Catálogos</a></li> ';
			tabController +=' </ul> ';

			$("#tabPaqCatContainer").html(tabController);

			var loading = psDialog.loading().open();
			$.when( getCatalogos(), getPaquetes() )
			.always(function() {	loading.close();	});
		}
		else if(  psPermiso.eval("AFILIA_PAQ") ) {
			$("#catalogos").remove();

			var tabController ='  ';
			tabController +=' <ul class="nav nav-tabs"> ';
			tabController +=' <li id="liTabPaquetes" class="active"><a data-toggle="tab" href="#paquetes" style="outline: none;">Paquetes</a></li> ';
			tabController +=' </ul> ';
			$("#tabPaqCatContainer").html(tabController);

			var loading = psDialog.loading().open();
			$.when( getPaquetes() ) .always(function() { loading.close(); });
			
		} else if(  psPermiso.eval("AFILIA_CAT") ) {
			$("#paquetes").remove();
			$("#catalogos").addClass("in active");
			var tabController ='  ';
			tabController +=' <ul class="nav nav-tabs"> ';
			tabController +=' <li id="liTabCatalogos" class="active"><a data-toggle="tab" href="#catalogos" style="outline: none;">Catálogos</a></li> ';
			tabController +=' </ul> ';
			$("#tabPaqCatContainer").html(tabController);

			var loading = psDialog.loading().open();
			$.when( getCatalogos() )
			.always(function()
			{
				loading.close();
			});
		}
	}

	function pasoTres() {
		var checkCatalogos = 0;
		var checkPaquetes = 0;
		var arrayPaquetes = [];
		var arrayCatalogos = [];
		var arrayAmer = [];
		var totalAPagarPaquetes = 0;
		var totalAPagarCatalogos = 0;

		$("input[id^='checkPaquete-']").each(function() {
			var id = $(this).attr("id").split("-")[1];

			if( $(this).prop("checked") ) {
				checkPaquetes++;
				arrayPaquetes.push( paquetes[id].idArt ) ;
				totalAPagarPaquetes += parseInt( paquetes[id].preMayN );
			}
		});

		$("input[id^='checkCatalogo-']").each(function() {
			var id = $(this).attr("id").split("-")[1];

			if( $(this).prop("checked") ) {
				checkCatalogos++;
				arrayCatalogos.push( {id:catalogos[id].idArt, preMayN:catalogos[id].preMayN} ) ;
				arrayAmer.push( catalogos[id].caCveN ) ;
			}
		});

		if( checkPaquetes==0 && checkCatalogos==0) {
			psDialog.warning("Selecciona un paquete o mínimo 4 catálogos.");
			return;
		}
		if( checkPaquetes > 1 ) {
			psDialog.warning("Selecciona sólo 1 paquete.");
			return;
		}
		if(checkPaquetes==0 && checkCatalogos < 4 ) {
			psDialog.warning("Selecciona al menos 4 catálogos.");
			return;
		}
		if( checkPaquetes == 1 && 	checkCatalogos == 0  ) {
			afiliaBitacora.tipoVenta = 1;
			afiliaBitacora.totalArticulos=checkPaquetes;
			afiliaBitacora.pagado=totalAPagarPaquetes;
			afiliaBitacora.articulos = arrayPaquetes.join(",");
			afiliaBitacora.observaciones="PAQUETE";
			afiliaBitacora.soCelStr = objectForm.soCelStr;

			afiliaBitacora.folioPepeleta = objectForm.folioPepeleta;
			afiliaBitacora.gpsUbicStr = objectForm.gpsUbicStr;
			afiliaBitacora.nominaCaptura = objectForm.nominaCaptura;
			afiliaBitacora.usrCveStr = objectForm.usrCveStr;

			indice++;

			$("#divConfirmaEnvia").show();

			setResumenPaqCat(arrayPaquetes,1,afiliaBitacora.pagado);
		} else if( checkPaquetes == 0 && 	checkCatalogos >= 4 ) {
			var loading = psDialog.loading().open();

			afiliaBitacora.tipoVenta = 2;
			afiliaBitacora.totalArticulos=0;
			afiliaBitacora.pagado=0;
			afiliaBitacora.articulos = arrayCatalogos.join(",");
			afiliaBitacora.observaciones="";
			afiliaBitacora.soCelStr = objectForm.soCelStr;

			afiliaBitacora.folioPepeleta = objectForm.folioPepeleta;
			afiliaBitacora.gpsUbicStr = objectForm.gpsUbicStr;
			afiliaBitacora.nominaCaptura = objectForm.nominaCaptura;
			afiliaBitacora.usrCveStr = objectForm.usrCveStr;

			system.service ({
				url:"getPaqueteAmer",
				data:{ listaCatalogos: arrayAmer.join(",") },
				callback:function(response) {
					var amer = response.rsGetPaqueteAmer;
					var correcto = false;
					var procDesc = null;
					var totalAfiliacion = 0;
					if( amer!=undefined ) {
						switch( amer.amerEstatusN ) {
						case 0:
							afiliaBitacora.totalArticulos = amer.amerCantidadN;
							afiliaBitacora.pagado = amer.amerTotalDescN;
							afiliaBitacora.observaciones = amer.amerPaqueteStr;
							procDesc = parseInt(amer.amerPorcDesc);
							correcto=true;
							break;
						default:
							psDialog.warning("La combinación de catálogos no es válida.");
							break;
						}
					}
					if( correcto) {
						indice++;
						$("#divConfirmaEnvia").show();
						//ya que se tiene la proporcion de descuento iterar arrayCatalogos para calcular el precio ya con descuento
						$.each( arrayCatalogos , function(i,obj)
						{
							obj.precio =  Math.ceil( parseInt(obj.preMayN) * ((100-procDesc)/100) );
							totalAfiliacion += obj.precio;
						});

						setResumenPaqCat(arrayCatalogos,2,totalAfiliacion,amer );
					}
				}
			})
			.always(function(){ loading.close(); });
		}
	}

	function setResumenPaqCat(data, tipo , total, amer) {
		var totalPagar = 0;
		var idRef = null;
		$("#divResumenPaqCat").html("");
		$("#spanTotalPagar").html("");
		$("#spanEnvio").html("");
		$("#spanSeguro").html("");
		$("#spanTotal").html("");
		$("#idMemDigital").val("");

		var items='';
		if(tipo==1) {
			$.each(data,function(i,idArt) {
						var item = paquetes[idArt];
						var id = item.idArt;
						idRef = item.idArt;
						var desc = item.arDescStr;

						items+=' <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 padding-item"> ';
						items+=' <div class="card" > ';
						items+=' <table style="width: 100%;"> ';
						items+=' <tr> ';
						items+=' <td style="width:70px; height:70px;"> ';
						items+=' <img onerror="ecommerce.showDefaultImage(this)" alt="" src="http://static.priceshoes.com.mx/imgs/small/articulo/'+id+'.jpg" style="max-width: 100%; height: 55px;"> ';
						items+=' </td> ';
						items+=' <td style="padding-left:7px;" > ';
						items+=' <label class="lbl-reciente-1">'+desc+'</label> ';
						items+=' </td> ';
						items+=' </tr> ';
						items+=' </table> ';
						items+=' </div> ';
						items+=' </div> ';
					});
		} else if (tipo==2) {
			$.each(data,function(i,obj) {
				var item = catalogos[obj.id];
				var id = item.idArt;
				var desc = item.caDescStr;

				items+=' <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 padding-item"> ';
				items+=' <div class="card" > ';
				items+=' <table style="width: 100%;"> ';
				items+=' <tr> ';
				items+=' <td style="width:70px; height:70px;"> ';
				items+=' <img onerror="ecommerce.showDefaultImage(this)" alt="" src="http://static.priceshoes.com.mx/imgs/small/articulo/'+id+'.jpg" style="max-width: 100%; height: 55px;"> ';
				items+=' </td> ';
				items+=' <td style="padding-left:7px;" > ';
				items+=' <label class="lbl-reciente-1">'+desc+'</label> ';
				items+=' </td> ';
				items+=' </tr> ';
				items+=' </table> ';
				items+=' </div> ';
				items+=' </div> ';
			});
		}
		var paqName='';

		if(tipo==2)
		{
			var descuento = parseFloat( amer.amerTotalN  ) - parseFloat( amer.amerTotalDescN );
			//$("#spanAhorro").html("Usted ahorra: " + system.moneyFormatter(descuento));
			paqName='<label>Paquete '+amer.amerPaqueteStr+'</label>';
		} else {
			$("#spanAhorro").html("");
		}

		if(idRef==971394) {//971394
			var gastosEnv = 0;
			var propSegMens = 0;
			var segMens =Math.ceil(parseFloat(total)+(propSegMens));

			totalPagar = parseFloat(total);

			$("#divResumenPaqCat").html(paqName + items);
			$("#spanTotalPagar").html( system.moneyFormatter(total));
			$("#spanTotal").html( system.moneyFormatter(	totalPagar));
		} else {
			var gastosEnv = objectAfiliacion.paqueteria.gastosEnvio;
			var propSegMens = parseFloat(objectAfiliacion.paqueteria.pctSeguroMensajeria);
			var segMens =Math.ceil(parseFloat(total)*(propSegMens/100));

			totalPagar = parseFloat(total) + parseFloat(gastosEnv) + parseFloat(segMens);
			
			$("#divResumenPaqCat").html(paqName + items);
			$("#spanTotalPagar").html( system.moneyFormatter(total));
			$("#spanEnvio").html( system.moneyFormatter(	gastosEnv ));
			$("#spanSeguro").html( system.moneyFormatter(	segMens ));
			$("#spanTotal").html( system.moneyFormatter(	totalPagar));
		};

		objectAfiliacion.articulos = {
			data:data,
			tipo:tipo,
			total:total,
			amer:amer
		};
	}

	function setDatePicker() {
		var fecha = $('#nacimiento');

		var options = {
			format : 'dd/mm/yyyy',
			todayHighlight : true,
			autoclose : true,
			language : SYS_LANG,
			orientation : "auto",
			clearBtn: true,
			startView: 2,
			maxViewMode: 2,
			defaultViewDate: { year: 1990}
		};

		fecha.datepicker(options);
	}

	this.preload = function() {
		if( $e.preregistro != null && $e.preregistro.length > 0 ) {
			$e.preregistro = JSON.parse( $e.preregistro );
			try {
				$("#nombre").val(  $e.preregistro.nombre );
				$("#celular").val( $e.preregistro.telefono );
			}catch(e){}
		} else {
			$e.preregistro = null;
		}
	};

	function getReferencia() {
		return system.service ({ url:"getReferencia",data: { origen: "AF"}	});
	}
	
	this.regresarLista = function() {
		$('#listado').show();
		$('#formulario').hide();
		sessionStorage.removeItem('infoSocioTmp');
	}
	
	function setProperties (id,value) {
		$("#"+id).val(value);
		$("#"+id).attr('readonly', true);
		$("#"+id).attr('title', 'Doble click para desbloquear');
		$("#"+id).dblclick(function() {
			$("#"+id).attr('readonly', false);
		}); 
	}
	
	function getDatosCliente() {
		var datos = JSON.parse(sessionStorage.getItem('infoSocioTmp'));
		if (datos) {
			if (datos.idSocio) {
				$("#idsocio").val(datos.idSocio);
				$("#idsocio").attr('readonly', true);
				$("#idsocio").attr('title', 'No se puede editar');
			}
			if (datos.rfc) {
				$("#rfcPrice").val(datos.rfc);
				$("#rfcPrice").attr('readonly', true);
				$("#rfcPrice").attr('title', 'No se puede editar');
				$("#rfcPrice").attr('display', 'inline');
			}
			if (datos.soNombre)
				setProperties ("nombre",datos.soNombre);
			if (datos.apellidoPaterno)
				setProperties ("paterno",datos.apellidoPaterno);
			if (datos.apellidoMaterno)
				setProperties ("materno",datos.apellidoMaterno);
			if (datos.email) {
				$("#email").val(datos.email);
				$('#email').attr('readonly', true);
				$("#email").attr('title', 'No se puede editar');
			}
			if (datos.telefono)
				setProperties ("celular",datos.telefono);
			if (datos.fnac) {
				$("#nacimiento").val(datos.fnac);
				$('#nacimiento').attr('readonly', true);
			}
			if (datos.calle)
				setProperties ("calle",datos.calle);
			if (datos.noExterior)
				setProperties ("numeroExt",datos.noExterior);
			if (datos.noInterior)
				setProperties ("numeroInt",datos.noInterior);
			if (datos.cp) {
				$("#cp").val(datos.cp);
				$('#btnBuscar').trigger('click');
			}			
			if (datos.referencia)
				setProperties ("referencias",datos.referencia);
			if (datos.entreCalles)
				setProperties ("entreCalles",datos.entreCalles);
			
		} else {
			psDialog.warning("No hay datos de cliente.");
			ecommerce.regresarLista();
		}
	}
	
	this.init= function() {
		getDatosCliente();
		getEstados();
		setDatePicker();
		otroDomicilio();
		addOnClickBtnValidar();
		getPaquetes();
		getCatalogos();
		loadCatalogosPaquetes();
		onclickBtnSaveEcomm();
		onclickBtnPasoTres();
		onclickBtnRegresar();
		onclickBtnSiguiente();
		addOnClickBtnBuscar();
		addOnClickBtnBuscarSegDireccion();
		onclickBtnCancelar();
		onclickBtnRegresarDatos();
		addOnClickBtnPagar();
		addOnClickBtnFinalizarProceso();

		$("#clearSoCpStr").click(	onclickclearSoCpStr  );
		$('#btnPaqueteria').click(function(){ onclickBtnPaqueteria(cp); });
		
		$('#btnBackProcesar').click(function (e) {
			e.preventDefault();
			ecommerce.regresarLista();
		});
		
	};

}).apply(ecommerce);
$(document).ready(function(){
	try {
		ecommerce.init();
	} catch (e) {
		console.log(e)
	}
});
