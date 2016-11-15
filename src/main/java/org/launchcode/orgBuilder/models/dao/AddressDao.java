package org.launchcode.orgBuilder.models.dao;

import java.util.List;

import org.launchcode.orgBuilder.models.Address;

public interface AddressDao {
	public List<Address> findAll();
	public Address findByUid(int uid);
	
}
