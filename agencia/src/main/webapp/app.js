var app = angular.module('AgencyApp', [
	'ngRoute',
	'toastr'
]);

app.config(['$routeProvider', function($routeProvider) {
	$routeProvider.
		when('/', {
			controller: 'IndexController',
			templateUrl: 'views/index.html'
		}).
		when('/create-package', {
			controller : 'CreatePackageController',
			templateUrl: 'views/create-package.html'
		}).
		when('/flight', {
			controller: 'FlightController',
			templateUrl: 'views/create-package-flight.html'
		}).
		when('/hotel', {
			controller: 'HotelController',
			templateUrl: 'views/create-package-hotel.html'
		}).
		when('/restaurant', {
			controller: 'RestaurantController',
			templateUrl: 'views/create-package-restaurant.html'
		});
}]);

// Define a constant to connect with web service
app.value('URL', 'http://localhost:8080/agencia/api');
