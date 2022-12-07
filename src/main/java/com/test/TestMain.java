package com.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestMain {
	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory=cfg.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		Employee emp1=new Employee();
		emp1.setEmp_email("Ram@gmail.com");
		emp1.setEmp_name("Ram");
		
		Employee emp2=new Employee();
		emp2.setEmp_email("Ramesh@gmail.com");
		emp2.setEmp_name("Ramesh");
		
		Employee emp3=new Employee();
		emp3.setEmp_email("Ramnath@gmail.com");
		emp3.setEmp_name("Ramnath");
		
		Employee emp4=new Employee();
		emp4.setEmp_email("Rohit@gmail.com");
		emp4.setEmp_name("Rohit");
		
		Account ac1=new Account();
		ac1.setAc_type("Saving");
		ac1.setAc_number("123456");
		
		Account ac2=new Account();
		ac2.setAc_type("Saving");
		ac2.setAc_number("9999456");
		
		Account ac3=new Account();
		ac3.setAc_type("current");
		ac3.setAc_number("888456");
		
		emp1.getAccountList().add(ac1);
		emp1.getAccountList().add(ac2);
		emp1.getAccountList().add(ac3);
		
		ac1.getEmployeeList().add(emp1);
		ac1.getEmployeeList().add(emp2);
		ac1.getEmployeeList().add(emp3);
		ac1.getEmployeeList().add(emp4);
		
		emp2.getAccountList().add(ac1);
		emp2.getAccountList().add(ac2);
		emp2.getAccountList().add(ac3);
		
		ac2.getEmployeeList().add(emp1);
		ac2.getEmployeeList().add(emp2);
		ac2.getEmployeeList().add(emp3);
		ac2.getEmployeeList().add(emp4);
		
		emp3.getAccountList().add(ac1);
		emp3.getAccountList().add(ac2);
		emp3.getAccountList().add(ac3);
		
		ac3.getEmployeeList().add(emp1);
		ac3.getEmployeeList().add(emp2);
		ac3.getEmployeeList().add(emp3);
		ac3.getEmployeeList().add(emp4);
		
		emp4.getAccountList().add(ac1);
		emp4.getAccountList().add(ac2);
		emp4.getAccountList().add(ac3);
		
		session.persist(emp1);
		session.persist(emp2);
		session.persist(emp3);
		session.persist(emp4);
		
		
		transaction.commit();
		session.close();
	}

}
