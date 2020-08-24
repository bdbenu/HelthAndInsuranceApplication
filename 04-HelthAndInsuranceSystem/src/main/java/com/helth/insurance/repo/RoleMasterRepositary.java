package com.helth.insurance.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.helth.insurance.entity.RoleMaster;

public interface RoleMasterRepositary extends JpaRepository<RoleMaster, Serializable> {

}
