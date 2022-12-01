package com.airline.demoairline;

import com.airline.demoairline.model.Flight;
import com.airline.demoairline.model.Place;
import com.airline.demoairline.repository.FlightRepository;
import com.airline.demoairline.repository.PlaceRepository;
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

	@Autowired
	PlaceRepository placeRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoAirlineApplication.class, args);
		/*MockupData mockupData = new MockupData();
		mockupData.createFlights();*/
	}

	public void run(String... args) {
		placeRepository.deleteAll();
		flightRepository.deleteAll();

		System.out.println("-------------CREATE PLACE ITEMS-------------------------------\n");
		createPlaces();

		System.out.println("-------------CREATE FLIGHT ITEMS-------------------------------\n");
		createFlights();

	}

	public void createPlaces() {
		System.out.println("Place creation started...");

		placeRepository.save(new Place("Madrid"));
		placeRepository.save(new Place("London"));
		placeRepository.save(new Place("Lisbon"));
		placeRepository.save(new Place("Athens"));
		placeRepository.save(new Place("Paris"));
		placeRepository.save(new Place("Milan"));

		System.out.println("Place creation complete...");
	}


	public void createFlights()  {
		try {
			System.out.println("Data creation started...");


			flightRepository.save(new Flight("Madrid", "London", "Ryanair", "2023-01-12", "12:30", "13:50", 0, 20.0));
			flightRepository.save(new Flight("London", "Madrid", "Ryanair", "2023-01-16", "13:30", "14:50", 0, 23.5));
			flightRepository.save(new Flight("Athens", "Milan", "Vueling", "2022-12-15", "10:30", "11:50", 1, 31.0));
			flightRepository.save(new Flight("Paris", "London", "Iberia", "2023-01-07", "06:30", "07:12", 0, 15.2));
			flightRepository.save(new Flight("Lisbon", "Madrid", "Iberia", "2022-12-18", "11:00", "12:03", 0, 17.6));
			flightRepository.save(new Flight("Milan", "Madrid", "Ryanair", "2023-01-05", "16:30", "19:50", 2, 5.3));
			flightRepository.save(new Flight("Athens", "London", "Vueling", "2023-01-23", "10:30", "12:02", 0, 27.0));


			System.out.println("Data creation complete...");

		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

}
