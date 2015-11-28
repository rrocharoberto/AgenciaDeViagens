app.factory('RestaurantService', ['RESTServiceRestaurant', function(RESTServiceRestaurant) {
    var service = {
        savePackage : function(restaurantReservation) {
            return RESTServiceRestaurant.savePackage(restaurantReservation);
        },
        getRestaurants: function(packageId) {
            return RESTServiceRestaurant.getRestaurants(packageId);
        }
    };
    return service;
}]);
