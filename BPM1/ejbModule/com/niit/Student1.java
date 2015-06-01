package com.niit;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity

public class Student1 implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@OneToOne
	private Players players;
	
	@Id
	private int id;
	private String stuname;
	private String classname;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStuname() {
		return stuname;
	}
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	
	public Student1(int id, String stuname, String classname) {
		super();
		this.id = id;
		this.stuname = stuname;
		this.classname = classname;
	}
	public Student1() {
		
	}
	
	
	
}
