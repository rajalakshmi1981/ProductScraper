package com.timetravel.travel.model;

/**
 * Model class to keep track of all places and date of travels
 */
public class TravelHistory {

    private String place;
    private String date;

    public TravelHistory(String place, String date) {
        this.place = place;
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
