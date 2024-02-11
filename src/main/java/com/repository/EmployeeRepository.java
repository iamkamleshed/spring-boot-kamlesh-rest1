package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer>{
	EmployeeEntity findByEmailIdAndPassword(String email, String pswd);
	
}

