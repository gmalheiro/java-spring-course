package com.java.jpa.hibernate.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "Course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name", nullable = false, length = 255)
	private String name;
	
	@UpdateTimestamp
	private LocalDateTime updateDate;

	@CreationTimestamp
	private LocalDateTime createdDate;
	
	@OneToMany(mappedBy = "course")
	private List<Review> reviews = new ArrayList<Review>();
	
	@ManyToMany(mappedBy = "courses")
	private List<Student> students = new ArrayList<Student>();
	
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
	
	public List<Review> getReviews() {
		return reviews;
	}
	
	public void addReview(Review review) {
		reviews.add(review);
	}
	
	public void removeReview(Review review) {
		reviews.remove(review);
	}
	
	public List<Student> getStudents() {
		return this.students;
	}
	
	public void addStudent(Student student) {
		this.students.add(student);
	}
	
	public void removeStudent (Student student) {
		this.students.remove(student);
	}
	 
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}
	
	
}
