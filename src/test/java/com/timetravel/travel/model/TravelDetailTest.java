package com.timetravel.travel.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TravelDetailTest {

	@Test(expected=IllegalArgumentException.class)
	public void TestNullPgi() {
		TravelDetail detail = new TravelDetail();
		detail.setPgi(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void TestNullPlace() {
		TravelDetail detail = new TravelDetail();
		detail.setPlace(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void TestNullDate() {
		TravelDetail detail = new TravelDetail();
		detail.setDate(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void TestEmptyPgi() {
		TravelDetail detail = new TravelDetail();
		detail.setPgi(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void TestEmptyPlace() {
		TravelDetail detail = new TravelDetail();
		detail.setPlace(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void TestEmptyDate() {
		TravelDetail detail = new TravelDetail();
		detail.setDate(null);
	}
	
	@Test
	public void TestValidPgi() {
		TravelDetail detail = new TravelDetail();
		detail.setPgi("1N2N12H2N");
		assertEquals("1N2N12H2N", detail.getPgi());
	}
	
	@Test
	public void TestValidPlace() {
		TravelDetail detail = new TravelDetail();
		detail.setPlace("London");
		assertEquals("London", detail.getPlace());
	}
	
	@Test
	public void TestValidDate() {
		TravelDetail detail = new TravelDetail();
		detail.setDate("2022-02-02");
		assertEquals("2022-02-02", detail.getDate());
	}
}