package com.spring_database.database_demo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring_database.database_demo.databasedemo.entity.Person;
import com.spring_database.database_demo.databasedemo.jpa.PersonJpaRepository;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJpaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("User id 1001 -> {}",repository.findById(1001));
		logger.info("Insert user  -> {}", repository.insert(new Person("Naruto","Konoha",new Date())));
		logger.info("Update user  -> {}", repository.update(new Person(1002,"Ayrton","Brasil",new Date())));
		repository.deleteById(1001);
	}

}
