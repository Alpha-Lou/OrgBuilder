package org.launchcode.orgBuilder.models.dao;

import java.util.List;

import org.launchcode.orgBuilder.models.Tag;
import org.springframework.data.repository.CrudRepository;

public interface TagDao extends CrudRepository<Tag, Integer>{
	
	public List<Tag> findAll();
	public Tag findByUid(int uid);
}
