app.factory('FlightService', ['RESTServiceFlight', function(RESTServiceFlight) {
    var service = {
        savePackage : function(flightReservation) {
            return RESTServiceFlight.savePackage(flightReservation);
        },
        getTypes: function(packageId) {
            return RESTServiceFlight.getTypes(packageId);
        },
        getFlights: function(packageId) {
            return RESTServiceFlight.getFlights(packageId);
        }
    };
    return service;
}]);
