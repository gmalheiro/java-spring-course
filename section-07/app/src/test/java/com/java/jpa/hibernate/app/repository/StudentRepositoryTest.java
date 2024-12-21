package com.java.jpa.hibernate.app.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.java.jpa.hibernate.app.AppApplication;
import com.java.jpa.hibernate.app.entity.Course;
import com.java.jpa.hibernate.app.entity.Passport;
import com.java.jpa.hibernate.app.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@SpringBootTest(classes = AppApplication.class)
class StudentRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentRepository repository;

	@Autowired 
	EntityManager em;
	
	@Test
	@Transactional
	void retrieveStudentWithPassportSuccessful() {
		Student student = em.find(Student.class,2001);
		logger.info("student -> {}", student);
		logger.info("passport -> {}", student.getPassport());
	}
	
	@Test
	void someDummyTest () {
		repository.operationToUnderstandPersistenceContext();
	}
	
	@Test
	@Transactional
	void retrievePassportWithStudentDetailsSucessful () {
		Passport passport = em.find(Passport.class, 3001L);
		logger.info("passport -> {} ", passport);
		logger.info("student -> {} ", passport.getStudent().getName());
	}
	
	@Test
	@Transactional
	void retrieveCourseFromStudent() {
		Student student = em.find(Student.class,2001L);
		List<Course> courses = student.getCourses();
		logger.info("test-student -> {}", student);
		logger.info("test-student-courses -> {}", courses);
	}
	
	@Test
	@Transactional
	void retrieveStudentFromCourse() {
		Course course = em.find(Course.class, 10001);
		List<Student> students = course.getStudents();
		logger.info("test-course -> {}", course);
		logger.info("test-student -> {}", students);
	}
	
}

