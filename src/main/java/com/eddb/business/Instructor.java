package com.eddb.business;

import javax.persistence.*;

@Entity
public class Instructor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String firstname;
	private String lastname;
	private int yearsExperience;
	private boolean isTenured;
	
	
	public Instructor() {
		super();
	}


	public Instructor(int id, String firstname, String lastname, int yearsExperience, boolean isTenured) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.yearsExperience = yearsExperience;
		this.isTenured = isTenured;
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


	public int getYearsExperience() {
		return yearsExperience;
	}


	public void setYearsExperience(int yearsExperience) {
		this.yearsExperience = yearsExperience;
	}


	public boolean isTenured() {
		return isTenured;
	}


	public void setTenured(boolean isTenured) {
		this.isTenured = isTenured;
	}


	@Override
	public String toString() {
		return "Instructor [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", yearsExperience="
				+ yearsExperience + ", isTenured=" + isTenured + "]";
	}
	
	

}
