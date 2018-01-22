package com.m2.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person {
	 @Id @GeneratedValue
	 
	   private int id;
	   @Column(name = "firstname")
	   private String firstName; 
	   @Column(name = "lastname")
	   private String lastName;   
	   @Column(name = "salary")
	   private int salary;  

	   public Person() {}
	   public Person(String fname, String lname, int salary) {
	      this.firstName = fname;
	      this.lastName = lname;
	      this.salary = salary;
	   }
	   
	   public int getId() {
	      return id;
	   }
	   
	   public void setId( int id ) {
	      this.id = id;
	   }
	   
	   public String getFirstName() {
	      return firstName;
	   }
	   
	   public void setFirstName( String first_name ) {
	      this.firstName = first_name;
	   }
	   
	   public String getLastName() {
	      return lastName;
	   }
	   
	   public void setLastName( String last_name ) {
	      this.lastName = last_name;
	   }
	   
	   public int getSalary() {
	      return salary;
	   }
	   
	   public void setSalary( int salary ) {
	      this.salary = salary;
	   }
	}