package com.helth.insurance.plan.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
@Data
public class PlanMaster implements Serializable{
	private Integer planId;
	private String planName;
	private String planDescrption;
	private Date planStartDate;
	private Date planEndtDate;
	private Date planCreateDate;
	private Date planUpdateDate;
}
