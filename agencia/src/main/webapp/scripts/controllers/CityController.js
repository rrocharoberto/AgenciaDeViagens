app.controller('CityController', ['$scope', 'CityService', function($scope, CityService) {
    $scope.loadCity = function() {
        CityService.getCities().then($scope.successLoadCity);
    }

    /*** CALLBACK FUNCTIONS ***/
    $scope.successLoadCity = function() {
        console.log('Retrive cities successfully');
    };

    $scope.loadCity();
}]);
