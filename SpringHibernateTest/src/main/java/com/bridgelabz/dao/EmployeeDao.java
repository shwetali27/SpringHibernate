/*
*@file_Name: EmployeeDao.java
*@Author: Shwetali
*@Date: 21-09-2016
*@purpose:EmployeeDao file for storing and getting data from database.
*/

package com.bridgelabz.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.bridgelabz.dto.Employee;

public class EmployeeDao {
	@Autowired
	SessionFactory sessionFactory;

	Session session;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// method to save Employee
	public void saveEmployee(Employee employee) {
		session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(employee);
		tr.commit();
	}

	// method for delete Employee
	public void deleteEmployee(Employee employee) {
		session = sessionFactory.openSession();
		System.out.println("Delete Method is called");
		Transaction tr = session.beginTransaction();
		session.delete(employee);
		this.updateEmployee(employee);
		tr.commit();
	}
}
