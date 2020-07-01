package com.timetravel.travel.model;

public class TravelDetail {

	private String pgi;
	private String place;
	private String date;

	public String getPgi() {
		return pgi;
	}

	public void setPgi(String pgi) {
		if (pgi == null || pgi.isEmpty()) {
			throw new IllegalArgumentException("Personal Galactic Identifier cannot be null");
		}

		this.pgi = pgi;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		if (place == null || place.isEmpty()) {
			throw new IllegalArgumentException("Place cannot be null");
		}

		this.place = place;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		if (date == null || date.isEmpty()) {
			throw new IllegalArgumentException("Please provide valid date of travel");
		}

		this.date = date;
	}
}