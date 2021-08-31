package com.eddb.business;

import javax.persistence.*;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String firstname;
	private String lastname;
	private String stateCode;
	private int sat;
	private double gpa;
	@ManyToOne
	@JoinColumn(name="StudentId")
	private Major major;
	
	
	public Student() {
		super();
	}


	public Student(int id, String firstname, String lastname, String stateCode, int sat, double gpa, Major major) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.stateCode = stateCode;
		this.sat = sat;
		this.gpa = gpa;
		this.major = major;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getStateCode() {
		return stateCode;
	}


	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}


	public int getSat() {
		return sat;
	}


	public void setSat(int sat) {
		this.sat = sat;
	}


	public double getGpa() {
		return gpa;
	}


	public void setGpa(double gpa) {
		this.gpa = gpa;
	}


	public Major getMajor() {
		return major;
	}


	public void setMajor(Major major) {
		this.major = major;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", stateCode=" + stateCode
				+ ", sat=" + sat + ", gpa=" + gpa + ", major=" + major + "]";
	}
	
	
	
}
