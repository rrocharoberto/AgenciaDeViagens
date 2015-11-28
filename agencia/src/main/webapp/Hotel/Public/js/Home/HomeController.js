var HomeController = (function(){
	
	init = function(){
		setEvents();
	};
	
	setEvents = function(){
		$(".dropdown-button").dropdown();
		$("#home").attr('href', 'http://localhost:8080/agencia/api/hotel/root/home')
		$("#register").attr('href', 'http://localhost:8080/agencia/api/hotel/root/register');
		$("#report").attr('href', 'http://localhost:8080/agencia/api/hotel/root/report');
	};
	
	return {
		init: init
	}
	
})();

$(document).ready(function(){
	HomeController.init();
});