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
            restaurant.isActive = false;
            scope.save(restaurant);
        };

        scope.save = function (register) {
            
            if (register.id === undefined) {
                restaurantResource.create.save(register, function (response) {
                    getRestaurantList();
                }, function (response) {
                    console.error('Error CREATE restaurant. Cause: ' + JSON.stringify(response));
                });
            } else {
                restaurantResource.update.save(register, function (response) {
                    getRestaurantList();
                }, function (response) {
                    console.error('Error UPDATE restaurant. Cause: ' + JSON.stringify(response));
                });
            }

            $('#modalRegister').closeModal();
        };

        function getRestaurantList() {
            restaurantResource.listAll.get({}, function (response) {

                scope.restaurantList = response.restaurantList;
                
                setTimeout(function () {
                    $('select').material_select();
                });

            }, function (response) {
                console.error('Error GET ALL restaurants. Cause: ' + JSON.stringify(response));
            });
        }

        function setCity() {

            cityResource.listAll.get({}, function (response) {
                scope.cityList = response.cityList;
                getRestaurantList();
            }, function (response) {
                console.error('Error GET city list. Cause: ' + JSON.stringify(response));
            });
        }

        setCity();

    }]);