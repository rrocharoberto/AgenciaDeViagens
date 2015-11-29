window.angular.module('restaurantModule').controller('registerCtrl', ['$scope',
    function (scope) {

        scope.restaurantList = [
            {name: "Restaurante 1", quantitySeats: "20", price: "30,00"},
            {name: "Restaurante 2", quantitySeats: "30", price: "45,00"},
            {name: "Restaurante 3", quantitySeats: "15", price: "25,00"}
        ];

        scope.add = function () {
            scope.titleModalRegister = 'Novo cadastro';
            scope.restaurant = {
                name: "", 
                quantitySeats: "", 
                price: ""
            };
            $('#modalRegister').openModal();
        };

        scope.edit = function (restaurant) {
            console.log(restaurant);
            scope.titleModalRegister = 'Editar cadastro';
            scope.restaurant = window.angular.copy(restaurant);
            $('#modalRegister').openModal();
        };

        scope.remove = function (restaurant) {
            console.log(restaurant);
        };

        scope.save = function (restaurant) {
            console.log(restaurant);
            $('#modalRegister').closeModal();
        };

    }]);