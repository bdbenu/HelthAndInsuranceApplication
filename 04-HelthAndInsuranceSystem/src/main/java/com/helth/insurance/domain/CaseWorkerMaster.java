package com.helth.insurance.domain;

import java.io.Serializable;

import lombok.Data;
@Data
public class CaseWorkerMaster implements Serializable{
	private Integer caseWorkerId;
	private String firstName;
	private String lastName;
	private String gender;
	private String caseWorkerEmail;
	private String role;
	private String accountStatus;
	private String tempPazzword;
	private String newPazzword;
	private String confirmPazzword;
	private String isDelete;
}
