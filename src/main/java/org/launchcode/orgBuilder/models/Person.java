package org.launchcode.orgBuilder.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "people")
public class Person extends AbstractEntity{
	private String firstName, lastName, suffix, prefix;
	private int phoneNumber;
	private List<Address> addresses;
	private List<Tag> tags; //Binary either that are or aren't
	private List<Response> responses; //could be multiple things, can change over time
	private Date created, edited;
	
	public Person(String firstName, String lastName){
		super();
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.created = new Date();
	}
	
	@NotNull
	@Column(name="first_name")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@NotNull
	@Column(name="last_name")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name="suffix")
	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
	@Column(name="prefix")
	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	@Column(name="PhoneNumber")
	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Column(name="date_created")
	public Date getCreated() {
		return created;
	}
	
	@Column(name="date_edited")
	public Date getEdited() {
		return edited;
	}
	
	public void setEdited() {
		this.edited = new Date();
	}

	@OneToMany
	@JoinColumn(name = "respondent_id")
	public List<Response> getResponses() {
		return responses;
	}
	
	@OneToMany
	@JoinColumn(name = "respondent_id")
	public List<Tag> getTags() {
		return tags;
	}
	
	@ManyToMany
	@JoinTable(name = "person_address", joinColumns={@JoinColumn(name="person_id")}, inverseJoinColumns={@JoinColumn(name="address_id")})
	public List<Address> getAddresses() {
		return addresses;
	}
}
