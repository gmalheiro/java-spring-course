package com.spring_database.database_demo.databasedemo.jpa;

import org.springframework.stereotype.Repository;

import com.spring_database.database_demo.databasedemo.entity.Person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PersonJpaRepository {

	@PersistenceContext
	EntityManager entityManager;
	
	public Person findById(int id) {
		return entityManager.find(Person.class, id);
	}
	
	public Person update(Person person) {
		return entityManager.merge(person);
	}

	public Person create(Person person) {
		return entityManager.merge(person);
	}
}
