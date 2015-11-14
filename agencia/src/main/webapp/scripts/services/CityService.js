app.factory('CityService', ['$http', 'RESTServiceCity', function($http, RESTServiceCity) {
    var service = {
        getCities : function() {
            return RESTServiceCity.listCities();
        }
    };
    return service;
}]);
