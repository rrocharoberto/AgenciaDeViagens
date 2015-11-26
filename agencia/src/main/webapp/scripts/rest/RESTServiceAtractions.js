app.factory('RESTServiceAtractions', ['$http', 'URL', function($http, URL) {
    var basePath = URL + '/atractions';
    return {
        savePackage: function(atractionsReservation) {
            return $http.post(basePath + '/reservation', atractionsReservation);
        },
        getAtractions: function(packageId) {
            return $http.get(basePath + '?packageId=' + packageId);
        }
    };
}]);
