/**
 * 
 */
(function() {
	'use strict';
	
	angular.module('app').controller('BookingsController', BookingsController);
	
	BookingsController.$inject = ['$http']; // inject dependency
	
	function BookingsController($http) {
		var vm = this;
		
		vm.bookings = [];
		// private function make them visible
		vm.getAll = getAll;
		vm.getAffordable = getAffordable;
		vm.deleteBooking = deleteBooking;
		
		init();
		
		// initialize function
		function init() {
			getAll();
		}
		
		// retrieve to all of hotel bookings information
		function getAll() {
			// url is reference to spring controller (BookingController.java)
			var url = "/bookings/all";
			// Define REST
			var bookingsPromise = $http.get(url);
			bookingsPromise.then(function(response) {
				vm.bookings = response.data;
			});
		}
		
		// Call spring affordable less than 90 method
		function getAffordable(){
            var url = "/bookings/affordable/" + 100;
            var bookingsPromise = $http.get(url);
            bookingsPromise.then(function(response){
                vm.bookings = response.data;
            });
        }
		
		// Call Spring remove method
		function deleteBooking(id) {
			var url = "/bookings/delete/" + id;
			// Modify removeBooking method with REST GET in BookingContoller.java to REST POST
			$http.post(url).then(function(response) {
				vm.bookings = response.data;
			});
		}
	}
})();