package com.java.jpa.hibernate.app.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.java.jpa.hibernate.app.AppApplication;
import com.java.jpa.hibernate.app.entity.Course;

@SpringBootTest(classes = AppApplication.class)
class CourseRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseRepository repository;

	@Test
	void findById_basic() {
		Course course = repository.findById(10001L);
		assertEquals("JPA in 50 steps", course.getName());
		logger.info("Course: {}", course);
	}

	@Test
	@DirtiesContext
	void deleteById_basic() {
		repository.deleteById(10002L);
		assertNull(repository.findById(10002L));
	}
	
	@Test
	@DirtiesContext
	void save_basic() {
		Course course = repository.findById(10001L);
		course.setName("Microservices in 100 steps");
		repository.save(course);
		assertEquals("Microservices in 100 steps",course.getName());
	}
	
	 
}
