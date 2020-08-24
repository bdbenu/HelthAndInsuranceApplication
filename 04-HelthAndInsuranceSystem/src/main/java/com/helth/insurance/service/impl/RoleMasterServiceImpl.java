package com.helth.insurance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.helth.insurance.entity.RoleMaster;
import com.helth.insurance.repo.RoleMasterRepositary;
import com.helth.insurance.service.IRoleMasterService;

public class RoleMasterServiceImpl implements IRoleMasterService {
	@Autowired
	private RoleMasterRepositary rolemasterrepo;

	@Override
	public List<RoleMaster> getAllRole() {
		List<RoleMaster> findAll = rolemasterrepo.findAll();
		
		return findAll;
	}

}
