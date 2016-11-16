package org.launchcode.orgBuilder.models.dao;

import java.util.List;

import org.launchcode.orgBuilder.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Integer>{
	public User findByUid(int uid);
	public List<User> findAll();
}
