package com.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
	
	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory=cfg.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
	/*	//insert data 
		Student student=new Student();
		student.setCity("Nagpur");
		student.setFirstname("Rohit");
		student.setLastName("Pawar");
		student.setNumber("888888");
			session.save(student);
		*/
	
		/*//update 
		Student student=(Student)session.get(Student.class, 1);
		student.setFirstname("Sachin");
		
		session.update(student);*/
		
	/*	//delete
		Student student=(Student)session.get(Student.class, 3);
		session.delete(student);*/
		
		Query query=session.createQuery("from Student");//10
	    List<Student>	students=query.list();
	    for(Student s:students) {
	    	System.out.println("Id >>  "+s.getId());
	    	System.out.println("first name >>  "+s.getFirstname());
	    	System.out.println("last name >>  "+s.getLastName());
	    	System.out.println("city >>  "+s.getCity());
	    	System.out.println("number >>  "+s.getNumber());
	    }
	    
	    
	    
	    
		transaction.commit();
		session.close();
		System.out.println("record inserted successfully ...");
	}
}
