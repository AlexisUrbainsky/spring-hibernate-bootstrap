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

@Entity
@Table(name = "travels")
public class Travel implements Serializable {
	
	private int id;
	private Date startDate;
	private Date endDate;
	private String purpose;
	private Country country;
	
	public Travel(){
		
	}
	
	public Travel(Date start, Date end, String purpose, Country country){
		this.startDate	= start;
		this.endDate	= end;
		this.purpose 	= purpose;
		this.country 	= country;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idTravel", unique = true, nullable = false)
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

	@Column(name = "startDate", unique = true, nullable = false, length = 10 )
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	@Column(name = "endDate", unique = true, nullable = false, length = 10)
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	@Column(name = "purpose")
	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	
}
