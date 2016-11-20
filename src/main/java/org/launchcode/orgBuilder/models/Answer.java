package org.launchcode.orgBuilder.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Answers")
public class Answer extends AbstractEntity{
	private String value;
	private Date created;
	private Question question;
	private List<Response> responses;
	
	public Answer() {}
	
	public Answer(String value) {
		super();
		this.value = value;
		this.created = new Date();
	}
	
	@NotNull
	@Column(name="value")
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	@Column(name="date_created")
	public Date getCreated() {
		return created;
	}

	@ManyToOne
	public Question getQuestion() {
		return question;
	}
	
	@OneToMany
	@JoinColumn(name = "answer_uid")
	public List<Response> getResponses() {
		return responses;
	}

	public void setResponses(List<Response> responses) {
		this.responses = responses;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	
}
