var HomeController = (function(){
	
	init = function(){
		//Common.loadHeader();
		$(".dropdown-button").dropdown();
	};
	
	return {
		init: init
	}
	
})();

$(document).ready(function(){
	HomeController.init();
});