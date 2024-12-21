package com.java.jpa.hibernate.app.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import com.java.jpa.hibernate.app.AppApplication;
import com.java.jpa.hibernate.app.entity.Course;
import com.java.jpa.hibernate.app.entity.Review;

import jakarta.persistence.EntityManager;

@SpringBootTest(classes = AppApplication.class)
class CourseRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseRepository repository;
	
	@Autowired
	EntityManager em;
	
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
		assertEquals("Microservices in 100 steps", course.getName());
	}

	@Test
	@DirtiesContext
	void playWithEntityManager() {
		repository.playWithEntityManager();
	}
	
	@Test
	@Transactional
	void retrieveReviewsFromCourse () {
		Course course = repository.findById(10003L);
		List<Review> reviews = course.getReviews();
		logger.info("test-reviews -> {}" ,reviews);
		//Without the @Transactional annotation this method wouldn't work because
		// in toMany operations is always lazy fetching
	}
	
	@Test
	void retrieveCourseFromReview () {
		Review review = em.find(Review.class,4001L);
		logger.info("test-course-from-review -> {} ", review.getCourse());
		//Without the @Transactional annotation this method works because
		// in toOne operations is always eager fetching
	}
}
