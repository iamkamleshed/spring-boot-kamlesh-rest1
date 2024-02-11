package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.EmployeeEntity;
import com.service.EmployeeService;

@RestController
@RequestMapping("/v1")
public class EmployeeRestController {
	@Autowired
	EmployeeService employeeService;

	@GetMapping("/employees") // localhost:9999/v1/employees
	List<EmployeeEntity> giveAllEmployees() {
		List<EmployeeEntity> listOfEmployees = employeeService.findAllEmployees();
		return listOfEmployees;
	}

	@GetMapping("/employees/{id}") // localhost:9999/v1/employees/8
	EmployeeEntity findEmployee(@PathVariable int id) {
		EmployeeEntity employeeEntity = employeeService.findEmployee(id);
		return employeeEntity;
	}

	@PostMapping("/employees")
	String insertEmployee(@RequestBody EmployeeEntity employeeEntity) {
		try {
			employeeService.saveEmployee(employeeEntity);
		} catch (DataIntegrityViolationException e) {
			return "Duplicate Email is not allowed.";
		} catch (Exception e) {
			return "Some issues";
		}
		return "registered successfully";
	}

	@DeleteMapping("/employees/{id}")
	String deleteEmployee(@PathVariable int id) {
		try {
			employeeService.deleteEmployee(id);
		} catch (Exception e) {
			return "Id doesn't exists in the db or cannot be deleted.";
		}

		return "Deleted successfully.";
	}

	@PutMapping("/employees/{id}")
	String updateEmployee(@PathVariable int id, @RequestBody EmployeeEntity employeeEntity) {
		employeeEntity.setEmployeeId(id);
		try {
			employeeService.updateEmployee(employeeEntity);
		} catch (DataIntegrityViolationException e) {
			return "Duplicate Email is not allowed.";
		} catch (Exception e) {
			return "Id not present in the database";
		}
		return "updated successfully";
	}

//	// Another method
//
//	@PutMapping("/employees")
//	String updateEmployee(@RequestBody EmployeeEntity employeeEntity) {
//		employeeService.updateEmployee(employeeEntity);
//		return "updated successfully.";
//	}

}
