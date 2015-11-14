var app = angular.module('AgencyApp', [
	'ngRoute'
]);

app.config(['$routeProvider', function($routeProvider) {
	$routeProvider.
		when('/', {
			controller: 'IndexController',
			templateUrl: 'views/index.html'
		}).
		when('/city', {
			controller : 'CityController',
			templateUrl: 'views/index.html'
		}).
		otherwise( {redirectTo: '/'});
}]);

// Define a constant to connect with web service
app.value('URL', 'http://localhost:8080/agencia/api');
