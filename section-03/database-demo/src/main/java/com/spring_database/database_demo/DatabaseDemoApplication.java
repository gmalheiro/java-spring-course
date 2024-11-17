package com.spring_database.database_demo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring_database.database_demo.databasedemo.entity.Person;
import com.spring_database.database_demo.databasedemo.jdbc.PersonJdbcDao;

@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJdbcDao dao;

	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All users -> {}", dao.findAll());
		logger.info("User id 1001 -> {}",dao.findById(1001));
		logger.info("All users from London -> {}", dao.findByLocation("London"));
		logger.info("Delete user with id 1001 -> {}", dao.deleteById(1001));
		logger.info("Insert user with id 1004 -> {}", dao.insertPerson(new Person(1004,"Naruto","Konoha",new Date())));
		logger.info("Update user with id 1004 -> {}", dao.updatePerson(new Person(1004,"Ayrton","Brasil",new Date())));
	}

}
