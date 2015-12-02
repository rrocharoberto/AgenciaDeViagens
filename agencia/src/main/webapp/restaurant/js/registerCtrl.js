window.angular.module('restaurantModule').controller('registerCtrl', ['$scope', 'restaurantResource', 'cityResource',
    function (scope, restaurantResource, cityResource) {

        scope.register = {
            name: undefined,
            city: undefined,
            quantitySeats: 0,
            price: 0
        };

        scope.add = function () {
            scope.titleModalRegister = 'Novo cadastro';
            delete scope.register;
            $('#modalRegister').openModal();
        };

        scope.edit = function (restaurant) {
            scope.titleModalRegister = 'Editar cadastro';
            delete scope.register;
            scope.register = window.angular.copy(restaurant);
            $('#modalRegister').openModal();
        };

        scope.remove = function (restaurant) {
            console.log(restaurant);
        };

        scope.save = function (register) {
            console.log(register);
            $('#modalRegister').closeModal();
        };

        function setCity() {

            cityResource.listAll.get({}, function (data) {
                scope.cityList = data.cityList;

                setTimeout(function () {
                    $('select').material_select();
                });

                // TODO: isso irá retornar do servidor. Somente teste.
                scope.restaurantList = [
                    {name: "Restaurante 1", city: scope.cityList[0], quantitySeats: "20", price: "30,00"},
                    {name: "Restaurante 2", city: scope.cityList[1], quantitySeats: "30", price: "45,00"},
                    {name: "Restaurante 3", city: scope.cityList[0], quantitySeats: "15", price: "25,00"}
                ];

            }, function () {
                console.error('Error GET city list');
            });
        }

        setCity();

    }]);