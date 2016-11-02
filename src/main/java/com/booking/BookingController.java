/**
 * Hotel booking controller
 * 1. Define Spring REST based on JSON and tested in memory base.
 */
package com.booking;

import java.util.List;
//import java.util.stream.Collectors;

import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.pojo.ApiStage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author EUNSOO
 *
 */
@RestController
@RequestMapping(value = "/bookings")
@Api(name = "Hotel Booking API",
     description = "Provides a list of methods that manage hotel bookings",
     stage = ApiStage.RC)
public class BookingController {
	// Define HotelBookins reference to use in memory db
	// private List<HotelBooking> bookings;
	
	// Define Booking Repository to use real db
	private BookingRepository bookingRepository;
	
	// Define DI
	@Autowired
	public BookingController(BookingRepository bookingRepository) {
		this.bookingRepository = bookingRepository;
		
		/*
		 * Temporary in memory DB
		bookings = new ArrayList<>();
		
		bookings.add(new HotelBooking("Marriot", 200.30, 3));
		bookings.add(new HotelBooking("ComportInn", 100, 2));
		bookings.add(new HotelBooking("Novotel", 140.74, 1));
		*/
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ApiMethod(description = "Get all hotel bookings from the database")
	public List<HotelBooking> getAll() {
		return bookingRepository.findAll();
//		return bookings;
	}
	
	// @PathVariable: It provides condition according to value
	@RequestMapping(value = "/affordable/{price}", method = RequestMethod.GET)
	@ApiMethod(description = "Get all hotel bookings where the price per night is less than the provided value")
	public List<HotelBooking> getAffordable(@ApiPathParam(name = "price") @PathVariable double price) {
		return bookingRepository.findByPricePerNightLessThan(price);
		
		// return bookings.stream().filter(x -> x.getPricePerNight() <= price).collect(Collectors.toList());
	}
	
	// Update Hotel booking list
	// @RequestBody: It means we're going to initialize JSON post requests and if the request body will instruct spring that
	//				 it should try to automatically create a hotel booking object based on the json that is insider request.
	//				 this is the binding works between the client and server connection. 
	                 
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ApiMethod(description = "Create a hotel booking and save it to database")
	public List<HotelBooking> create(@RequestBody HotelBooking hotelBooking) {
		
		bookingRepository.save(hotelBooking);
		
		return bookingRepository.findAll();
		/*
		bookings.add(hotelBooking);
		
		return bookings;
		*/
	}
	
	//@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	@ApiMethod(description = "Remove the hotel booking with the provided ID from the database")
	public List<HotelBooking> remove(@ApiPathParam(name = "id") @PathVariable long id) {
		
		bookingRepository.delete(id);
		
		return bookingRepository.findAll(); // To receive the result of delete by id 
	}
}
