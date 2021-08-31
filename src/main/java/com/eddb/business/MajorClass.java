package com.eddb.business;

import javax.persistence.*;

@Entity
public class MajorClass {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="MajorId")
	private Major major;
	@ManyToOne
	@JoinColumn(name="ClassId")
	private Class classs;
	
	
	public MajorClass() {
		super();
	}


	public MajorClass(int id, Major major, Class classs) {
		super();
		this.id = id;
		this.major = major;
		this.classs = classs;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Major getMajor() {
		return major;
	}


	public void setMajor(Major major) {
		this.major = major;
	}


	public Class getClasss() {
		return classs;
	}


	public void setClasss(Class classs) {
		this.classs = classs;
	}


	@Override
	public String toString() {
		return "MajorClass [id=" + id + ", major=" + major + ", classs=" + classs + "]";
	}
	
	
	
}
