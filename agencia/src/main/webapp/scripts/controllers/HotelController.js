app.controller('HotelController', ['$scope',  'toastr', 'PackageService', 'HotelService',
function($scope, toastr, PackageService, HotelService) {
    $scope.package = PackageService.getPackage();
    $scope.hotelReservation = {
        pacote: $scope.package,
        dataReserva: $scope.package.dataInicio
    };

    $scope.loadHotels = function() {
        HotelService.getHotels($scope.package.id).then($scope.successLoadHotels);
    };

    $scope.savePackage = function() {
        HotelService.savePackage($scope.hotelReservation).then($scope.successSavePackage);
    };

    /*** CALLBACK FUNCTIONS ***/
    $scope.successLoadHotels = function(response) {
        var data = response.data;
        $scope.hotels = data;
    };

    $scope.successSavePackage = function() {
        toastr.success('Sucesso ao salvar o pacote!', {
            closeButtonn: true
        });
        window.location.href = '#restaurant';
    };
}]);
