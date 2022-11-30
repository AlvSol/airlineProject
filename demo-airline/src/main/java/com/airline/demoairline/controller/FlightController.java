package com.airline.demoairline.controller;


import com.airline.demoairline.auxiliar.DateListFilters;
import com.airline.demoairline.model.Flight;
import com.airline.demoairline.model.Place;
import com.airline.demoairline.repository.FlightRepository;
import com.airline.demoairline.repository.PlaceRepository;
import com.airline.demoairline.service.FlightServiceAPI;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/flights/api")
@CrossOrigin("*")
public class FlightController {

    @Autowired
    private FlightServiceAPI flightServiceAPI;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private PlaceRepository placeRepository;

    @GetMapping(value="/all")
    public List<Flight> getAll() {
        return flightServiceAPI.getAll();
    }

    @GetMapping(value="/allsorted")
    public List<Flight> getAllSortedByDate() {
        return flightRepository.getAllSortedByDate();
    }

    @GetMapping(value="/find/airline/{airline}")
    public List<Flight> getByAirline(@PathVariable String airline) {
        return flightRepository.findItemByAirline(airline);
    }

    @GetMapping(value="/allplaces")
    public List<String> getPlace() {
        List<Place> places = placeRepository.findAll();
        List<String> names = new ArrayList<>();
        for(Place p: places) {
            names.add(p.getName());
        }
        return names;
    }

    @GetMapping(value="/find/origin/{origin}")
    public List<Flight> getByOrigin(@PathVariable String origin) {
        return flightRepository.findItemByOrigin(origin);
    }

    @GetMapping(value="/find/destiny/{destiny}")
    public List<Flight> getByDestiny(@PathVariable String destiny) {
        return flightRepository.findItemByDestiny(destiny);
    }

    @GetMapping(value = "/find/{id}")
    public Flight find(@PathVariable String id) {
        return flightServiceAPI.get(id);
    }

    @GetMapping(value = "/travel/{origin}/{destiny}")
    public List<Flight> findByOriginDestiny(@PathVariable String origin, @PathVariable String destiny) {
        return flightRepository.filterByOriginDestiny(origin, destiny);
    }

    @GetMapping(value = "/travel/{date}")
    public List<Flight> findByOriginDestiny(@PathVariable String date) {
        return flightRepository.filterByDay(date);
    }


    @GetMapping(value = "/travel/{origin}/{destiny}/{date}")
    public List<Flight> filterByOriginDestinyDay(@PathVariable String origin,
                                                 @PathVariable String destiny,
                                                 @PathVariable String date) {

        return getByOriginDestinyDay(origin, destiny, date);
    }


    @GetMapping(value = "/travel/prueba/{origin}/{destiny}/{date}")
    public List<Flight> getFlightsFromDate(@PathVariable String origin, @PathVariable String destiny, @PathVariable String date) throws ParseException {

            List<Flight> flights = new ArrayList<>(), totalFlights = new ArrayList<>();
            //flights = flightRepository.filterByOriginDestinyDay(origin, destiny, date);

            DateListFilters dateListFilters = new DateListFilters();
            Date dateInfo = new SimpleDateFormat("yyyy-MM-dd").parse(date);

            //Obtengo los dias a añadir mas los 3 siguientes
            int n = dateListFilters.getDays(dateInfo);
            Date fromDate = dateListFilters.subtractDays(dateInfo, 3);
            Date toDate = dateListFilters.addDays(dateInfo, n+3);

            List<Date> dateList = dateListFilters.getDatesBetweenUsingJava7(fromDate, toDate);
            for (Date ditem: dateList) {

                flights.clear();

                Format f = new SimpleDateFormat("yyyy-MM-dd");
                String strDate = f.format(ditem);

                flights = getByOriginDestinyDay(origin, destiny, strDate);
                totalFlights.addAll(flights);
            }


        return totalFlights;
    }


    public List<Flight> getByOriginDestinyDay(String origin, String destiny, String date) {

        List<Flight> filtered = new ArrayList<Flight>();
        List<Flight> list1 = flightRepository.filterByOriginDestiny(origin, destiny);
        List<Flight> list2 = flightRepository.filterByDay(date);

        for (Flight flight1 : list1) {
            for (Flight flight2 : list2) {
                if (flight1.equals(flight2)) {
                    filtered.add(flight1);
                    break;
                }
            }
        }

        return filtered;
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Flight> save(@RequestBody Flight flight) {
        Flight obj = flightServiceAPI.save(flight);
        return new ResponseEntity<Flight>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<Flight> delete(@PathVariable String id) {
        Flight obj = flightServiceAPI.get(id);
        if(obj != null) {
            flightServiceAPI.delete(id);
        } else {
            return new ResponseEntity<Flight>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<Flight>(obj, HttpStatus.OK);
    }



    //--------------Auxiliar----------------------

    /*public List<Flight> orderByHour(List<Flight> flights) {
        Quicksort quicksort = new Quicksort();
        quicksort.quick(flights, 0, flights.size()-1);
    }*/

}
