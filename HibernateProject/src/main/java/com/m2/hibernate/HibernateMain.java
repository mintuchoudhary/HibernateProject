package com.m2.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.m2.hibernate.model.Person;

public class HibernateMain {

	public static void main(String[] args) {
		Person person = new Person();

		person.setFirstName("firstname");
		person.setLastName("HbmLastname");
		person.setSalary(100000);

		Configuration config = new Configuration().configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();
       /***********************************To Save Record**********************************************/
		// session.save(person);

		// session.getTransaction().commit(); OR
		tx.commit();

		// sessionFactory.close();
		
		/***********************************To Get Specific Record**********************************************/
		// load will throw ObjectNotFoundException when not		 
		Person singleuser = session.get(Person.class, 30);
		System.out.println("Details: id=" + singleuser.getId() + " firstname=" + singleuser.getFirstName()
				+ " lastname=" + singleuser.getLastName());

		
		/***********************************To Get ALL Record**********************************************/
		List<Person> allPerson = session.createQuery("from  p").list();
		//List<Person> allPerson1 = session.createCriteria(Person.class).list(); // deprecated way
		
		Iterator<Person> itr = allPerson.iterator();
		while (itr.hasNext()) {
			Person per = itr.next();
			System.out.print(" " + per.getId());
			System.out.print(" " + per.getFirstName());
			System.out.print(" " + per.getLastName());
			System.out.print(" " + per.getSalary());
			System.out.println();
		}

		/***********************************To Update Record**********************************************/
		try {
			tx = session.beginTransaction();
			singleuser.setSalary(17000);

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}

		/***********************************To Delete Record**********************************************/
		
		 tx = session.beginTransaction(); 
		 Person deletePerson = session.get(Person.class, 24); 
         session.delete(deletePerson);
		 tx.commit();
		 
	}

}
