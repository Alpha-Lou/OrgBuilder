package org.launchcode.orgBuilder.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "addresses")
public class Address extends AbstractEntity{
	private String street, city, state, zipcode;
	private List<Person> residents;
	private Date created;
	
	public Address() {
		super();
		this.created = new Date();
	}
	
	@NotNull
	@Column(name="date_created")
	public Date getCreated() {
		return created;
	}

	@Column(name="street")
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
	
	@Column(name="city")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	@Column(name="state")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	@Column(name="zipcode")
	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@ManyToMany
	public List<Person> getResidents() {
		return residents;
	}
}
