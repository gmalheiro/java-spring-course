package com.java.jpa.hibernate.app.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.java.jpa.hibernate.app.AppApplication;
import com.java.jpa.hibernate.app.entity.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@SpringBootTest(classes = AppApplication.class)
class JPQLTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;

	@Test
	void findAll() {
		List<Course> resultList = em.createQuery("Select c From Course c",Course.class).getResultList();
		logger.info("Select c from Course c  -> {}", resultList);
	}
	
	@Test
	void findAll_Typed() {
		TypedQuery<Course> query = em.createQuery("Select c From Course c",Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("Select c from Course c typed -> {}", resultList);
	}
	
	@Test
	void jpql_Where() {
		TypedQuery<Course> query = 
				em.createQuery("Select c From Course c where name like '%steps%' ",Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("Select c from Course c  where -> {}", resultList);
	}
}
