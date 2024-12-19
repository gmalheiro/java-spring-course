package com.java.jpa.hibernate.app.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.java.jpa.hibernate.app.AppApplication;
import com.java.jpa.hibernate.app.entity.Student;

import jakarta.persistence.EntityManager;

@SpringBootTest(classes = AppApplication.class)
class StudentRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentRepository repository;

	@Autowired 
	EntityManager em;
	
	@Test
	void retrieveStudentWithPassportSuccessful() {
		Student student = em.find(Student.class,2001);
		logger.info("student -> {}", student);
		logger.info("passport -> {}", student.getPassport());
	}
}

