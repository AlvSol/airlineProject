package com.airline.demoairline.controller;


import com.airline.demoairline.model.Flight;
import com.airline.demoairline.service.FlightServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights/api")
@CrossOrigin("*")
public class FlightController {

    @Autowired
    private FlightServiceAPI flightServiceAPI;

    @GetMapping(value="/all")
    public List<Flight> getAll() {
        return flightServiceAPI.getAll();
    }

    @GetMapping(value = "/find/{id}")
    public Flight find(@PathVariable String id) {
        return flightServiceAPI.get(id);
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
