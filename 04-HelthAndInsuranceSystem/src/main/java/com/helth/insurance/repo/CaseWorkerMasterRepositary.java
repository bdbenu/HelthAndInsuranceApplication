package com.helth.insurance.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.helth.insurance.domain.CaseWorkerMaster;
import com.helth.insurance.entity.CaseWorkerMasterEntity;

public interface CaseWorkerMasterRepositary extends JpaRepository<CaseWorkerMasterEntity, Serializable>{
	//public CaseWorkerMaster findByFindByTempPazzwordAndAccountStatus(String tempPazzword,String accounStatus);
}
