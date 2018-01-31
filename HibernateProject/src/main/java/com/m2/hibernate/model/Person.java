package com.m2.hibernate.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "p")
@Table(name = "person")
public class Person {

	@Id
	@GeneratedValue
	private int id;
	@Column(name = "firstname")
	private String firstName;
	@Column(name = "lastname")
	private String lastName;
	@Column(name = "sal")
	private int salary;

	@OneToOne
	@JoinColumn(name = "vehicle_id") // To change colum name created in person table as vehicle_id (default : vehicle_vehicleId) 
	private Vehicle vehicle;

	@OneToMany(fetch=FetchType.LAZY)
	//@JoinTable(name="per_cert")  //To give new name to third table
	//@JoinTable(joinColumns=@JoinColumn(name="person_id",referencedColumnName="id"),inverseJoinColumns=@JoinColumn(name="user_cert_id",referencedColumnName="certId"))
	//To rename columns of newly created table. inverseJoinColumns is used for 
	private Collection<Certificates> certificates;
	
	@ManyToOne
	@JoinColumn(name="UNIVERSITY_ID")
	private University university;

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	public Collection<Certificates> getCertificates() {
		return certificates;
	}

	public void setCertificates(Collection<Certificates> certificates) {
		this.certificates = certificates;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Person() {
	}

	public Person(String fname, String lname, int salary) {
		this.firstName = fname;
		this.lastName = lname;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String first_name) {
		this.firstName = first_name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String last_name) {
		this.lastName = last_name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
}