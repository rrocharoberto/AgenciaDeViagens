app.factory('HotelService', ['RESTServiceHotel', function(RESTServiceHotel) {
    var service = {
        savePackage : function(hotelReservation) {
            return RESTServiceHotel.savePackage(hotelReservation);
        },
        getHotels: function(packageId) {
            return RESTServiceHotel.getHotels(packageId);
        }
    };
    return service;
}]);
