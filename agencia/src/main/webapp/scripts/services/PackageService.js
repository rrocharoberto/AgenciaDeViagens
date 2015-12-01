app.factory('PackageService', ['RESTServicePackage', function(RESTServicePackage) {
    var package = {};
    var service = {
        createPackage : function(package) {
            return RESTServicePackage.createPackage(package);
        },
        listPackages: function() {
            return RESTServicePackage.listPackages();
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
