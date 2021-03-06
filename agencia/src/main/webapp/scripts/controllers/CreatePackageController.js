app.controller('CreatePackageController', ['$scope',  'toastr', 'CityService', 'PackageService',
function($scope, toastr, CityService, PackageService) {
    $scope.package = {};

    $scope.loadCity = function() {
        CityService.getCities().then($scope.successLoadCity);
    };

    $scope.createPackage = function() {
        PackageService.createPackage($scope.package).then($scope.successCreatePackage);
    }

    /*** CALLBACK FUNCTIONS ***/
    $scope.successLoadCity = function(response) {
        var data = response.data;
        $scope.cities = data;
    };

    $scope.successCreatePackage = function(response) {
        var data = response.data;
        $scope.package = data;
        toastr.success('Sucesso ao realizar o cadastro!', {
            closeButton: true
        });
        PackageService.setPackage($scope.package);
        window.location.href = '#flight';
    };

    $scope.loadCity();
}]);
