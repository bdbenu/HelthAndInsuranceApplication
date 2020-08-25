package com.helth.insurance.plan.service;

import java.util.List;

import com.helth.insurance.plan.domain.PlanMaster;

public interface IPlanMasterService {
	public boolean registerPlan(PlanMaster planmaster);
	public List<PlanMaster> getAllPlan();
	public PlanMaster getOnePlan(Integer id);
	public boolean deletePlane(Integer id);

}
