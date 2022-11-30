package com.airline.demoairline.repository;

import com.airline.demoairline.model.Flight;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface FlightRepository extends MongoRepository<Flight, String> {

    @Query("{airline:'?0'}")
    public List<Flight> findItemByAirline(String airline);

    @Query("{origin:'?0'}")
    public List<Flight> findItemByOrigin(String origin);

    @Query("{destiny:'?0'}")
    public List<Flight> findItemByDestiny(String destiny);

    /*@Query(value = "{ $or: [ { 'title' : {$regex:?0,$options:'i'} }, { 'description' : {$regex:?0,$options:'i'} } ] }")
    Page<Post> query(String query, Pageable page);*/

    @Query(value = "{$and: [ {origin:'?0'},{destiny:'?1'}]}")
    List<Flight> filterByOriginDestiny(String origin, String destiny);

    @Query(value = "{strDate:?0}", sort= "{departure:1}")
    List<Flight> filterByDay(String strDate);

    @Query(value = "{$and [{$and: [{origin:'?0'},{destiny:'?1'}]}, {strDate:?0}]}", sort= "{departure:1}")
    List<Flight> filterByOriginDestinyDay(String origin, String destiny, String date);

}
