package com.vti.datalayer;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.boot.model.source.internal.hbm.RootEntitySourceImpl;
import org.hibernate.query.Query;

import Ultis.HibernateUtil;
import entity.A;
import entity.Account;
import entity.Department;
import entity.Exam;
import entity.Question;

public class AccountRepository {
	
	public List<Account> getAll(int page, int size) {
		Session session = null;
		try {
			session = HibernateUtil.getFactory().openSession();
			Query<Account> query = session.createQuery("FROM Account");
			int offset = (page - 1) * size;
			int limit = size;

			query.setFirstResult(offset);
			query.setMaxResults(limit);
			return query.list();
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

	public Exam getExamById(int id) {
		Session session = null;
		try {
			session = HibernateUtil.getFactory().openSession();
			// String hqlString = "FROM Account AS a WHERE a.id = :idAcc";
			// Query<Account> query = session.createQuery(hql);
			// query.setParameter("idAcc", id);
			String hql = "FROM Exam AS a WHERE a.id =?1";
			Query<Exam> query = session.createQuery(hql);
			query.setParameter(1, id);
			return query.uniqueResult();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Question getQuestionById(int id) {
		Session session = null;
		try {
			session = HibernateUtil.getFactory().openSession();
			// String hqlString = "FROM Account AS a WHERE a.id = :idAcc";
			// Query<Account> query = session.createQuery(hql);
			// query.setParameter("idAcc", id);
			String hql = "FROM Question AS a WHERE a.id =?1";
			Query<Question> query = session.createQuery(hql);
			query.setParameter(1, id);
			return query.uniqueResult();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Account getAccountById(int id) {
		Session session = null;
		try {
			String hql = "FROM Account AS a WHERE a.id =?1";
			Query<Account> query = session.createQuery(hql);
			query.setParameter(1, id);
			return query.uniqueResult();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
//	private<T> Root<T> createCriterial(Class<T> className){
//		Session session = HibernateUtil.getFactory().openSession();
//		CriteriaBuilder cb = session.getCriteriaBuilder();
//		CriteriaQuery<T> cr = cb.createQuery(className);
//		Root<T> root = cr.from(className);
//		return root;
//	}

	/*Criterial*/
	public Account getAccByIdUsingCriterial(int id, String userName) {
		Session session = null;
		try {
			session = HibernateUtil.getFactory().openSession();
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<Account> cr = cb.createQuery(Account.class);
			Root<Account> root = cr.from(Account.class);

			Predicate predicateForID = cb.equal(root.get("id"), id);
			Predicate predicateForName = cb.equal(root.get("UserName"), userName);
			Predicate predicate = cb.or(predicateForID, predicateForName);

			cr.select(root).where(predicate);

			Query<Account> query = session.createQuery(cr);
			Account account = query.getSingleResult();
			return account;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public boolean deleteAccountById(int id) {
		Session session = HibernateUtil.getFactory().openSession();
		try {
			session.beginTransaction();// get session
			Account account = (Account) session.load(Account.class, id);// getid
			session.delete(account);// delete
			session.getTransaction().commit();
			return true;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public List<A> getAllA() {
		Session session = HibernateUtil.getFactory().openSession();

		Query<A> query = session.createQuery("FROM A");

		return query.list();
	}

}
