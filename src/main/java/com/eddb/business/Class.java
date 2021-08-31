package com.eddb.business;

import javax.persistence.*;

@Entity
public class Class {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String code;
	private String subject;
	private int section;
	@ManyToOne
	@JoinColumn(name="InstructorId")
	private Instructor instructor;
	
	
	public Class() {
		super();
	}


	public Class(int id, String code, String subject, int section, Instructor instructor) {
		super();
		this.id = id;
		this.code = code;
		this.subject = subject;
		this.section = section;
		this.instructor = instructor;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public int getSection() {
		return section;
	}


	public void setSection(int section) {
		this.section = section;
	}


	public Instructor getInstructor() {
		return instructor;
	}


	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}


	@Override
	public String toString() {
		return "Class [id=" + id + ", code=" + code + ", subject=" + subject + ", section=" + section + ", instructor="
				+ instructor + "]";
	}
	
	
	
}
