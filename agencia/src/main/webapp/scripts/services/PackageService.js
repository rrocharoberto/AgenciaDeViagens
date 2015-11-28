app.factory('PackageService', ['RESTServicePackage', function(RESTServicePackage) {
    var package = {};
    var service = {
        createPackage : function(package) {
            return RESTServicePackage.createPackage(package);
        },
        getPackage : function() {
            return package;
        },
        setPackage : function(newPackage) {
            package = newPackage;
        }
    };
    return service;
}]);
