package com.vti.datalayer;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import Ultis.HibernateUtil;
import entity.Account;
import entity.Department;

public class DepartmentRepository {
	public List<Department> getAllDp(int page, int size) {
		Session session = null;
		try {
			session = HibernateUtil.getFactory().openSession();
			Query<Department> query = session.createQuery("FROM Department");
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

	public boolean deleteDepartmentById(int id) {
		Session session = HibernateUtil.getFactory().openSession();
		try {
			session.beginTransaction();// get session
			Department department = (Department) session.load(Department.class, id);// getid
			session.delete(department);// delete
			session.getTransaction().commit();
			return true;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Department updateDepartment(int id, String newName) {
		Session session = null;
		try {
			session = HibernateUtil.getFactory().openSession();
			session.beginTransaction();
			Department department = (Department) session.load(Department.class, id);
			department.setdPname(newName);
			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return null;
	}
	
	public Department createDepartment(Department department) {
		Session session = null;
		try {
			session = HibernateUtil.getFactory().openSession();
			session.save(department);
		} finally {
			if (session !=null) {
				session.close();
			}
		}
		return null;
	}
	
	public Department getDepartmentById(int id) {
		Session session = null;
		try {
			session = HibernateUtil.getFactory().openSession();
			String hql = "FROM Department AS a WHERE a.id =?1";
			Query<Department> query = session.createQuery(hql);
			query.setParameter(1, id);
			return query.uniqueResult();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public Department getDepartmentByName(String name) {
		Session session = null;
		try {
			session = HibernateUtil.getFactory().openSession();
			String hql = "FROM Department WHERE DepartmentName = ?1";
			Query<Department> query = session.createQuery(hql);
			query.setParameter(1, name);
			return query.uniqueResult();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
}
