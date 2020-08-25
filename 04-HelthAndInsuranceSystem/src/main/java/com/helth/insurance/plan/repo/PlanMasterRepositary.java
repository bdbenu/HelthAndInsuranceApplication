package com.helth.insurance.plan.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.helth.insurance.plan.entity.PlanMasterEntity;

public interface PlanMasterRepositary extends JpaRepository<PlanMasterEntity, Serializable>{

}
