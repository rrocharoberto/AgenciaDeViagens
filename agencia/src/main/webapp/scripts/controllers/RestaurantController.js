app.controller('RestaurantController', ['$scope',  'toastr', 'PackageService', 'RestaurantService',
function($scope, toastr, PackageService, RestaurantService) {
    $scope.package = PackageService.getPackage();
    $scope.restaurantReservation = {
        pacote: $scope.package,
        dataReserva: $scope.package.dataInicio
    };

    $scope.loadRestaurants = function() {
        RestaurantService.getRestaurants($scope.package.id).then($scope.successLoadRestaurants);
    };

    $scope.savePackage = function() {
        RestaurantService.savePackage($scope.restaurantReservation).then($scope.successSavePackage);
    };

    /*** CALLBACK FUNCTIONS ***/
    $scope.successLoadRestaurants = function(response) {
        var data = response.data;
        $scope.restaurants = data;
    };

    $scope.successSavePackage = function() {
        toastr.success('Sucesso ao salvar o pacote!', {
            closeButtonn: true
        });
        window.location.href = '#restaurant';
    };
}]);
