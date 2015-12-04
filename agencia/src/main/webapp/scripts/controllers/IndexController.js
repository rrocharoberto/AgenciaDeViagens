app.controller('IndexController', ['$scope', 'PackageService', function($scope, PackageService) {
    $scope.message = 'Bem vindo a sua nova agência de viagens';
    $scope.modules = [{
        link: 'http://localhost:8080/agencia/restaurant',
        name: 'Restaurante',
        description: 'Modulo Restaurante do trabalho de Agência de viagens',
        image: 'images/restaurante.jpg'
    }, {
        link: 'http://localhost:8080/agencia/Hotel/Views/Home',
        name: 'Hotel',
        description: 'Modulo Hotel do trabalho de Agência de viagens',
        image: 'images/hotel.jpg'
    }, {
        link: 'http://localhost:8080/agencia/PontosTuristicos/index.xhtml',
        name: 'Pontos Turísticos',
        description: 'Modulo Pontos turísticos do trabalho de Agência de viagens',
        image: 'images/ponto-turistico.jpg'
    }, {
        link: 'http://localhost:8080/agencia/voo',
        name: 'Voos',
        description: 'Modulo Voo do trabalho de Agência de viagens',
        image: 'images/voo.jpg'
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
