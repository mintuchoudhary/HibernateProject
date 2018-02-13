package com.m2.hibernate;

 
import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.m2.hibernate.model.Person;

public class CriteriaExampleMain {
  
	public static void main(String[] args) {
      SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
      Session session = sessionFactory.openSession();
      
       Criteria criteria = session.createCriteria(Person.class);  //deprecated
       
    //   CriteriaQuery criteria = session.createCriteria(Person.class);
     //  criteria.add(Restrictions.ge("salary", 17000));   // gt, lt, ilike, between, isNull, isNotNull, isEmpty, isNotEmpty, or, and
    //   criteria.add(Restrictions.like("firstName", "%One%"));
       //criteria.add(Restrictions.isNull("salary"));
       
       criteria.setProjection(Projections.countDistinct("salary"));
       
       /*************************************************Sorting***************************************************/
       criteria.addOrder(Order.desc("salary"));  //asc method can also be used
       
       /*************************************************Pagination************************************************/
       criteria.setFirstResult(0);  // 0 is the first element
       criteria.setMaxResults(10);
       
       //N th higest salary
       
     /*  criteria.setFirstResult(4); // 132
       criteria.setMaxResults(1);*/
       
       /*************************************************Projections & Aggregations********************************/
  /*   criteria.setProjection(Projections.rowCount());
       System.out.println("Total row count= "+criteria.list());
       
       System.out.println("Average salary="+criteria.setProjection(Projections.avg("salary")).list());
       
       System.out.println("To get distinct records="+criteria.setProjection(Projections.countDistinct("firstName")));
       

       System.out.println("To get maximum of a salary="+criteria.setProjection(Projections.max("salary")));

       System.out.println("To get minimum of a salary="+criteria.setProjection(Projections.min("salary")));

       System.out.println("To get sum of a salary="+criteria.setProjection(Projections.sum("salary")));*/
       
       
       List<Person> list = criteria.list();
       Iterator<Person> itr=list.iterator();
       while (itr.hasNext()) {
			Person per = itr.next();
			System.out.print(" " + per.getId());
			System.out.print(" " + per.getFirstName());
			System.out.print(" " + per.getLastName());
			System.out.print(" " + per.getSalary());
			System.out.println();
		}
       
       
 
      // CriteriaBuilder - newly added in Hibernate version
      //CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();      
      //CriteriaQuery<Person> criteriaQuery= criteriaBuilder.createQuery(Person.class);
      // OR
      CriteriaQuery<Person> query =  session.getCriteriaBuilder().createQuery(Person.class);
      query.from(Person.class);
      
      List<Person> list1 = session.createQuery(query).getResultList();
    /*  
      for (Person person : list1) {
		System.out.print(" "+person.getFirstName());
		System.out.print(" "+person.getSalary());System.out.println();
	}*/
      
   
      
      
	}
}
