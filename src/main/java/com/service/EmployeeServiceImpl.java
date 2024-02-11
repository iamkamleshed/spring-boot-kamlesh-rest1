package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.EmployeeEntity;
import com.repository.EmployeeRepository;

@Service

public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public void saveEmployee(EmployeeEntity employeeEntity) {
		employeeRepository.save(employeeEntity);

	}

	/*
	 * @Override public void loginEmployee(@RequestParam String email,@RequestParam
	 * String pswd,Model model) { EmployeeEntity employeeEntity =
	 * employeeRepository.findByEmailIdAndPassword(email, pswd); }
	 */
	@Override

	public EmployeeEntity loginEmployee(@RequestParam String email, @RequestParam String pswd) {
		EmployeeEntity employeeEntity = employeeRepository.findByEmailIdAndPassword(email, pswd);
		return employeeEntity;

	}

	@Override
	public List<EmployeeEntity> findAllEmployees() {
		List<EmployeeEntity> list = employeeRepository.findAll();
		return list;
	}

	@Override
	public void deleteEmp(int employeeId) {
		employeeRepository.deleteById(employeeId);

	}

	@Override
	public EmployeeEntity updateEmp(int employeeId) {

		EmployeeEntity employeeEntity = employeeRepository.findById(employeeId).get();
		return employeeEntity;
	}

	@Override
	public EmployeeEntity findEmployee(int id) {
		Optional<EmployeeEntity> optional = employeeRepository.findById(id);
		if (optional.isPresent()) {
			EmployeeEntity employeeEntity = optional.get();
			return employeeEntity;
		}
		return null;
	}

	@Override
	public void deleteEmployee(int id) {
		//EmployeeEntity employeeEntity = employeeRepository.findById(id);
		if (employeeRepository.existsById(id)) {
			employeeRepository.deleteById(id);
		} else {
			throw new RuntimeException();
		}
	}
		
		

	@Override
	public void updateEmployee(EmployeeEntity employeeEntity){
		int employeeId = employeeEntity.getEmployeeId();
		if (employeeRepository.existsById(employeeId)) {
			employeeRepository.save(employeeEntity);
			
		} else {
			throw new RuntimeException();
		}

	}
}
