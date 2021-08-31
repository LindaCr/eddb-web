package com.eddb.business;

import javax.persistence.*;

@Entity
public class Major {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String code;
	private String description;
	private int minSAT;
	
	
	public Major() {
		super();
	}


	public Major(int id, String code, String description, int minSAT) {
		super();
		this.id = id;
		this.code = code;
		this.description = description;
		this.minSAT = minSAT;
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


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getMinSAT() {
		return minSAT;
	}


	public void setMinSAT(int minSAT) {
		this.minSAT = minSAT;
	}


	@Override
	public String toString() {
		return "Major [id=" + id + ", code=" + code + ", description=" + description + ", minSAT=" + minSAT + "]";
	}
	
	
	
	

}
