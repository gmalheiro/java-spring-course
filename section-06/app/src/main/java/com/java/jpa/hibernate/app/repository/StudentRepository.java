package com.java.jpa.hibernate.app.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.java.jpa.hibernate.app.entity.Passport;
import com.java.jpa.hibernate.app.entity.Student;

import jakarta.persistence.EntityManager;

@Repository
@Transactional

public class StudentRepository {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private EntityManager em;

	public Student findById(Long id) {
		return em.find(Student.class, id);
	}

	public void deleteById(Long id) {
		em.remove(findById(id));
	}

	public Student save(Student student) {
		if (student.getId() == null) {
			em.persist(student);
			return student;
		}
		return em.merge(student);
	}
	
	public void saveStudentWithPassport () {
		Passport passport = new Passport("Z123456");
		em.persist(passport);
		
		Student student = new Student("Mike");
		
		student.setPassport(passport);
		em.persist(student);
	}
}
