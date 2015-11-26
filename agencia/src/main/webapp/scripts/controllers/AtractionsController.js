app.controller('AtractionsController', ['$scope',  'toastr', 'PackageService', 'AtractionsService',
function($scope, toastr, PackageService, AtractionsService) {
    $scope.package = PackageService.getPackage();
    $scope.atractionsReservation = {};

    $scope.loadAtractions = function() {
        AtractionsService.getAtractions(1).then($scope.successLoadAtractions);
    };

    $scope.savePackage = function() {
        AtractionsService.savePackage($scope.atractionsReservation).then($scope.successSavePackage);
    };

    /*** CALLBACK FUNCTIONS ***/
    $scope.successLoadAtractions = function(response) {
        var data = response.data;
        $scope.atractions = data;
    };

    $scope.successSavePackage = function() {
        toastr.success('Sucesso ao salvar o pacote!', {
            closeButtonn: true
        });
        window.location.href = '#payment';
    };

    $scope.loadAtractions();
}]);
