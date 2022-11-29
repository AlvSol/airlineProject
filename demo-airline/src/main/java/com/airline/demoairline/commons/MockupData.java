package com.airline.demoairline.commons;

import com.airline.demoairline.model.Flight;
import com.airline.demoairline.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.text.ParseException;

@EnableMongoRepositories
public class MockupData {

    @Autowired
    private FlightRepository flightRepository;
    public MockupData() {

    }

    public void createFlights()  {
        try {
            System.out.println("Data creation started...");

            flightRepository.save(new Flight("Madrid", "London", "Ryanair", "2022-11-12", "12:30", "13:50", 0));
            flightRepository.save(new Flight("London", "Madrid", "Ryanair", "2022-13-12", "13:36", "14:42", 0));

            System.out.println("Data creation complete...");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

}
