package com.hibernate.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

public class HibernateConfig {
	
	public static SessionFactory getSessionFactory() {
		Properties ps = new Properties();
		ps.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
		ps.put(Environment.URL, "jdbc:mysql://localhost:3306/mydb");
		ps.put("hibernate.connection.username", "root");
		ps.put(Environment.PASS, "root");
		ps.put(Environment.HBM2DDL_AUTO, "create");
		ps.put(Environment.SHOW_SQL, "true");
		ps.put(Environment.FORMAT_SQL, "true");
		
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().applySettings(ps).build();
		MetadataSources metadataSources = new MetadataSources(ssr);
		Metadata metadata = metadataSources.addAnnotatedClass(com.hibernate.entity.Employee.class).buildMetadata();
		SessionFactory sf = metadata.buildSessionFactory();
		return sf;
		
	}

}
