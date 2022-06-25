package com.tns.pm.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="college")
public class College{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String collegeName;
	
	private String location;
	
	@OneToMany(mappedBy="college",cascade = CascadeType.ALL)
	private List<Placement> placement;
	
	@OneToMany(mappedBy="college",cascade = CascadeType.ALL)
	private List<Student> student;
	
	@OneToMany(mappedBy="college",cascade = CascadeType.ALL)
	private List<Certificate> certificate;

	@OneToOne(mappedBy="college")
	private User user;

	public College() {
		
	}
	
	public College(Integer id) {
		this.id=id;
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getCollegeName() {
		return collegeName;
	}


	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	@JsonManagedReference
	public List<Placement> getPlacement() {
		return placement;
	}


	public void setPlacement(List<Placement> placement) {
		this.placement = placement;
	}
	
	@JsonManagedReference
	public List<Student> getStudent() {
		return student;
	}


	public void setStudent(List<Student> student) {
		this.student = student;
	}
	
	@JsonManagedReference
	public List<Certificate> getCertificate() {
		return certificate;
	}


	public void setCertificate(List<Certificate> certificate) {
		this.certificate = certificate;
	}
	
	@JsonManagedReference
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

}




