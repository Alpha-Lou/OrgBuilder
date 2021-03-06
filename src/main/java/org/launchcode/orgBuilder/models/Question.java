package org.launchcode.orgBuilder.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "questions")
public class Question extends AbstractEntity {
	private String title;
	private Date created;
	private List<Response> responses; // how someone actually responds
	private List<Answer> answers; //possible responses
	
	public Question() {}
	
	public Question(String title, List<Answer> answers) {
		super();
		
		this.title = title;
		this.answers.addAll(answers);
		this.created = new Date();
	}
	
	@NotNull
	@Column(name="title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@NotNull
	@Column(name="date_created")
	public Date getCreated() {
		return created;
	}

	@OneToMany
	@JoinColumn(name = "question_uid")
	public List<Response> getResponses() {
		return responses;
	}
	
	@OneToMany
	@JoinColumn(name = "answer_uid")
	public List<Answer> getAnswers() {
		return answers;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public void setResponses(List<Response> responses) {
		this.responses = responses;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	
}