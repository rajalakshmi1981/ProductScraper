package com.timetravel.travel.service.exception;

public class PlaceParadoxException extends RuntimeException {
	public PlaceParadoxException() {
		super("Cannot travel to same place again");
	}
}
