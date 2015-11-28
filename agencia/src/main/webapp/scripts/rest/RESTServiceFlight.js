app.factory('RESTServiceFlight', ['$http', 'URL', function($http, URL) {
    var basePath = URL + '/flight';
    return {
        savePackage: function(flightReservation) {
            return $http.post(basePath + '/reservation', flightReservation);
        },
        getTypes: function(packageId) {
            return $http.get(basePath + '/type?packageId=' + packageId);
        },
        getFlights: function(packageId) {
            return $http.get(basePath + '?packageId=' + packageId);
        }
    };
}]);
