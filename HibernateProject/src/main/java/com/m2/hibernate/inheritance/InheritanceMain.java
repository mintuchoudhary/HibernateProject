package com.m2.hibernate.inheritance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InheritanceMain {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();
		 Transaction tx= session.beginTransaction();

	/*	MyPerson myperson = new MyPerson();
		myperson.setName("Mintu");
		myperson.setCompany("Netcracker");

		session.save(myperson);*/
		// tx.commit();

		/**************************************************************************************************/
		// Transaction tx2 = session.beginTransaction();
		MyProduct product = new MyProduct();
		product.setName("Stationary");

		Book book = new Book();
		book.setName("ProgramingInOneGO");
		book.setAuthor("Mintu");

		Pen pen = new Pen();
		pen.setName("Renolds");
		pen.setColor("blue");
	
		 session.save(product);
		session.save(book);
		session.save(pen);

		session.getTransaction().commit();
		session.close();
		
		tx.rollback();
	}
}
