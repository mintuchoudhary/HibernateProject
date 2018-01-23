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

		Configuration config = new Configuration().configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		// session.save(person);

		session.getTransaction().commit();

		// sessionFactory.close();

		// GEt specific user - load will throw ObjectNotFoundException when not found in DB
		Person allusers = session.load(Person.class, 22);
		System.out.println("Details: id=" + allusers.getId() + " firstname=" + allusers.getFirstName() + " lastname="
				+ allusers.getLastName());

	}

}
