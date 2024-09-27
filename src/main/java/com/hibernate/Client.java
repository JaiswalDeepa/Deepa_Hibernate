package com.hibernate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import com.hibernate.entity.Address;
import com.hibernate.entity.Employee;

public class Client {

	public static void main(String[] args) {
//		Employee e = new Employee("Nimmi","Female",40000);
//		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure().build();
//		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build(); 
//		SessionFactory sf = meta.buildSessionFactory();
	  
//		SessionFactory sf =  new MetadataSources(new StandardServiceRegistryBuilder().configure().build()).getMetadataBuilder().build().buildSessionFactory();
		
//		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		System.out.println("------------------------");
		SessionFactory sf = HibernateUtill.getSessionFactory();
		Session session1 = sf.openSession();
		save(session1);
		
		
//		Employee em = session1.get(Employee.class, 1);
//		System.out.println(em);
		
//		Address add = session1.get(Address.class, 1);
//		System.out.println(add);
//		System.out.println(add.employee);
	}

	private static void save(Session session) {
		Transaction transaction = session.getTransaction();
		transaction.begin();
		Employee e1 = new Employee();
		e1.setName("Kunal");
		e1.setGender("Male");
		Address a1 = new Address("Sector62", "Noida");
		Address a2 = new Address("Sector63", "Noida");
		Address a3 = new Address("Sector64", "Noida");
		Address a4 = new Address("Sector65", "Noida");
		Address a5 = new Address("Sector66", "Noida");
		session.persist(a1);
		session.persist(a2);
		session.persist(a3);
		session.persist(a4);
		session.persist(a5);
		List<Address> ad = new ArrayList<> ();
		ad.add(a1);
		ad.add(a2);
		ad.add(a3);
		ad.add(a4);
		ad.add(a5);
		e1.setAddress(ad);
		session.persist(e1);
//		address.setEmployee(e);
//		session.persist(address);
//	    session.persist(e);
		transaction.commit();
		
	}
}
