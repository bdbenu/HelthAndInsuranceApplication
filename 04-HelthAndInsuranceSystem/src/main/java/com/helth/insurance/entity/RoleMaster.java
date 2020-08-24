package com.helth.insurance.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Data
@Table(name = "ROLEMASTER")
public class RoleMaster{
	@Id
	private Integer roleId;
	private String roleName;

}
