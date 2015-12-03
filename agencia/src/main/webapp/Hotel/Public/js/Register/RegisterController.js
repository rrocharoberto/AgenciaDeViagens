var RegisterController = (function() {
	
	var selectedRow;
	
	init = function() {
		setEvents();
	};

	setEvents = function() {
		$(document).ready(function() { $('select').material_select(); });
		
		$(".dropdown-button").dropdown();
		
		$('.tooltipped').tooltip({ delay : 50 });
		$("#home").attr('href', 'http://localhost:8080/agencia/api/hotel/root/home')
		$("#register").attr('href', 'http://localhost:8080/agencia/api/hotel/root/register');
		$("#report").attr('href', 'http://localhost:8080/agencia/api/hotel/root/report');
		mountGrid();
		setButtonEvents();
	};

	mountGrid = function() {
		var table = $('#hotelGrid').DataTable({
			"ajax" : 'http://localhost:8080/agencia/api/hotel/root/getAll',
			"columns" : [ 
			             { "data" : "id", "sWidth" : "5%", "sClass" : "center" }, 
			             { "data" : "name", "sWidth" : "25%", "sClass" : "center" }, 
			             { "data" : "value", "sWidth" : "20%", "sClass" : "center" }, 
			             { "data" : "rooms", "sWidth" : "10%", "sClass" : "center" }, 
			             { "data" : "city", "sWidth" : "25%", "sClass" : "center" }, 
			             { "data" : "isActive", "sWidth" : "20%", "sClass" : "center" } 
			            ],
			            "columnDefs": [
			                           {
			                               "targets": 2,
			                               "render": function (data, type, row) {
			                                   return formatDaialyValue(JSON.stringify(row.value));
			                               }
			                           },

			                           {
			                               "targets": 5,
			                               "render": function (data, type, row) {
			                                   return renderIsActiveIcon(JSON.stringify(row.isActive));
			                               }
			                           }
			                       ],
			"fnDrawCallback" : function(oSettings) {
			}
		});
		
		 $("#hotelGrid").on( 'click', 'tr', function () {
		        if ( $(this).hasClass('selected') ) {
		            $(this).removeClass('selected');
		            selectedRow = null;
		        }
		        else {
		            table.$('tr.selected').removeClass('selected');
		            $(this).addClass('selected');
		            selectedRow = table.row(this).data();
		        }
		  });
	};
	
	formatDaialyValue = function(valor){
		var inteiro = null, decimal = null, c = null, j = null;
		var aux = new Array();
		valor = ""+valor;
		c = valor.indexOf(".",0);
		//encontrou o ponto na string
		if(c > 0){
			//separa as partes em inteiro e decimal
			inteiro = valor.substring(0,c);
			decimal = valor.substring(c+1,valor.length);
		}else{
			inteiro = valor;
		}
		
		//pega a parte inteiro de 3 em 3 partes
		for (j = inteiro.length, c = 0; j > 0; j-=3, c++){
			aux[c]=inteiro.substring(j-3,j);
		}
		
		//percorre a string acrescentando os pontos
		inteiro = "";
		for(c = aux.length-1; c >= 0; c--){
			inteiro += aux[c]+'.';
		}
		//retirando o ultimo ponto e finalizando a parte inteiro
		
		inteiro = inteiro.substring(0,inteiro.length-1);
		
		decimal = parseInt(decimal);
		if(isNaN(decimal)){
			decimal = "00";
		}else{
			decimal = ""+decimal;
			if(decimal.length === 1){
				decimal = decimal+"0";
			}
		}
		
		valor = "R$ "+inteiro+","+decimal;
		
		return valor;

	};
	
	renderIsActiveIcon = function(isActive){
		if(isActive == "true"){
			return String.format("<i class='mdi-action-done'></i>")
		}
		return String.format("<i class='mdi-navigation-close'></i>")
	}

	setButtonEvents = function() {
		$("#newHotel").attr('onclick', 'loadHotelRegisterPartial("create", "Cadastro de Hotel")');
		$("#editHotel").attr('onclick', 'validateToEdit()');
		$("#deleteHotel").attr('onclick', 'validateToDelete()');
	};
	
	validateToEdit = function(){
		var isValid = validateSelectedRow();
		
		if(isValid){
			loadHotelRegisterPartial("edit", "Editar Hotel");
		}
	};
	
	validateToDelete = function(){
		var isValid = validateSelectedRow();
		
		if(isValid){
			swal({ title: "Atenção!", text: "Deseja mesmo deletar este hotel?",  type: "warning",   
				   showCancelButton: true,   confirmButtonColor: "#DD6B55",   
				   confirmButtonText: "Sim", cancelButtonText: "Não",
				   closeOnConfirm: false }, function(isConfirm){
					   
					   if (isConfirm) {
						   
					        var formData = {
					        	'id' : selectedRow.id
					         };
					        
					        $.ajax({
					        	type: 'POST',
					        	url: 'http://localhost:8080/agencia/api/hotel/root/delete',
					        	data: formData,
					        	dataType : 'json',
					        	contentType: 'application/json',
					        	success: function(result){
					        		swal("Sucesso!", result, "success");
					        		Features.refreshTable();
					        	}, 
					        	error: function(result){
					        		swal("Erro!", result, "error");
					        		Features.refreshTable();
					        	}
					        });
					   } 
				});
		}
	};
	
	validateSelectedRow = function(){
		if(selectedRow == null || selectedRow == undefined || selectedRow.lenght < 1){
			swal("Erro!", "Por favor, selecione ao menos uma linha da tabela!", "error");
			return false;
		}
		
		return true;
	};

	loadHotelRegisterPartial = function(action, hotelHead) {
		$("#divToHotelRegisterPartial")
			.load("/agencia/Hotel/Views/Register/Shared/hotelRegisterPartial.html",
				function(res, status, req) {
					if (status == "success") {
						$("#hotelRegisterModal").openModal();
						$("#modal-head").text(hotelHead);
						
						if(action == "edit"){
							$('#hotel_id').val(selectedRow.id);
							$('#hotel_name').val(selectedRow.name);
							$('#hotel_daily_value').val(formatDaialyValue(selectedRow.value));
							$('#hotel_rooms').val(selectedRow.rooms);
							$('#hotel_isActive').prop('checked', selectedRow.isActive);
							
							$('#hotel_name_label').addClass('active');
							$('#hotel_daily_value_label').addClass('active');
							$('#hotel_rooms_label').addClass('active');
						}
					}
			});
	};

	return {
		init : init
	}

})();

$(document).ready(function() {
	RegisterController.init();
});