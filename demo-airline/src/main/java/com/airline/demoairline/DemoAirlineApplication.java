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

			flightRepository.save(new Flight("Madrid", "London", "Ryanair", "2022-11-12", "12:30", "13:50", 0, 20.0));
			flightRepository.save(new Flight("Athens", "Lisbon", "Air Europa", "2022-10-12", "20:15", "22:12", 0, 22.5));
			flightRepository.save(new Flight("London", "Madrid", "Ryanair", "2022-10-12", "13:36", "14:42", 0, 19.8));
			flightRepository.save(new Flight("Athens", "Lisbon", "Iberia", "2022-10-12", "17:36", "18:42", 0, 23.5));
			flightRepository.save(new Flight("Athens", "Milan", "Vueling", "2022-07-12", "15:32", "17:40", 1, 32));
			flightRepository.save(new Flight("Athens", "Lisbon", "Qatar Airlines", "2022-10-12", "08:03", "10:20", 0, 90));

			System.out.println("Data creation complete...");

		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

}
