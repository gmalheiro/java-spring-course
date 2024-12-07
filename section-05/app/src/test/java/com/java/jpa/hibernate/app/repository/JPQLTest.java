package com.java.jpa.hibernate.app.repository;

import java.util.List;

import jakarta.persistence.Query;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.java.jpa.hibernate.app.AppApplication;
import com.java.jpa.hibernate.app.entity.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

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
		TypedQuery<Course> query = em.createNamedQuery("query_get_all_courses",Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("Select c from Course c typed -> {}", resultList);
	}
	
	@Test
	void jpql_Where() {
		TypedQuery<Course> query = 
				em.createNamedQuery("query_get_step_courses",Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("Select c from Course c  where -> {}", resultList);
	}

	@Test
	void native_queries_basic() {
		Query query = em.createNativeQuery("SELECT * FROM COURSE",Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("SELECT * FROM COURSE -> {}", resultList);
	}

	@Test
	void native_Queries_Basic_Where() {
		Query query = em.createNativeQuery("SELECT * FROM COURSE WHERE id = ?",Course.class);
		query.setParameter(1,1);
		List result = query.getResultList();
		logger.info("SELECT FROM COURSE WHERE -> {}", result);
	}

	@Test
	void native_Queries_Basic_NamedParameters() {
		Query query = em.createNativeQuery("SELECT * FROM COURSE WHERE id = :id",Course.class);
		query.setParameter("id",1);
		List result = query.getResultList();
		logger.info("SELECT FROM COURSE WHERE NAMED PARAMETERS -> {}", result);
	}

	@Test
	@Transactional
	void native_Queries_Basic_Update() {
		Query query = em.createNativeQuery("UPDATE COURSE set update_date=CURRENT_TIMESTAMP()",Course.class);
		int noOfRowsUpdated = query.executeUpdate();
		logger.info("noOfRowsUpdated-> {}", noOfRowsUpdated);
	}

}
