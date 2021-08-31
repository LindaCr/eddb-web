package com.eddb.business;

import javax.persistence.*;

@Entity
public class StudentClass {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="StudentId")
	private Student student;
	@ManyToOne
	@JoinColumn(name="ClassId")
	private Class classs;
	private String gradeValue;
	
	public StudentClass() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Class getClasss() {
		return classs;
	}

	public void setClasss(Class classs) {
		this.classs = classs;
	}

	public String getGradeValue() {
		return gradeValue;
	}

	public void setGradeValue(String gradeValue) {
		this.gradeValue = gradeValue;
	}

	@Override
	public String toString() {
		return "StudentClass [id=" + id + ", student=" + student + ", classs=" + classs + ", gradeValue=" + gradeValue
				+ "]";
	}
	
	
	
}
