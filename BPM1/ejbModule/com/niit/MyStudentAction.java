package com.niit;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class MyStudentAction
 */
@Stateless
@LocalBean
public class MyStudentAction {

	@PersistenceContext
    EntityManager em;
	
    public MyStudentAction() {
       
    }
    
    public void insertData(int id, String stuname, String classname) {
    	
    	em.persist(new Student1(id, stuname, classname));
    }

    public Student1 removeStu(int id) {
    	Student1 ob = em.find(Student1.class, id);
    	  	em.remove(ob);
    	  	return ob;
    }
    
    public Student1 findData(int id) {
    	Student1 ob = em.find(Student1.class, id);
    	return  ob;
    }
    
    public Student1 updateData(int id,String stuname, String classname) {
    	Student1 ob = em.merge(new Student1(id, stuname, classname));
    	return  ob;
    }
    
  
  
	@SuppressWarnings("unchecked")
	public ArrayList<Student1> viewAll() {
    	javax.persistence.Query q = em.createQuery("select e from Student1 e");
    	return((ArrayList<Student1>)q.getResultList() );
    }
    
    
}
