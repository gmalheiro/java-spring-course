package com.java.jpa.hibernate.app.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.java.jpa.hibernate.app.entity.Course;
import com.java.jpa.hibernate.app.entity.Passport;
import com.java.jpa.hibernate.app.entity.Student;

import jakarta.persistence.EntityManager;

@Repository
@Transactional

public class StudentRepository {

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
	
	public void operationToUnderstandPersistenceContext() {
		//Database operation 1 - Retrieve student in db
		Student student = em.find(Student.class, 2001);
		//Persistence context (student)
		
		//Db operation 2 - Retrieve passport
		Passport passport = student.getPassport();
		//Persistence context (student,passport)
		
		//Db operation 3 - Update passport
		passport.setNumber("E123457");
		//Persistence context (student, passport++)
		
		//Db operation 4 - Update student
		student.setName("Gabriel - updated");
		//Persistence context (student++,passport++)
	}
	
	public void addStudentWithCourse(Student student,Course course) {
		student.addCourse(course);
		course.addStudent(student);
		em.persist(student);
		em.persist(course);
	}
	
}
