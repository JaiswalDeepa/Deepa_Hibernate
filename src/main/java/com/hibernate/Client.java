package com.hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Employee;

public class Client {

	public static void main(String[] args) {
		Employee e = new Employee("Nimmi","Female",40000);
//		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure().build();
//		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build(); 
//		SessionFactory sf = meta.buildSessionFactory();
	  
		SessionFactory sf =  new MetadataSources(new StandardServiceRegistryBuilder().configure().build()).getMetadataBuilder().build().buildSessionFactory();
		
//		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(e);
		tx.commit();

	}

}
