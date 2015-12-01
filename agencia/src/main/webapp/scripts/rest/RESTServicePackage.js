app.factory('RESTServicePackage', ['$http', 'URL', function($http, URL) {
    var basePath = URL + '/package';
    return {
        createPackage: function(package) {
            return $http.post(basePath, package);
        },
        listPackages: function() {
            return $http.get(basePath);
        }
    };
}]);
