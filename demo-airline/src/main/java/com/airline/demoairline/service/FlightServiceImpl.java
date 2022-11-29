package com.airline.demoairline.service;

import com.airline.demoairline.commons.GenericServiceImpl;
import com.airline.demoairline.model.Flight;
import com.airline.demoairline.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImpl extends GenericServiceImpl<Flight, String> implements FlightServiceAPI{

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public CrudRepository<Flight, String> getDao() {
        return flightRepository;
    }
}
