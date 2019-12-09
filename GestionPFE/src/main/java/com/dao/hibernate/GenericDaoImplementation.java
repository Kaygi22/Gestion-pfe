package com.dao.hibernate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.dao.base.IGenericDao;

public class GenericDaoImplementation<T, PK extends Serializable> implements IGenericDao<T, PK> {
	
	protected SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	protected Class<?> boClass;

	
	public GenericDaoImplementation(Class<?> pClass){
		boClass = pClass;
	}

	public PK add(T object) {
		Session session = null;
		Transaction transaction = null;
		System.out.println("We got into add object of hibernate implementation");
		PK id = null; // It's necessary to initialize the id
		try {

			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();
			System.out.println("Transactions got started");
			id = (PK) session.save(object);
			transaction.commit();
			System.out.println("Transactions commited");

		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			System.out.println(e.getMessage());
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}

		return id;
	}

	public T getById(PK primaryKey) {
		Session session = null;
		Transaction transaction = null;
		T objectResult = null;

		try {
			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();
			objectResult = (T) session.get(boClass, primaryKey);
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}

		return objectResult;
	}

	public void delete(PK primaryKey) {
		Session session = null;
		Transaction transaction = null;

		try {
			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();
			T objectToDelete = (T) session.get(boClass, primaryKey);
			session.delete(objectToDelete);
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		
	}

	public void update(T object) {
		Session session = null;
		Transaction transaction = null;
		try {

			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();
			session.update(object);
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			System.out.println("Generic Hibernate Dao Impl was rolled back: UPDATING METHOD");
			System.out.println(e);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}

	}

	public List<T> getAll() {
		Session session = null;
		Transaction transaction = null;
		List<T> result = new ArrayList<T>();

		try {
			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();

			/*
			 * try this solution after
			 * sessionFactory.getCurrentSession().createCriteria(T.class).list();
			 */

			CriteriaQuery<T> query = (CriteriaQuery<T>) session.getCriteriaBuilder().createQuery(boClass);
			Root<T> root = (Root<T>) query.from(boClass);
			query.select(root);
			Query<T> q = session.createQuery(query);
			result = q.getResultList();

			transaction.commit();

		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}

		return result;

	}

}
