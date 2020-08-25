package com.helth.insurance.plan.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "PLANMASTER")
public class PlanMasterEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer planId;
	private String planName;
	private String planDescrption;
	private Date planStartDate;
	private Date planEndtDate;
	private Date planCreateDate;
	private Date planUpdateDate;


}
