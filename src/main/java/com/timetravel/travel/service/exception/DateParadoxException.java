package com.timetravel.travel.service.exception;

public class DateParadoxException extends RuntimeException {
	public DateParadoxException() {
		super("Cannot travel back in time");
	}
}
