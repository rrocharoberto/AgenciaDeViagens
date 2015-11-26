var RegisterController = (function() {

	init = function() {
		setEvents();
	};

	setEvents = function() {
		$(".dropdown-button").dropdown();
		$('.tooltipped').tooltip({
			delay : 50
		});
		$("#home").attr('href',
				'http://localhost:8080/agencia/api/hotel/root/home')
		$("#register").attr('href',
				'http://localhost:8080/agencia/api/hotel/root/register');
		$("#report").attr('href',
				'http://localhost:8080/agencia/api/hotel/root/report');
		mountGrid();
		setButtonEvents();
	};

	mountGrid = function() {
		mountGrid = function() {

			$table = $('#hotelGrid');
			$table.dataTable({
				"ajax" : '',
				"sDom" : 'Rfrtlip',
				"bSort" : false,

				"columns" : [ {
					"data" : "name",
					"sWidth" : "25%",
					"sClass" : "center"
				}, {
					"data" : "value",
					"sWidth" : "20%",
					"sClass" : "center"
				}, {
					"data" : "rooms",
					"sWidth" : "10%",
					"sClass" : "center"
				}, {
					"data" : "city",
					"sWidth" : "25%",
					"sClass" : "center"
				}, {
					"data" : "isActive",
					"sWidth" : "20%",
					"sClass" : "center"
				} ],
				"fnDrawCallback" : function(oSettings) {
				}
			});
		}
	};

	setButtonEvents = function() {
		$("#newHotel").attr('onclick', 'loadHotelRegisterPartial()');
	};

	loadHotelRegisterPartial = function() {
		$("#divToHotelRegisterPartial").load(
				"/agencia/Hotel/Views/Register/Shared/hotelRegisterPartial.html",
				function(res, status, req) {
					if (status == "success") {
						$("#hotelRegisterModal").openModal();
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