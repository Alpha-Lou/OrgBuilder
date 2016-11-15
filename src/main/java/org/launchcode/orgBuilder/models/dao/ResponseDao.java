package org.launchcode.orgBuilder.models.dao;

import java.util.List;

import org.launchcode.orgBuilder.models.Question;

public interface ResponseDao {
	public List<Question> findAllByResponse(String response);
	
}
