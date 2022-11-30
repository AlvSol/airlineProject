package com.airline.demoairline.model;


import com.airline.demoairline.auxiliar.TimeAux;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.joda.time.LocalTime;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Flight {

    @Id
    private String id;

    private String origin;
    private String destiny;
    private String airline;

    //@DateTimeFormat(pattern= "yyyy-MM-dd")
    @DateTimeFormat(pattern= "dd-MM-yyyy")
    private Date date;

    private String strDate;

    private String departure;
    private Long departureSecs;


    private String arrival;
    private Long arrivalSecs;
    private int scales;

    private double price;

    public Flight() {

    }

    public Flight(String origin, String destiny, String airline, String date, String departure, String arrival, int scales, double price) throws ParseException {
        this.origin = origin;
        this.destiny = destiny;
        this.airline = airline;

        this.date = new SimpleDateFormat("dd-MM-yyyy").parse(date);
        Format f = new SimpleDateFormat("dd-MM-yyyy");
        this.strDate = f.format(this.date);

        this.departure = departure;
        this.arrival = arrival;
        this.scales = scales;
        this.price = price;

        TimeAux timeAux = new TimeAux();
        this.departureSecs = timeAux.hourToSeconds(departure);
        this.arrivalSecs = timeAux.hourToSeconds(arrival);
    }

    public Flight(String id, String origin, String destiny, String airline, String date, String departure, String arrival, int scales, double price) throws ParseException {
        this.id = id;
        this.origin = origin;
        this.destiny = destiny;
        this.airline = airline;

        this.date = new SimpleDateFormat("dd-MM-yyyy").parse(date);
        Format f = new SimpleDateFormat("dd-MM-yyyy");
        this.strDate = f.format(this.date);

        //this.departure = new SimpleDateFormat("HH:mm").parse(departure);
        //this.arrival = new SimpleDateFormat("HH:mm").parse(arrival);
        this.departure = departure;
        this.arrival = arrival;

        this.scales = scales;
        this.price = price;

        TimeAux timeAux = new TimeAux();
        this.departureSecs = timeAux.hourToSeconds(departure);
        this.arrivalSecs = timeAux.hourToSeconds(arrival);
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

    public Date getDate() {
        return date;
    }

    public String getStrDate() {
        return strDate;
    }

    public void setDate(String date) throws ParseException {
        this.date = new SimpleDateFormat("dd-MM-yyyy").parse(date);
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getDepartureSecs() {
        return departureSecs;
    }

    public void setDepartureSecs(Long departureSecs) {
        this.departureSecs = departureSecs;
    }

    public Long getArrivalSecs() {
        return arrivalSecs;
    }

    public void setArrivalSecs(Long arrivalSecs) {
        this.arrivalSecs = arrivalSecs;
    }

    @Override
    public boolean equals(Object obj) {

        if(obj.getClass() != Flight.class)
            return false;

        return this.id.equals(((Flight) obj).id);
    }
}
