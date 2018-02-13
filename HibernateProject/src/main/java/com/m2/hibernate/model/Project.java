package com.m2.hibernate.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/*
 * Many to Many Mapping
 * 
 * */
@Entity
public class Project {
    @Id @GeneratedValue
	private int projectId;
    private String projectName;
    @ManyToMany
    Collection<Person> person;
    
    Project(){ }
    public Project(String projectName) {
		super();
		this.projectName = projectName;
	}
	 
	public Collection<Person> getPerson() {
		return person;
	}

	public void setPerson(Collection<Person> person) {
		this.person = person;
	}

	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
}
