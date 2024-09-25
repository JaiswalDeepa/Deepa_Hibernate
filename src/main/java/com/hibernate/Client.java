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
		Employee e = new Employee();
		e.setFirstName("Kunal");
		e.setLastName("sharma");
		Address address = new Address("GZB", "UP");
		e.setAddress(address);
//		address.setEmployee(e);
//		session.persist(address);
		session.persist(e);
		transaction.commit();
		
	}
}
