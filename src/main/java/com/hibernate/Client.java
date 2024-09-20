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
//		Employee e = new Employee("Vinod","Male",40000);
//		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure().build();
//		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build(); 
//		SessionFactory sf = meta.buildSessionFactory();
	  
		SessionFactory sf =  new MetadataSources(new StandardServiceRegistryBuilder().configure().build()).getMetadataBuilder().build().buildSessionFactory();
		
//		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
//		 TypedQuery<Employee> query =session.createNamedQuery("Employee.findEmployeeById",Employee.class);    
		 Query<Employee> query =session.createNamedQuery("Employee.FindEmployeeById",Employee.class);    
		 query.setParameter("id",4);      
		 List<Employee> employees=query.getResultList();
		 System.out.println(employees);
	
		 System.out.println();

		 Query query2 = session.createNamedQuery("Employee.FindEmployeeByGender");
		 query2.setParameter("gender", "Male");
		 List employees2 = query2.list();
		 System.out.println(employees2);
//		session.save(e);
		tx.commit();

	}

}
