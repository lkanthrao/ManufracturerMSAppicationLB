package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection = "manufacturers") // its like @Entity in hibernate, jpa
public class Manufacturer {

	@Id
	private int id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd")
	private java.util.Date startDate;

	private String name;

	public Manufacturer() {
		// TODO Auto-generated constructor stub
	}

	public Manufacturer(int id, java.util.Date startDate, String name) {
		this.id = id;
		this.startDate = startDate;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public java.util.Date getStartDate() {
		return startDate;
	}

	public void setStartDate(java.util.Date startDate) {
		this.startDate = startDate;
	}

	
}
