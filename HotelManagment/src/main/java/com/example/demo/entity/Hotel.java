package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//Mark this class as an  entity class
@Entity

@Table(name="employees")
//it specifies the table name
public class Hotel {
	
//it will serve as primary key	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //use to generate unique id for each record
	private long id;
	
	private String name;
	
	private String hoteltype;
	
	private String quality;
	
	//Have to create constructor, getters, setters
	
	// Constructor using fields
	public Hotel(long id, String name, String hoteltype, String quality) {
		super();
		this.id = id;
		this.name = name;
		this.hoteltype = hoteltype;
		this.quality = quality;
	}
	
	
	//Non parameterized constructor
	
	public Hotel() {
		super();
	}
	
	//Getters and setter


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getHoteltype() {
		return hoteltype;
	}


	public void setHoteltype(String hoteltype) {
		this.hoteltype = hoteltype;
	}


	public String getQuality() {
		return quality;
	}


	public void setQuality(String quality) {
		this.quality = quality;
	}


	
	//to string
	@Override
	public String toString() {
		return "Hotel [id=" + id + ", name=" + name + ", hoteltype=" + hoteltype + ", quality=" + quality + "]";
	}	
	
}

