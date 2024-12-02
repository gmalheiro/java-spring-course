package com.java.jpa.hibernate.app.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.jpa.hibernate.app.entity.Course;

import jakarta.persistence.EntityManager;

@Repository
public class CourseRepository {
	
	@Autowired
	private EntityManager em;
	
	public Course findById(Long id) {
		return em.find(Course.class, id);
	}
	
	public void deleteById(Long id) {
		em.remove(em.find(Course.class,id));
	}
	
	public Course insert(Course course) {
		return em.merge(course);
	}
	
}
