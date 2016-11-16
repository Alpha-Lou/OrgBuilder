package org.launchcode.orgBuilder.models.dao;

import java.util.List;

import org.launchcode.orgBuilder.models.Response;
import org.springframework.data.repository.CrudRepository;

public interface ResponseDao extends CrudRepository<Response, Integer>{
	
	public List<Response> findAll();
	public Response findByUid(int uid);
	
}
