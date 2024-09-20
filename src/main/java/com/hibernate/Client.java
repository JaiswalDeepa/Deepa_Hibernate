package com.hibernate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernate.entity.Employee;

public class Client {

	public static void main(String[] args) {
//		Employee e = new Employee("Tanuja", "Female", 10000);
//		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure().build();
//		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build(); 
//		SessionFactory sf = meta.buildSessionFactory();
	  
		SessionFactory sf =  new MetadataSources(new StandardServiceRegistryBuilder().configure().build()).getMetadataBuilder().build().buildSessionFactory();
		
//		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
//		session.save(e);
		System.out.println("Start------");
		
//		Example of get all the records
		Query query = session.createQuery("From Employee");
		List list = query.list();
		System.out.println(list);
		Query query1 = session.createQuery("select max(name) from Employee");
		List <Integer> list1 = query.list();
		System.out.println(list1.get(0));
	
//		HQL to get records with pegination
		Query query2 = session.createQuery("From Employee");
		query2.setFirstResult(2);
		query2.setMaxResults(4);
		List list2 = query2.list();
		System.out.println("3 to 6"+list2);
		
//		HQL update query using named parameters
		
		Query query3 = session.createQuery("Update Employee set name=:n where id =:i");
		query3.setParameter("n","Vinod");
		query3.setParameter("i",1);
		System.out.println("Status:"+ query3.executeUpdate());
		
//		HQL delete query
		Query query4 = session.createQuery("Delete from Employee where id = 6");
		query4.executeUpdate();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		tx.commit();
		session.close();
		sf.close();
		}

}
