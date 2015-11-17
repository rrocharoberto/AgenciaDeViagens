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
		});
}]);

// Define a constant to connect with web service
app.value('URL', 'http://localhost:8080/agencia/api');
