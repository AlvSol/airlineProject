package com.airline.userdemo;

import com.airline.userdemo.model.Nationality;
import com.airline.userdemo.model.PassengerList;
import com.airline.userdemo.model.User;
import com.airline.userdemo.repository.NationalityRepository;
import com.airline.userdemo.repository.PassengerListRepository;
import com.airline.userdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableMongoRepositories
public class UserDemoApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

	@Autowired
	NationalityRepository nationalityRepository;

	@Autowired
	PassengerListRepository passengerListRepository;


	public static void main(String[] args) {
		SpringApplication.run(UserDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		nationalityRepository.deleteAll();
		userRepository.deleteAll();
		passengerListRepository.deleteAll();

		System.out.println("-------------CREATE NATIONALITY ITEMS-------------------------------\n");
		createNationalities();

		System.out.println("-------------CREATE USER ITEMS-------------------------------\n");
		createUsers();

		System.out.println("-------------CREATE LIST PASSENGERS ITEMS-------------------------------\n");
		createListPassengers();

	}

	public void createUsers() {
		System.out.println("Data creation started...");

		userRepository.save(new User("Paco", "Torres", "Spanish", 3));
		userRepository.save(new User("123456","Pepe", "Villuela", "Spanish", 3));
		userRepository.save(new User("Mike", "Smith", "English", 3));
		userRepository.save(new User("012345", "Tom", "Thomson", "English", 3));
		userRepository.save(new User("Gerard", "TypicalFrenchSurname", "French", 3));


		userRepository.save(new User("Bebesita", "Bebelin", "Spanish", 1));
		userRepository.save(new User("45678","Daniel", "ElTravieso", "Spanish", 2));

		System.out.println("Data creation finished...");
	}


	public void createNationalities() {
		System.out.println("Data creation started...");

		nationalityRepository.save(new Nationality("Spanish"));
		nationalityRepository.save(new Nationality("English"));
		nationalityRepository.save(new Nationality("Italian"));
		nationalityRepository.save(new Nationality("Portuguese"));
		nationalityRepository.save(new Nationality("French"));

		System.out.println("Data creation finished...");
	}

	public void createListPassengers() {
		System.out.println("Data creation started...");

		User user1 = userRepository.findById("123456").get();
		User user2 = userRepository.findById("012345").get();
		User user3 = userRepository.findById("45678").get();
		List<User> listUsers = new ArrayList<>();

		listUsers.add(user1);
		listUsers.add(user2);
		listUsers.add(user3);

		passengerListRepository.save(new PassengerList(0, "FORBIDDEN", listUsers));

		System.out.println("Data creation finished...");
	}

}
