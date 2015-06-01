package com.niit;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Players implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@OneToOne(mappedBy="Student1")
	private Student1 student1;
	
	@Id
	private int id;
	private String game1;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGame1() {
		return game1;
	}
	public void setGame1(String game1) {
		this.game1 = game1;
	}
	
	
	
}
