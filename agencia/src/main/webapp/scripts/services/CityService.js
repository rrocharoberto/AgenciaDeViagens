app.factory('CityService', ['RESTServiceCity', function(RESTServiceCity) {
    var service = {
        getCities : function() {
            return RESTServiceCity.listCities();
        }
    };
    return service;
}]);
