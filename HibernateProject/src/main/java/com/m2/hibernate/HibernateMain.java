package com.m2.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateMain {

	public static void main(String[] args) {
		Person person = new Person();

		person.setFirstName("HbmFirstname");
		person.setLastName("HbmLastname");
		person.setSalary(100000);
		
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
	
		session.save(person);
		
		session.getTransaction().commit();
	}
}
