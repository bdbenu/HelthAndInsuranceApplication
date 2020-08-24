package com.helth.insurance.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "CASEWORKDERMASTER")
public class CaseWorkerMasterEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
