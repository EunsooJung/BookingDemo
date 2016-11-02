/**
 * Data Repository interface
 */
package com.booking;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author EUNSOO
 *
 */
@Repository
public interface BookingRepository extends JpaRepository<HotelBooking, Long>{
	List<HotelBooking> findByPricePerNightLessThan(double price);
}
