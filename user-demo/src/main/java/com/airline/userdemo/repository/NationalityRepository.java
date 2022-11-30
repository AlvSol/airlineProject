package com.airline.userdemo.repository;

import com.airline.userdemo.model.Nationality;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NationalityRepository extends MongoRepository<Nationality, String> {

}
