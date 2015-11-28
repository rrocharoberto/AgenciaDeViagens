app.factory('AtractionsService', ['RESTServiceAtractions', function(RESTServiceAtractions) {
    var service = {
        savePackage : function(atractionsReservation) {
            return RESTServiceAtractions.savePackage(atractionsReservation);
        },
        getAtractions: function(packageId) {
            return RESTServiceAtractions.getAtractions(packageId);
        }
    };
    return service;
}]);
