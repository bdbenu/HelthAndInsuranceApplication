package com.helth.insurance.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helth.insurance.domain.CaseWorkerMaster;
import com.helth.insurance.entity.CaseWorkerMasterEntity;
import com.helth.insurance.repo.CaseWorkerMasterRepositary;
import com.helth.insurance.service.ICaseWorkerMaster;
import com.helth.insurance.util.EmailUtils;
import com.helth.insurance.util.PwdUtils;
@Service
public class CaseWorkerMasterServiceImpl implements ICaseWorkerMaster{
	@Autowired
	private CaseWorkerMasterRepositary caseRepo;
	@Autowired
	private EmailUtils emailutils;

	@Override
	public boolean registerCaseWorker(CaseWorkerMaster caseworkermaster) {
		CaseWorkerMasterEntity entity = new CaseWorkerMasterEntity();
		caseworkermaster.setAccountStatus("LOKED");
		caseworkermaster.setIsDelete("N");
		caseworkermaster.setTempPazzword(PwdUtils.generateTempPwd(8).toUpperCase());
		BeanUtils.copyProperties(caseworkermaster, entity);
		CaseWorkerMasterEntity isSave = caseRepo.save(entity);
		if(isSave.getCaseWorkerId() != null) {
			return emailutils.sendUserAccUnlockEmail(caseworkermaster);
		}
		return false;
	}

	
	
	public List<CaseWorkerMaster> getAllCaseWorker() {
		List<CaseWorkerMasterEntity> entity =caseRepo.findAll();
		List<CaseWorkerMaster> workers = new ArrayList<CaseWorkerMaster>();
		for(CaseWorkerMasterEntity entity1 :entity) {
			CaseWorkerMaster worker = new CaseWorkerMaster();
		BeanUtils.copyProperties(entity1,worker);
		workers.add(worker);
		}
		return workers;

}



	@Override
	public boolean deleteWorker(Integer id) {
		caseRepo.deleteById(id);
		return true;
	}



	@Override
	public CaseWorkerMaster getOneCaseWorker(Integer id) {
		Optional<CaseWorkerMasterEntity> findById = caseRepo.findById(id);
		if(findById.isPresent()) {
			CaseWorkerMasterEntity entity = findById.get();
			CaseWorkerMaster caseworkermasetr = new CaseWorkerMaster();
			BeanUtils.copyProperties(entity, caseworkermasetr);
			return caseworkermasetr;
		}
		return null;
	}



	@Override
	public boolean updateWorker(CaseWorkerMaster caseworkermaster) {
		CaseWorkerMasterEntity entity =  new CaseWorkerMasterEntity();
		BeanUtils.copyProperties(caseworkermaster, entity);
		CaseWorkerMasterEntity isSave = caseRepo.save(entity);
		
		return isSave!=null;
	}

//	@Override
//	public CaseWorkerMaster isTempPasswordValid(String temppwd) {
//		CaseWorkerMasterEntity entity = caseRepo.findByTempPazzword(temppwd);
//		CaseWorkerMaster master =null;
//		if(entity!=null) {
//			master = new CaseWorkerMaster(); 	
//			BeanUtils.copyProperties( master,entity);
//		}
//		return master;
//	}



	@Override
	public CaseWorkerMaster findByFindByTempPazzwordAndAccountStatus(String tempPazzword, String accounStatus) {
		return null;
	}



	@Override
	public boolean updateAccountStatus(CaseWorkerMaster caseworkermaster) {
		CaseWorkerMasterEntity entity = new CaseWorkerMasterEntity();
		caseworkermaster.setAccountStatus("unlock");
		BeanUtils.copyProperties(caseworkermaster, entity);
		CaseWorkerMasterEntity isSave = caseRepo.save(entity);
		return isSave.getCaseWorkerId()!=null;
	}
}
