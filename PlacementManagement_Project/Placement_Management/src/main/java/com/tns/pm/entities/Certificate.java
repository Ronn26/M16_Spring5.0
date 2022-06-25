package com.tns.pm.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="certificate")
public class Certificate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private int year;
	
	@OneToOne(mappedBy="certificate")
	private Student student;
	
	@ManyToOne
	@JoinColumn(name="college_id")
	private College college;
	
	public Certificate() {
		
	}
	
	public Certificate(Integer id) {
		this.id=id;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	@JsonManagedReference
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	@JsonBackReference
	public College getCollege() {
		return college;
	}
	public void setCollege(College college) {
		this.college = college;
	}

}