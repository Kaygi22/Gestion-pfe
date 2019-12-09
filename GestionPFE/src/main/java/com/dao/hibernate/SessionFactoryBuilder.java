package com.dao.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryBuilder {

	 private static final SessionFactory sessionFactory= SessionFactoryBuilder.buildSessionFactory();
	  
	   public static SessionFactory buildSessionFactory(){
	        try {
	            return new Configuration().configure().buildSessionFactory();
	        } catch (Throwable ex) {
	            System.err.println("Initial SessionFactory creation failed." + ex);
	            throw new ExceptionInInitializerError(ex);
	        }
	    }
	  
	    public static SessionFactory getSessionFactory() {
	        return sessionFactory;
	}
}
