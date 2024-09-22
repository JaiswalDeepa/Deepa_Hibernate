package com.hibernate;
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
	  
		SessionFactory sf =  new MetadataSources(new StandardServiceRegistryBuilder().configure().build())
				.getMetadataBuilder().build().buildSessionFactory();
		
//		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session1 = sf.openSession();
		
		private static void save(Session session) {
		Transaction tx = session.beginTransaction();
		Address address = new Address("GJB", "UP");
		Employee e = new Employee("Deepak" , "Kumar", address);
		session.persist(address);
		session.persist(e);
		tx.commit();
		}
		save(session1);
		Employee em = session1.get(Employee.class, 1);
		System.out.println(em);
	}
}
