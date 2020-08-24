package com.helth.insurance.service;

import java.util.List;

import com.helth.insurance.domain.CaseWorkerMaster;

public interface ICaseWorkerMaster {
public boolean registerCaseWorker(CaseWorkerMaster caseworkermaster);
public List<CaseWorkerMaster> getAllCaseWorker();
public boolean deleteWorker(Integer id);
public CaseWorkerMaster getOneCaseWorker(Integer id);
public boolean updateWorker(CaseWorkerMaster caseworkermaster);
public CaseWorkerMaster isTempPasswordValid(String temppwd);

}
