package com.timetravel.travel.service;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.timetravel.travel.model.TravelDetail;
import com.timetravel.travel.service.exception.DateParadoxException;
import com.timetravel.travel.service.exception.PlaceParadoxException;

public class TravelServiceTest {

	@Test
	public void TestValidateAndSaveTravel() {
		TravelService service = new TravelService();
		
		TravelDetail detail = new TravelDetail();
		detail.setPgi("1N2N12H2N");
		detail.setPlace("Leicester");
		detail.setDate("2022-02-02");
	
		assertTrue(service.validateAndSaveTravel(detail));
	}
	
	@Test
	public void TestValidateAndSaveTravelPlaceParadox() {
		TravelService service = new TravelService();
		
		TravelDetail detail1 = new TravelDetail();
		detail1.setPgi("1N2N12H2N");
		detail1.setPlace("London");
		detail1.setDate("2022-02-02");
		
		TravelDetail detail2 = new TravelDetail();
		detail2.setPgi("1N2N12H2N");
		detail2.setPlace("London");
		detail2.setDate("2022-02-02");
	
		assertTrue(service.validateAndSaveTravel(detail1));
		
		try {
			assertTrue(service.validateAndSaveTravel(detail2));
		} catch (Exception e) {
			assertTrue(e instanceof PlaceParadoxException);
		}
	}
	
	@Test
	public void TestvalidateAndSaveTravelDateParadox() {
		TravelService service = new TravelService();
		
		TravelDetail detail1 = new TravelDetail();
		detail1.setPgi("1N2N12H2N");
		detail1.setPlace("Maidenhaid");
		detail1.setDate("2022-02-02");
		
		TravelDetail detail2 = new TravelDetail();
		detail2.setPgi("1N2N12H2N");
		detail2.setPlace("Glassgow");
		detail2.setDate("2022-02-02");
	
		assertTrue(service.validateAndSaveTravel(detail1));
		
		try {
			assertTrue(service.validateAndSaveTravel(detail2));
		} catch (Exception e) {
			assertTrue(e instanceof DateParadoxException);
		}
	}
	
}
