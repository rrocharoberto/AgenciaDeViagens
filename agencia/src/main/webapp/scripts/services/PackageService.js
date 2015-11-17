app.factory('PackageService', ['RESTServicePackage', function(RESTServicePackage) {
    var service = {
        createPackage : function(package) {
            return RESTServicePackage.createPackage(package);
        }
    };
    return service;
}]);
