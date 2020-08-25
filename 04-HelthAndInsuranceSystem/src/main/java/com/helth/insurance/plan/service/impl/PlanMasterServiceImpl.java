package com.helth.insurance.plan.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helth.insurance.plan.domain.PlanMaster;
import com.helth.insurance.plan.entity.PlanMasterEntity;
import com.helth.insurance.plan.repo.PlanMasterRepositary;
import com.helth.insurance.plan.service.IPlanMasterService;
@Service
public class PlanMasterServiceImpl implements IPlanMasterService{
	@Autowired
	private PlanMasterRepositary planrepo;

	@Override
	public boolean registerPlan(PlanMaster planmaster) {
		PlanMasterEntity entity = new PlanMasterEntity();
		BeanUtils.copyProperties(planmaster, entity);
		PlanMasterEntity isSave = planrepo.save(entity);
		return isSave.getPlanId()!=null;
	}

	@Override
	public List<PlanMaster> getAllPlan() {
		List<PlanMasterEntity> entity = planrepo.findAll();
		List<PlanMaster> plans = new ArrayList<PlanMaster>();
		for(PlanMasterEntity entities:entity) {
			PlanMaster master = new PlanMaster();
			BeanUtils.copyProperties(entities, master);
			plans.add(master);
		}
		return plans;
	}

	@Override
	public PlanMaster getOnePlan(Integer id) {
		Optional<PlanMasterEntity> findById = planrepo.findById(id);
		if(findById.isPresent()) {
			PlanMasterEntity entity = findById.get();
			PlanMaster master = new  PlanMaster();
			BeanUtils.copyProperties(entity, master);
			return master;
			
		}
		
		return null;
	}

	@Override
	public boolean deletePlane(Integer id) {
		planrepo.deleteById(id);
		return true;
	}

}
