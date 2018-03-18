package com.m2.hibernate.inheritance;

import javax.persistence.Entity;

@Entity
public class MyPerson extends Person {
	  private String company;

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
  
}
