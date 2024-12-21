package com.java.jpa.hibernate.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.java.jpa.hibernate.app.entity.Course;
import com.java.jpa.hibernate.app.entity.Review;
import com.java.jpa.hibernate.app.entity.Student;
import com.java.jpa.hibernate.app.repository.CourseRepository;
import com.java.jpa.hibernate.app.repository.StudentRepository;

@SpringBootApplication
public class AppApplication implements CommandLineRunner{
		
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Review> reviews = new ArrayList<Review>();
		reviews.add(new Review("5", "Great hands-on stuff"));
		reviews.add(new Review("5", "Hatsoff"));
		courseRepository.addReviewsForCourse(10003L, reviews);
		studentRepository.addStudentWithCourse(new Student("Jack"),new Course("Microservices in 100 Steps"));
		courseRepository.addCourseWithStudent(new Course("Serverless in 10 steps"),new Student("Lance"));
	}

}
