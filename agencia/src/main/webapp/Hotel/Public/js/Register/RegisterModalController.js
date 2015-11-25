var RegisterModalController = (function(){
	
	init = function(){
		setEvents();
		handleOnFormSubmit();
	};
	
	setEvents = function(){
		$('select').material_select();
	};
	
	handleOnFormSubmit = function(){
		$(function(){
			$('#hotelRegisterForm').on('submit', function(event) {
				
		        var formData = {
		                'name' : $('#hotel_name').val(),
		                'value' : $('#hotel_daily_value').val(),
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
	
	return {
		init: init
	}
	
})();

$(document).ready(function(){
	RegisterModalController.init();
});