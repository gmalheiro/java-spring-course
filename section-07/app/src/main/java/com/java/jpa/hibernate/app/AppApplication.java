package com.java.jpa.hibernate.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.java.jpa.hibernate.app.repository.CourseRepository;

@SpringBootApplication
public class AppApplication implements CommandLineRunner{
		
	@Autowired
	private CourseRepository courseRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		courseRepository.addReviewsForCourse();
	}

}
