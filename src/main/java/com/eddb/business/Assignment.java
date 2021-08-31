package com.eddb.business;

import javax.persistence.*;

@Entity
public class Assignment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String description;
	@ManyToOne
	@JoinColumn(name="ClassId")
	private Class classs;
	
	
	public Assignment() {
		super();
	}


	public Assignment(int id, String description, Class classs) {
		super();
		this.id = id;
		this.description = description;
		this.classs = classs;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Class getClasss() {
		return classs;
	}


	public void setClasss(Class classs) {
		this.classs = classs;
	}


	@Override
	public String toString() {
		return "Assignment [id=" + id + ", description=" + description + ", classs=" + classs + "]";
	}
	
	
}
