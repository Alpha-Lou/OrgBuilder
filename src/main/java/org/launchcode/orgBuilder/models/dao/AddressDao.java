package org.launchcode.orgBuilder.models.dao;

import java.util.List;
import org.launchcode.orgBuilder.models.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressDao extends CrudRepository<Address, Integer>{
	
	public List<Address> findAll();
	public Address findByUid(int uid);
	
}
