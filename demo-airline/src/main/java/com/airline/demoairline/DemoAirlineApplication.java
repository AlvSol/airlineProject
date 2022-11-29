package com.airline.demoairline;

import com.airline.demoairline.commons.MockupData;
import com.airline.demoairline.model.Flight;
import com.airline.demoairline.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.text.ParseException;

@SpringBootApplication
@EnableMongoRepositories
public class DemoAirlineApplication implements CommandLineRunner {

	@Autowired
	FlightRepository flightRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoAirlineApplication.class, args);
		/*MockupData mockupData = new MockupData();
		mockupData.createFlights();*/
	}

	public void run(String... args) {
		flightRepository.deleteAll();

		System.out.println("-------------CREATE GROCERY ITEMS-------------------------------\n");
		createFlights();
		

	}

	public void createFlights()  {
		try {
			System.out.println("Data creation started...");

			flightRepository.save(new Flight("Madrid", "London", "Ryanair", "2022-11-12", "12:30", "13:50", 0));
			flightRepository.save(new Flight("London", "Madrid", "Ryanair", "2022-13-12", "13:36", "14:42", 0));
			flightRepository.save(new Flight("Athens", "Cairo", "Vueling", "2022-07-12", "15:32", "17:40", 1));

			System.out.println("Data creation complete...");
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

}
