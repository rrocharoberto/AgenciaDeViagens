app.factory('HotelService', ['RESTServiceHotel', function(RESTServiceHotel) {
    var service = {
        savePackage : function(flightReservation) {
            return RESTServiceHotel.savePackage(flightReservation);
        },
        getHotels: function(packageId) {
            return RESTServiceHotel.getHotels(packageId);
        }
    };
    return service;
}]);
