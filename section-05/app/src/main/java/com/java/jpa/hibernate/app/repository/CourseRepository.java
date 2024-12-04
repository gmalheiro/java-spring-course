package com.java.jpa.hibernate.app.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.java.jpa.hibernate.app.entity.Course;

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
		
		
		//while being in the scope of the transactional annotation entity manager keeps track of all the 
		// the things that happens to the object that's why by only using 
		// the setName it is updating without the use of merge
		// Detach keeps track of only one entity while clear clear all the entities
		// refresh reverts the changes made to an entity: Refresh the state of the instance from the database, 
		// overwriting changes made to the entity, if any.
	}

}
