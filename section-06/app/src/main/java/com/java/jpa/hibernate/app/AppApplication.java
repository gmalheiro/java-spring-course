package com.java.jpa.hibernate.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.java.jpa.hibernate.app.entity.Course;
import com.java.jpa.hibernate.app.repository.CourseRepository;
import com.java.jpa.hibernate.app.repository.StudentRepository;

@SpringBootApplication
public class AppApplication implements CommandLineRunner{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Course course = repository.findById(10001L);
//		logger.info("Course 10001 - {} ",course);
		//repository.deleteById(10002L);
//		repository.save(new Course("Microservices in 100 steps"));
//		repository.playWithEntityManager();
		studentRepository.saveStudentWithPassport();
	}

}
