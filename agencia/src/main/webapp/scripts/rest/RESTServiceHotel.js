app.factory('RESTServiceHotel', ['$http', 'URL', function($http, URL) {
    var basePath = URL + '/hotel';
    return {
        savePackage: function(hotelReservation) {
            return $http.post(basePath + '/reservation', hotelReservation);
        },
        getHotels: function(packageId) {
            return $http.get(basePath + '?packageId=' + packageId);
        }
    };
}]);
