app.controller('IndexController', ['$scope', 'PackageService', function($scope, PackageService) {
    $scope.message = 'Bem vindo a sua nova agência de viagens';
    $scope.modules = [{
        link: 'http://localhost:8080/agencia/restaurant',
        name: 'Restaurante'
    }, {
        link: 'http://localhost:8080/agencia/Hotel/Views/Home',
        name: 'Hotel'
    }, {
        link: 'http://localhost:8080/agencia/PontosTuristicos/index.xhtml',
        name: 'Pontos Turísticos'
    }, {
        link: 'http://localhost:8080/agencia/voo',
        name: 'Voos'
    }];

    $scope.loadPackages = function() {
        PackageService.listPackages().then($scope.successLoadPackages);
    };

    /*** CALLBACK FUNCTIONS ***/
    $scope.successLoadPackages = function(response) {
        var data = response.data;
        $scope.packages = data;
    };

    $scope.loadPackages();
}]);
