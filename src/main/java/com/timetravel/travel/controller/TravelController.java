package com.timetravel.travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.timetravel.travel.model.TravelDetail;
import com.timetravel.travel.service.TravelService;
import com.timetravel.travel.service.exception.DateParadoxException;
import com.timetravel.travel.service.exception.PlaceParadoxException;

@EnableWebMvc
@RestController
public class TravelController {

	@Autowired
	TravelService ts;

	@RequestMapping(consumes = "application/json", method = RequestMethod.POST, value = "/travel")
	public ResponseEntity<String> timeTravel(@RequestBody TravelDetail travelDetails) {
		try {
			if (ts.validateAndSaveTravel(travelDetails))
				return new ResponseEntity<>("Travel saved successsfully", HttpStatus.OK);
		} catch (PlaceParadoxException pe) {
			return new ResponseEntity<>("Problem in request with Place", HttpStatus.BAD_REQUEST);
		} catch (DateParadoxException de) {
			return new ResponseEntity<>("Problem in request with Date", HttpStatus.BAD_REQUEST);
		} catch (RuntimeException re) {
			return new ResponseEntity<>("Unknow Error Occured in saving Travel", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>("Unknow Error Occured in saving Travel", HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
