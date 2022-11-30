package com.airline.userdemo;

import com.airline.userdemo.model.Nationality;
import com.airline.userdemo.model.User;
import com.airline.userdemo.repository.NationalityRepository;
import com.airline.userdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class UserDemoApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

	@Autowired
	NationalityRepository nationalityRepository;


	public static void main(String[] args) {
		SpringApplication.run(UserDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		nationalityRepository.deleteAll();
		userRepository.deleteAll();

		System.out.println("-------------CREATE NATIONALITY ITEMS-------------------------------\n");
		createNationalities();

		System.out.println("-------------CREATE USER ITEMS-------------------------------\n");
		createUsers();

	}

	public void createUsers() {
		System.out.println("Data creation started...");

		userRepository.save(new User("Paco", "Torres", "Spanish", 45));
		userRepository.save(new User("123456","Pepe", "Villuela", "Spanish", 52));
		userRepository.save(new User("Mike", "Smith", "English", 32));
		userRepository.save(new User("012345", "Tom", "Thomson", "English", 29));
		userRepository.save(new User("Gerard", "TypicalFrenchSurname", "French", 64));

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
}
