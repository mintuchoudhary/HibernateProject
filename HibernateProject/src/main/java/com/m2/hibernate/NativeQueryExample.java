package com.m2.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.m2.hibernate.model.Person;

public class NativeQueryExample {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		String sql = "SELECT firstname, sal FROM person";
		SQLQuery query = session.createSQLQuery(sql);
		 
		List<Person> results = query.list();

		for (Person person : results) {
			System.out.print(" " + person.getFirstName());
			System.out.print(" " + person.getSalary());
			System.out.println();
		}
	}
}
