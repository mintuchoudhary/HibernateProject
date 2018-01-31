package com.m2.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/*
 * One to Many Mapping
 * 
 * */

@Entity
public class Certificates {
	@Id
	@GeneratedValue
	private int certId;
	private String certName;
	
 
	public int getCertId() {
		return certId;
	}

	public void setCertId(int certId) {
		this.certId = certId;
	}

	public String getCertName() {
		return certName;
	}

	public void setCertName(String certName) {
		this.certName = certName;
	}
}
