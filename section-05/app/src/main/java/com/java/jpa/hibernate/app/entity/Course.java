package com.java.jpa.hibernate.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "Course")

@NamedQueries(value = { 
		@NamedQuery(name = "query_get_all_courses", query = "Select c From Course c"),
		@NamedQuery(name = "query_get_step_courses", query = "Select c From Course c where name like '%steps%'")
})

public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false, length = 255)
	private String name;

	@UpdateTimestamp
	private LocalDateTime updateDate;

	@CreationTimestamp
	private LocalDateTime createdDate;

	protected Course() {
		super();
	}

	public Course(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public LocalDateTime getLastUpdated() {
		return updateDate;
	}

	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.updateDate = lastUpdated;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}

}
