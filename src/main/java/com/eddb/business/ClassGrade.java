package com.eddb.business;

import javax.persistence.*;

@Entity
public class ClassGrade {

	
	private String grade;
	private double gpa;
	
	public ClassGrade() {
		super();
	}

	public ClassGrade(String grade, double gpa) {
		super();
		this.grade = grade;
		this.gpa = gpa;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	@Override
	public String toString() {
		return "ClassGrade [grade=" + grade + ", gpa=" + gpa + "]";
	}
	
	
	
}
