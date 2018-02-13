package com.m2.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.m2.hibernate.model.Certificates;
import com.m2.hibernate.model.Person;
import com.m2.hibernate.model.Project;
import com.m2.hibernate.model.University;
import com.m2.hibernate.model.Vehicle;

public class MappingMain {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction(); /**/
	
		/***********************************One to One Mapping**********************************************/
	    Person person = new Person();
		person.setFirstName("One2One Firstname");
		person.setLastName("One2One Lastname");
		person.setSalary(10000);

		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Pulsar 220");

		person.setVehicle(vehicle);  //For mapping
 	
	 	session.save(person);
	 	session.save(vehicle);
		/***********************************One to Many Mapping**********************************************/		
	 	
	/*	ArrayList<Certificates> list= new ArrayList<Certificates>();
		Certificates certificate1 = new Certificates();
		Certificates certificate2 = new Certificates();
		certificate1.setCertName("Master Degree");
		certificate2.setCertName("Diploma Degree");
		list.add(certificate1);
		list.add(certificate2);

		Person person1 = new Person();
		person1.setFirstName("One2Many11 Firstname");
		person1.setLastName("One2Many Lastname");
		person1.setSalary(10000);
		
		person1.setCertificates(list);
	
	 	session.save(person1);
	 	session.save(certificate1);
	 	session.save(certificate2); */
	 
		/***********************************Many to One Mapping**********************************************/
/*		University university = new University();
		university.setName("Pune University");
		university.setCountry("India");
		
		Person person2= new Person(); 
		Person person3= new Person();
		
		person2.setFirstName("ManyToOne Person2");
		person2.setLastName("ManyToOne Person2");
		person2.setSalary(15000);
		person2.setUniversity(university);
		
		person3.setFirstName("ManyToOne Person3");
		person3.setLastName("ManyToOne Person3");
		person3.setSalary(17000);
		person3.setUniversity(university);*/
		
	//	session.save(person2);
	//	session.save(person3);
	//	session.save(university);
		
		
		/***********************************Many to Many Mapping**********************************************/
/*		List<Person> personall= new ArrayList<Person>();
		
		
		Person personM2M= new Person();
		Person personM2M2= new Person();
		
		personM2M.setFirstName("ManyToMany Person1");
		personM2M.setLastName("ManyToMany Person1");
		personM2M.setSalary(15000); 
		
		personM2M2.setFirstName("ManyToMany Person2");
		personM2M2.setLastName("ManyToMany Person2");
		personM2M2.setSalary(17000);
		
		personall.add(personM2M);
		personall.add(personM2M2);
		
		Project project1=new Project("Project 1");
		Project project2=new Project("Project 2");
		
		project1.setPerson(personall);
		project2.setPerson(personall);
		
		session.save(personM2M);
		session.save(personM2M2);
		session.save(project1);
		session.save(project2);*/
		
		tx.commit();
	    session.close();
	}
}
