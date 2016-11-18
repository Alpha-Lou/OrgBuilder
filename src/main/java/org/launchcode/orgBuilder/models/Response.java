package org.launchcode.orgBuilder.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="responses")
public class Response extends AbstractEntity {
	private String name;
	private Date created;
	private Question question;
	private Answer answer;
	private Person respondent;
	
	public Response(Person person, Answer answer, Question question) {
		
		super();
		
		this.respondent = person;
		this.answer = answer;
		this.question = question;
		this.created = new Date();
		
	}
	
	@NotNull
	@Column(name="question_value")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@NotNull
	@Column(name="date_created")
	public Date getCreated() {
		return created;
	}

	@ManyToOne
	public Question getQuestion() {
		return question;
	}
	
	@ManyToOne
	public Answer getAnswer() {
		return answer;
	}
	
	@ManyToOne
	public Person getRespondent() {
		return respondent;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	public void setRespondent(Person respondent) {
		this.respondent = respondent;
	}
}
