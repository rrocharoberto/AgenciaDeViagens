window.angular.module('restaurantModule').factory('restaurantResource', ['$resource', function (resource) {
    
    var restaurantResource = {
        cityList: resource('/agencia/api/restaurant/city/list/all'),
        create: resource('/agencia/api/restaurant/city/list/all'),
        update: resource('/agencia/api/restaurant/city/list/all'),
        listById: resource('/agencia/api/restaurant/city/list/all'),
        listAll: resource('/agencia/api/restaurant/city/list/all')
    };
    
    return restaurantResource;
}]);

window.angular.module('restaurantModule').factory('cityResource', ['$resource', function (resource) {
    
    var cityResource = {
        listAll: resource('/agencia/api/restaurant/city/list/all')
    };
    
    return cityResource;
}]);