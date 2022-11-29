package com.airline.demoairline.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.joda.time.LocalTime;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Flight {

    @Id
    private String id;

    private String origin;
    private String destiny;
    private String airline;

    @DateTimeFormat(pattern= "yyyy-MM-dd")
    private Date date;


    private String departure;


    private String arrival;
    private int scales;

    public Flight() {

    }

    public Flight(String origin, String destiny, String airline, String date, String departure, String arrival, int scales) throws ParseException {
        this.origin = origin;
        this.destiny = destiny;
        this.airline = airline;
        this.date = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        this.departure = departure;
        this.arrival = arrival;
        this.scales = scales;
    }

    public Flight(String id, String origin, String destiny, String airline, String date, String departure, String arrival, int scales) throws ParseException {
        this.id = id;
        this.origin = origin;
        this.destiny = destiny;
        this.airline = airline;
        this.date = new SimpleDateFormat("yyyy-MM-dd").parse(date);

        //this.departure = new SimpleDateFormat("HH:mm").parse(departure);
        //this.arrival = new SimpleDateFormat("HH:mm").parse(arrival);
        this.departure = departure;
        this.arrival = arrival;

        this.scales = scales;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestiny() {
        return destiny;
    }

    public void setDestiny(String destiny) {
        this.destiny = destiny;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getDate() {
       /* DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String strDate = dateFormat.format(date);*/

        return date.toString();
    }

    public void setDate(String date) throws ParseException {
        this.date = new SimpleDateFormat("yyyy-MM-dd").parse(date);
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public int getScales() {
        return scales;
    }

    public void setScales(int scales) {
        this.scales = scales;
    }

}
