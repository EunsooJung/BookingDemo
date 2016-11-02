/**
 * Command runner interface: run method
 * Multiple command line runners provides ordered process using @Order annotation. 
 * It means you can have multiple commander runner and can specify the order in which
 * they should execute
 */
package com.booking;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author EUNSOO
 *
 */
@Component
public class DatabaseSeeder implements CommandLineRunner {
	
	// Define reference to repository
	private BookingRepository bookingRepository;

	// Inject to Dependency Injection based on Constructor using the @Autowired
	// annotation
	@Autowired
	public DatabaseSeeder(BookingRepository bookingRepository) {
		this.bookingRepository = bookingRepository;
	}

	@Override
	public void run(String... strings) throws Exception {

		List<HotelBooking> bookings = new ArrayList<>();

		bookings.add(new HotelBooking("Marriot", 200.30, 3));
		bookings.add(new HotelBooking("ComportInn", 90, 4));
		bookings.add(new HotelBooking("Novotel", 140.74, 1));
		
		bookingRepository.save(bookings);
	}
}
