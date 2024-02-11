package com.service;

import java.util.List;

import org.springframework.ui.Model;

import com.entity.EmployeeEntity;

public interface EmployeeService {

	void saveEmployee(EmployeeEntity employeeEntity);
	EmployeeEntity loginEmployee(String email, String pswd);
	List<EmployeeEntity> findAllEmployees();
	void deleteEmp(int employeeId);
	EmployeeEntity updateEmp(int employeeId);
	EmployeeEntity findEmployee(int id);
	void deleteEmployee(int id);
	void updateEmployee(EmployeeEntity employeeEntity);

}
