package com.m2.hibernate;

import java.util.List;

//import javax.persistence.Query;
import org.hibernate.query.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.m2.hibernate.model.Person;

public class HQLExampleMain {
	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();
/*
 * session.createSQLQuery(stringSql) is used for Native Query
 * */
		// Where clause
		String hql = "FROM p WHERE id = 70"; // p is @entity name
		List<Person> results = session.createQuery(hql).list();
		System.out.println(results);

		// Order By
		String hql2 = "FROM p WHERE id > 70 ORDER BY salary DESC";
		List results2 = session.createQuery(hql2).list();
		System.out.println(results2);
		// Group By
		String hql3 = "SELECT sum(sal), firstName FROM p " + "GROUP BY firstName";
		// List results3 = session.createQuery(hql3).list();

		// Named parameter
		String hql4 = "FROM p WHERE id = :p_id";
		Query query4 = session.createQuery(hql4);
		query4.setParameter("p_id", 70);
		List result4 = query4.list();
		System.out.println(result4);

		// Update clause
		String hql5 = "UPDATE p set sal = :salary " + "WHERE id = :p_id";
		Query query5 = session.createQuery(hql5);
		query5.setParameter("salary", 1000);
		query5.setParameter("p_id", 10);
		int result5 = query5.executeUpdate();
		System.out.println("UPdate - Rows affected: " + result5);

		// Delete clause
		String hql6 = "DELETE FROM p " + "WHERE id = :p_id";
		Query query6 = session.createQuery(hql6);
		query6.setParameter("p_id", 10);
		int result6 = query6.executeUpdate();
		System.out.println("Delete - Rows affected: " + result6);

		// Insert clause

		String hql7 = "INSERT INTO p (firstName, lastName, salary)"
				+ " values ('HQLFirstname','HQLLastname',30000)";
		Query query7 = session.createQuery(hql7);
		int result7 = query7.executeUpdate();
		System.out.println("Insert - Rows affected: " + result7);
		
		tx.commit();
	}
}
