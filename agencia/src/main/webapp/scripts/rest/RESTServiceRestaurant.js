app.factory('RESTServiceRestaurant', ['$http', 'URL', function($http, URL) {
    var basePath = URL + '/restaurant';
    return {
        savePackage: function(restaurantReservation) {
            return $http.post(basePath + '/reservation', restaurantReservation);
        },
        getRestaurants: function(packageId) {
            return $http.get(basePath + '?packageId=' + packageId);
        }
    };
}]);
