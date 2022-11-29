package com.airline.demoairline.repository;

import com.airline.demoairline.model.Flight;
import com.airline.demoairline.model.Place;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PlaceRepository extends MongoRepository<Place, String> {

    @Query("{name:'?0'}")
    public Place findItemByName(String name);
}
