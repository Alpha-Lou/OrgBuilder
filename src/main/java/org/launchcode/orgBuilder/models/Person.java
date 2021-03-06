package org.launchcode.orgBuilder.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "people")
public class Person extends AbstractEntity{
	private String firstName, lastName, suffix, prefix;
	private int phoneNumber;
	private String email;
	private List<Address> addresses = new ArrayList<Address>();
	private List<Tag> tags = new ArrayList<Tag>();; //Binary either they are or aren't
	private List<Response> responses = new ArrayList<Response>();; //could be multiple things, can change over time
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
	
	@Column(name="email")
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
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
	@JoinColumn(name = "respondent_uid")
	public List<Response> getResponses() {
		return responses;
	}
	
	@OneToMany
	@JoinColumn(name = "respondent_uid")
	public List<Tag> getTags() {
		return tags;
	}
	
	@ManyToMany
	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public void setResponses(List<Response> responses) {
		this.responses = responses;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public void setEdited(Date edited) {
		this.edited = edited;
	}

}
