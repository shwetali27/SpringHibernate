/*
*@file_Name: InsertTest.java
*@Author: Shwetali
*@Date: 21-09-2016
*@purpose: main class for database entry using Spring-Hibernate.
*/

package com.bridgelabz.controllers;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.bridgelabz.dao.EmployeeDao;
import com.bridgelabz.dto.Employee;

@SuppressWarnings("deprecation")
public class InsertTest {
	public static void main(String[] args) {
		Resource resource = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(resource);

		EmployeeDao empDao = (EmployeeDao) factory.getBean("employeeDao");

		Employee employee = new Employee();
		employee.setId(6);
		employee.setName("Priya");
		employee.setSalary(10000);
		
		//adding Employee into database
		try {
			empDao.saveEmployee(employee);
			System.out.println("Value is Inserted");
		}
		catch (Exception e) {
			System.out.println("Id Already Present Inside Database");
		}
		
		//deleting employee from database for given id
		try{
			empDao.deleteEmployee(new Employee(8));
		}
		catch(org.hibernate.StaleStateException e){
			
			System.out.println("Id Not Present");
		}
	}
}
