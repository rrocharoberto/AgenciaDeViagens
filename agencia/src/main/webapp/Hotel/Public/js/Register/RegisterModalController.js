var RegisterModalController = (function(){
	
	init = function(){
		setEvents();
		handleOnFormSubmit();
	};
	
	setEvents = function(){
		$("#hotel_daily_value").maskMoney({ symbol:'R$ ', showSymbol:true, thousands:'.', 
											decimal:',', symbolStay: true});
		getCities();
	};
	
	handleOnFormSubmit = function(){
		$(function(){
			$('#hotelRegisterForm').on('submit', function(event) {
				event.preventDefault();	
				if($('#hotel_city').val() != null){
					var value = $('#hotel_daily_value').val();
					
			        var formData = {
			        		'id' : $("#hotel_id").val(),
			                'name' : $('#hotel_name').val(),
			                'value' : formatValue(value.substr(2)),
			                'city': $('#hotel_city').val(),
			                'rooms': $('#hotel_rooms').val(),
			                'isActive': $('#hotel_isActive').is(":checked") ? true : false
			         };
			        
			        var url = ($("#modal-head").text() == "Cadastro de Hotel") ? 'http://localhost:8080/agencia/api/hotel/root/create' 
			        														   : 'http://localhost:8080/agencia/api/hotel/root/edit';
			        
			        $.ajax({
			        	type: 'POST',
			        	url: url,
			        	data: formData,
			        	dataType : 'json',
			        	contentType: 'application/json',
			        	success: function(result){	
			        		swal("Sucesso!", result, "success");
			        		$("#hotelRegisterModal").closeModal();
			        		Features.refreshTable();
			        	}, 
			        	error: function(result){
			        		Features.refreshTable();
			        		swal("Erro!", result, "error");
			        		$("#hotelRegisterModal").closeModal();
			        	}
			        });
				} else {
					swal("Erro!", "Por favor, selecione ao menos uma cidade da lista!", "error");
				}
			});
		});
	};
	
	getCities = function(){
		var cities = "";
		$.getJSON("http://localhost:8080/agencia/api/hotel/root/getCities", function(data){
			$.each(data, function(index, item) {
				cities += String.format("<option value='{0}'>{1}</option>", item.id, item.name);
			});
			$("#hotel_city").append(String.format("{0}", cities));
			$('select').material_select();
		
		});
	};
	
	formatValue = function(value){
		if(value === ""){
			 return "0";
	      }else{
	    	 value = value.replace(".","");
	    	 value = value.replace(",",".");
	      }
	      return value;
	};
	
	return {
		init: init
	}
	
})();

$(document).ready(function(){
	RegisterModalController.init();
});