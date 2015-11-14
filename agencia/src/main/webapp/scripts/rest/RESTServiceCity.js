app.factory('RESTServiceCity', ['$http', 'URL', function($http, URL) {
    var basePath = URL + '/city';
    return {
        listCities: function() {
            return $http.get(basePath);
        }
    };
}]);
