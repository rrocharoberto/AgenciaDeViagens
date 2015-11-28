window.angular.module('restaurantModule', ['ngRoute']);

window.angular.module('restaurantModule').config(['$routeProvider', function ($routeProvider) {

        $routeProvider.
                when('/', {
                    controller: 'homeCtrl',
                    templateUrl: 'templates/_home.html'
                }).
                when('/register/:restaurantId', {
                    controller: 'registerCtrl',
                    templateUrl: 'templates/_register.html'
                }).
                when('/report', {
                    controller: 'reportCtrl',
                    templateUrl: 'templates/_report.html'
                }).
                otherwise({
                    redirectTo: '/'
                });

    }]);