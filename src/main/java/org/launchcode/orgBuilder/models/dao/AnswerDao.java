package org.launchcode.orgBuilder.models.dao;

import java.util.List;

import org.launchcode.orgBuilder.models.Answer;
import org.springframework.data.repository.CrudRepository;

public interface AnswerDao extends CrudRepository<Answer, Integer>{
	
	public List<Answer> findAll();
	public Answer findByUid(int uid);
}
