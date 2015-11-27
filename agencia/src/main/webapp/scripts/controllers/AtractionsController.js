app.controller('AtractionsController', ['$scope',  'toastr', 'PackageService', 'AtractionsService',
function($scope, toastr, PackageService, AtractionsService) {
    $scope.package = PackageService.getPackage();
    $scope.atractionsReservation = {atractions:[]};

    $scope.loadAtractions = function() {
        AtractionsService.getAtractions(1).then($scope.successLoadAtractions);
    };

    $scope.savePackage = function() {
        if ($scope.atractionsLoaded) {
            for (var i = 0; i < $scope.atractionsLoaded.length; i++) {
                var atraction = $scope.atractionsLoaded[i];
                $scope.atractionsReservation.atractions[i].cidade = atraction.cidade;
                $scope.atractionsReservation.atractions[i].descricao = atraction.descricao;
                $scope.atractionsReservation.atractions[i].numeroVagas = atraction.numeroVagas;
            }
        }
        AtractionsService.savePackage($scope.atractionsReservation).then($scope.successSavePackage);
    };

    /*** CALLBACK FUNCTIONS ***/
    $scope.successLoadAtractions = function(response) {
        var data = response.data;
        $scope.atractionsLoaded = data;
    };

    $scope.successSavePackage = function() {
        toastr.success('Sucesso ao salvar o pacote!', {
            closeButtonn: true
        });
        window.location.href = '#payment';
    };

    $scope.loadAtractions();
}]);
