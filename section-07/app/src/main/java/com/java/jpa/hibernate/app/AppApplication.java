package com.java.jpa.hibernate.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.java.jpa.hibernate.app.entity.Review;
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
		List<Review> reviews = new ArrayList<Review>();
		reviews.add(new Review("5", "Great hands-on stuff"));
		reviews.add(new Review("5", "Hatsoff"));
		courseRepository.addReviewsForCourse(10003L, reviews);
	}

}
