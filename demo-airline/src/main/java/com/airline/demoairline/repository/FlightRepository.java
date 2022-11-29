package com.airline.demoairline.repository;

import com.airline.demoairline.model.Flight;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface FlightRepository extends MongoRepository<Flight, String> {

    @Query("{name:'?0'}")
    Flight findItemByName(String name);

}
