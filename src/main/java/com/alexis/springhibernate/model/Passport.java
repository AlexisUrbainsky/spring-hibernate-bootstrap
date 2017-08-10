package com.alexis.springhibernate.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
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
import org.hibernate.annotations.CreationTimestamp;
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
	private List<Travel> travels = new ArrayList<Travel>();
	
	public Passport() {
		
	}
	
	public Passport(String nationality, Date expedition, Date expirate) {
		this.nationality 	= nationality;
		this.expeditionDate = expedition;
		this.expirationDate = expedition;
	}
	
	public Passport(String nationality, Date expedition, Date expirate, Person person) {
		this.nationality 	= nationality;
		this.expeditionDate = expedition;
		this.expirationDate = expedition;
		this.person			= person;
	}
	
	@Id
	@GenericGenerator(name = "generator", strategy = "foreign",	parameters = @Parameter(name = "property", value = "person"))
	@GeneratedValue(generator = "generator")
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
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(
        name="travels",
        joinColumns = @JoinColumn( name="idTravel"),
        inverseJoinColumns = @JoinColumn( name="idPassport")
    )
	public List<Travel> getTravels() {
		return travels;
	}

	public void setTravels(List<Travel> travels) {
		this.travels = travels;
	}

	@Column(name = "nationality")
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "expeditionDate", updatable=false)
	public Date getExpeditionDate() {
		return expeditionDate;
	}
	
	public void setExpeditionDate(Date expeditionDate) {
		this.expeditionDate = expeditionDate;
	}
	
	@Column(name = "expirationDate", updatable=false)
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	
}
