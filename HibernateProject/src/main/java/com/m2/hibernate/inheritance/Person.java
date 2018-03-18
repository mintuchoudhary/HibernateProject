package com.m2.hibernate.inheritance;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/*
 * Table for super class will not be created - the properties of this class will be mapped to child class entity
 * */
@MappedSuperclass
public class Person {
	  @Id @GeneratedValue
	    private long personId;
	    private String name;
	    
		public long getPersonId() {
			return personId;
		}
		public void setPersonId(long personId) {
			this.personId = personId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
}
