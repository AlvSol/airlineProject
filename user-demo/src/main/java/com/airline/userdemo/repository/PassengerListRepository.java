package com.airline.userdemo.repository;

import com.airline.userdemo.model.PassengerList;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PassengerListRepository extends MongoRepository<PassengerList, Integer> {

}
