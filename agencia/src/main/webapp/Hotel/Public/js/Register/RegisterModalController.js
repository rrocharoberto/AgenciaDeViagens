var RegisterModalController = (function(){
	
	init = function(){
		setEvents();
		handleOnFormSubmit();
	};
	
	setEvents = function(){
		$('select').material_select();
		$("#hotel_daily_value").maskMoney({symbol:'R$ ', 
				showSymbol:true, thousands:'.', decimal:',', symbolStay: true});

	};
	
	handleOnFormSubmit = function(){
		$(function(){
			$('#hotelRegisterForm').on('submit', function(event) {
				
				var value = $('#hotel_daily_value').val();
				
		        var formData = {
		                'name' : $('#hotel_name').val(),
		                'value' : formatDaialyValue(value.substr(2)),
		                'city': $('#hotel_city').val(),
		                'rooms': $('#hotel_rooms').val(),
		                'isActive': $('#hotel_isActive').is(":checked") ? true : false
		         };
		        
		        $.ajax({
		        	type: 'POST',
		        	url: 'http://localhost:8080/agencia/api/hotel/root/create',
		        	data: formData,
		        	dataType : 'json',
		        	contentType: 'application/json',
		        	success: function(result){
		        		
		        	}, 
		        	error: function(result){
		        		
		        	}
		        });
				event.preventDefault();
			});
		});
	};
	
	formatDaialyValue = function(value){
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