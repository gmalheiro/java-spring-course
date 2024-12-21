package com.java.jpa.hibernate.app.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.java.jpa.hibernate.app.entity.Course;
import com.java.jpa.hibernate.app.entity.Review;

import jakarta.persistence.EntityManager;

@Repository
@Transactional
public class CourseRepository {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private EntityManager em;

	public Course findById(Long id) {
		return em.find(Course.class, id);
	}

	public void deleteById(Long id) {
		em.remove(findById(id));
	}

	public Course save(Course course) {
		if (course.getId() == null) {
			em.persist(course);
			return course;
		}
		return em.merge(course);
	}

	public void playWithEntityManager() {

		Course course1 = new Course("Web services in 100 steps");
		em.persist(course1);
		Course course2 = new Course("Angular js in 100 steps");
		em.persist(course2);

		course1.setName("Web services in 100 steps - updated");
		course2.setName("Angular js in 100 steps - updated");

		em.refresh(course1);

		em.flush();

		// while being in the scope of the transactional annotation entity manager keeps
		// track of all the
		// the things that happens to the object that's why by only using
		// the setName it is updating without the use of merge
		// Detach keeps track of only one entity while clear clear all the entities
		// refresh reverts the changes made to an entity: Refresh the state of the
		// instance from the database,
		// overwriting changes made to the entity, if any.
	}

	@Transactional
	public void addHardCodedReviewsForCourse() {
		Course course = em.find(Course.class, 10003L);

		Review review1 = new Review("5", "Great hands-on stuff");
		Review review2 = new Review("5", "Hatsoff");

		course.addReview(review1);
		review1.setCourse(course);

		course.addReview(review2);
		review2.setCourse(course);

		em.persist(review1);
		em.persist(review2);

		logger.info("course.getReviews() -> {} ", course.getReviews());
	}

	@Transactional
	public void addReviewsForCourse(Long courseId, List<Review> reviews) {
		Course course = em.find(Course.class, courseId);
		for (Review review : reviews) {
			course.addReview(review);
			review.setCourse(course);
			em.persist(review);
		}

	}

}
