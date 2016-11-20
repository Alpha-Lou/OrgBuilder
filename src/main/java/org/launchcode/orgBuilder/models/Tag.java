package org.launchcode.orgBuilder.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tags")
public class Tag extends AbstractEntity {
	private String label, description;
	private Date created;
	
	public Tag() {};
	
	public Tag(String label, String description) {
		super();
		
		this.label = label;
		this.description = description;
		this.created = new Date();
		
	}
	
	@NotNull
	@Column(name = "date_created")
	public Date getCreated() {
		return created;
	}
	
	@NotNull
	@Column(name = "label")
	public String getLabel() {
		return label;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
	
	@Column(name = "description")
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setCreated(Date created) {
		this.created = created;
	}
}
