package com.timetravel.travel.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.stereotype.Service;

import com.timetravel.travel.model.TravelDetail;
import com.timetravel.travel.model.TravelHistory;
import com.timetravel.travel.service.exception.DateParadoxException;
import com.timetravel.travel.service.exception.PlaceParadoxException;

@Service
public class TravelService {

	private static ConcurrentMap<String, Stack<TravelHistory>> dataMap = new ConcurrentHashMap<>();

	public boolean validateAndSaveTravel(TravelDetail travelDetail) throws PlaceParadoxException, DateParadoxException {

		Stack<TravelHistory> stack = dataMap.getOrDefault(travelDetail.getPgi(), new Stack<TravelHistory>());
		TravelHistory TravelHistory = validateTravelDetails(travelDetail, stack);
		stack.add(TravelHistory);

		dataMap.put(travelDetail.getPgi(), stack);
		return true;
	}

	private TravelHistory validateTravelDetails(TravelDetail travelDetail, Stack<TravelHistory> history)
			throws PlaceParadoxException, DateParadoxException {
		if (!history.empty()) {
			if (isTravellingToSamePlace(travelDetail, history.peek())) {
				throw new PlaceParadoxException();
			} else if (isTravellingToBackDate(travelDetail, history.peek())) {
				throw new DateParadoxException();
			}
		}

		return new TravelHistory(travelDetail.getPlace(), travelDetail.getDate());
	}

	private boolean isTravellingToSamePlace(TravelDetail travelDetail, TravelHistory travelHistory) {
		return travelDetail.getPlace().toLowerCase().equals(travelHistory.getPlace().toLowerCase());
	}

	private boolean isTravellingToBackDate(TravelDetail travelDetail, TravelHistory travelHistory) {

		LocalDate detailDate = LocalDate.parse(travelDetail.getDate());
		LocalDate statisticsDate = LocalDate.parse(travelHistory.getDate());
		return statisticsDate.isAfter(detailDate);

	}
}
