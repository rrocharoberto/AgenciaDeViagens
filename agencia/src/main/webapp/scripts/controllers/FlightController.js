app.controller('FlightController', ['$scope',  'toastr', 'CityService', 'PackageService', 'FlightService',
function($scope, toastr, CityService, PackageService, FlightService) {
    $scope.package = PackageService.getPackage();
    $scope.flightReservation = {pacote: $scope.package};

    $scope.loadCity = function() {
        CityService.getCities().then($scope.successLoadCity);
    };

    $scope.loadFlightTypes = function() {
        FlightService.getTypes($scope.package.id).then($scope.successLoadFlightTypes);
    };

    $scope.loadFlights = function() {
        FlightService.getFlights($scope.package.id).then($scope.successLoadFlights);
    };

    $scope.savePackage = function() {
        FlightService.savePackage($scope.flightReservation).then($scope.successSavePackage);
    };

    /*** CALLBACK FUNCTIONS ***/
    $scope.successLoadCity = function(response) {
        var data = response.data;
        $scope.cities = data;
    };

    $scope.successLoadFlightTypes = function(response) {
        var data = response.data;
        $scope.flightTypes = data;
    };

    $scope.successLoadFlights = function(response) {
        var data = response.data;
        $scope.flights = data;
    };

    $scope.successSavePackage = function() {
        toastr.success('Sucesso ao salvar o pacote!', {
            closeButtonn: true
        });
        window.location.href = '#hotel';
    };

    $scope.loadCity();
    $scope.loadFlightTypes();
    $scope.loadFlights();
}]);
