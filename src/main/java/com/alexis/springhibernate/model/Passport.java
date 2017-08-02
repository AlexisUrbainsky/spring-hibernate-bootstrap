package com.alexis.springhibernate.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "passport")
public class Passport implements Serializable{
	
	private int 	id;
	private String 	nationality;
	private Date 	expeditionDate;
	private Date 	expirationDate;
	private Person	person;
	private Set<Travel> travels;
	
	public Passport() {
		
	}
	
	public Passport(String nationality, Date expedition, Date expirate, Person person) {
		this.nationality = nationality;
		this.expeditionDate =expedition;
		this.expirationDate = expedition;
		this.person = person;
	}
	
	@Id
	@GeneratedValue(generator = "generator")
	@GenericGenerator(name ="generator", strategy = "foreing", parameters = @Parameter(name = "property", value ="person"))
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="passport")
	@JoinTable(name="travels",
	joinColumns = @JoinColumn( name="id",nullable = false),
	inverseJoinColumns = @JoinColumn( name="idTravel"))
	public Set<Travel> getTravels() {
		return travels;
	}

	public void setTravels(Set<Travel> travels) {
		this.travels = travels;
	}

	@Column(name = "nationality")
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "expeditionDate", unique = true, nullable = false)
	public Date getExpeditionDate() {
		return expeditionDate;
	}
	public void setExpeditionDate(Date expeditionDate) {
		this.expeditionDate = expeditionDate;
	}
	

	@Column(name = "expirationDate")
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	
}
