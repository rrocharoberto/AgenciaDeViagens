window.angular.module('restaurantModule').factory('restaurantResource', ['$resource', function (resource) {
    return {
        create: resource('/agencia/api/restaurant/create'),
        update: resource('/agencia/api/restaurant/update'),
        listById: resource('/agencia/api/restaurant/:restaurantId'),
        listAll: resource('/agencia/api/restaurant/all')
    };
}]);

window.angular.module('restaurantModule').factory('cityResource', ['$resource', function (resource) {
    return {
        listAll: resource('/agencia/api/restaurant/city/list/all')
    };
}]);