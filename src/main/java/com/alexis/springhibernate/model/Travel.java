package com.alexis.springhibernate.model;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "travels")
public class Travel implements Serializable {
	
	private int id;
	private Date start_date;
	private Date end_date;
	private String porpouse;
	private Country country;
	
	public Travel(){
		
	}
	
	public Travel(Date start, Date end, String porpouse, Country country){
		this.start_date	= start;
		this.end_date	= end;
		this.porpouse 	= porpouse;
		this.country 	= country;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "idCountry",nullable = false)
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "start_date", unique = true, nullable = false, length = 10 )
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "endt_date", unique = true, nullable = false, length = 10)
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	
	@Column(name = "purpouse")
	public String getPorpouse() {
		return porpouse;
	}
	public void setPorpouse(String porpouse) {
		this.porpouse = porpouse;
	}
	
}
