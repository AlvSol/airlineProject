package com.airline.demoairline.controller;


import com.airline.demoairline.model.Flight;
import com.airline.demoairline.model.Place;
import com.airline.demoairline.repository.FlightRepository;
import com.airline.demoairline.repository.PlaceRepository;
import com.airline.demoairline.service.FlightServiceAPI;
import com.airline.demoairline.service.FlightServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping(value="/find/airline/{airline}")
    public List<Flight> getByAirline(@PathVariable String airline) {
        return flightRepository.findItemByAirline(airline);
    }

    @GetMapping(value="/allplaces")
    public List<Place> getPlace() {
        return placeRepository.findAll();
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

}
