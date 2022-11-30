package com.airline.demoairline.auxiliar;

import com.airline.demoairline.model.Flight;
import com.airline.demoairline.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@EnableMongoRepositories
public class DateListFilters {

    private static final DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    private Date currentDate;

    @Autowired
    FlightRepository flightRepository;

    public DateListFilters() {
        this.currentDate = new Date();
    }

    public Date addDays(Date date, int days) {

        if(date.compareTo(currentDate) < 0)
            date = currentDate;

        Calendar c = Calendar.getInstance();
        c.setTime(date);

        c.add(Calendar.DATE, days);
        Date newdate = c.getTime();

        /*for(int i = 1; i <= days; i++) {
            c.add(Calendar.DATE, i); //same with c.add(Calendar.DAY_OF_MONTH, 1);
            datePlusOne = c.getTime();
            listDays.add(datePlusOne);
        }*/

        return newdate;
    }


    public Date subtractDays(Date date, int days) {

        if(date.compareTo(currentDate) < 0)
            return currentDate;

        Calendar c = Calendar.getInstance();
        c.setTime(date);

        c.add(Calendar.DATE, -days);
        Date newdate = c.getTime();

        return newdate;
    }


    //Si faltan dias anteriores a fecha se suman a dias posteriores a fecha
    public int getDays(Date date) {

        int n = 3;

        if(date.compareTo(currentDate) < 0)
            return 3;

        Calendar c = Calendar.getInstance();
        c.setTime(date);

        Date dateMinusOne;
        String strDate;
        List<Date> listDays = new ArrayList<Date>();
        List<Flight> flights;

        for(int i = 1; i <= 3; i++) {
            c.add(Calendar.DATE, -i); //same with c.add(Calendar.DAY_OF_MONTH, 1);

            dateMinusOne = c.getTime();

            strDate = dateFormat.format(dateMinusOne);
            flights = this.flightRepository.filterByDay(strDate);

            //Si hay vuelo ese dia no se añade a los dias posteriores
            if(!flights.isEmpty()) {
                listDays.add(dateMinusOne);
                n--;
            }
        }

        return n;
    }
    

}