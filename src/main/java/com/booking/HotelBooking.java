/**
 * Domain Model
 */
package com.booking;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author EUNSOO
 *
 */
@Entity
public class HotelBooking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)		// i.e, 1,2,3...
	private long id;
	
	private String hotelName;
	private double pricePerNight;
	private int numberOfNights;
	
	// Create default constructor for the REST POST method based on JSON
	public HotelBooking() {
	}
	
	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public double getPricePerNight() {
		return pricePerNight;
	}

	public void setPricePerNight(double pricePerNight) {
		this.pricePerNight = pricePerNight;
	}

	public int getNumberOfNights() {
		return numberOfNights;
	}

	public void setNumberOfNights(int numberOfNights) {
		this.numberOfNights = numberOfNights;
	}
	
	public long getId() {
		return id;
	}

	public HotelBooking(String hotelName, double pricePerNight, int numberOfNights) {
		this.hotelName = hotelName;
		this.pricePerNight = pricePerNight;
		this.numberOfNights = numberOfNights;
	}
}
