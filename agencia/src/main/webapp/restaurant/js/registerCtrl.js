window.angular.module('restaurantModule').controller('registerCtrl', ['$scope', '$routeParams', 
    function (scope, routeParams) {
        console.log(scope);
        console.log(routeParams.restaurantId);
    }]);