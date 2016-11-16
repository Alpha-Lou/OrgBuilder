package org.launchcode.orgBuilder.models.dao;

import java.util.List;

import org.launchcode.orgBuilder.models.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionDao extends CrudRepository<Question, Integer>{
	
	public Question findByUid(int uid);
	public List<Question> findAll();
}
