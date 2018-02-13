package com.m2.hibernate;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.m2.hibernate.model.Person;

public class SecondLevelCacheMain {

	public static void main(String[] args) {
		Person person = new Person();

		person.setFirstName("firstname");
		person.setLastName("HbmLastname");
		person.setSalary(100000);

		Configuration config = new Configuration().configure();
		SessionFactory sessionFactory = config.buildSessionFactory();		
		Session session = sessionFactory.openSession();
		Session session1 = sessionFactory.openSession();
		
 
		Transaction tx = session.beginTransaction();
		Transaction tx1 = session1.beginTransaction();
       /***********************************Second level cache check**********************************************/
		  session.save(person);

		  
	 	Person singleuser = session.get(Person.class, 67);
 
	 	Person singleuser1 = session1.get(Person.class, 67);  //this should not execute select query again .. for 2nd level cache
	 	 
		try {
			singleuser.setFirstName("Mintu");
			singleuser1.setLastName("Choudhary");

			tx.commit();
			tx1.commit();
		} catch (HibernateException e) {
			if (Objects.isNull(tx))
				tx.rollback();
			    tx1.rollback();
			e.printStackTrace();
		}
	}
}
