package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.exception.InvalidIdException;
import com.exception.NoRecordFoundException;
import com.service.EmployeeService;

@RestController
@RequestMapping("/v2")
public class EmployeeRestController2 {
	@Autowired
	EmployeeService employeeService;

	@GetMapping("/employees") //localhost:9999/v2/employees
	ResponseEntity<List<EmployeeEntity>> giveAllEmployees() {
		List<EmployeeEntity> listOfEmployees = employeeService.findAllEmployees();
		return new ResponseEntity<>(listOfEmployees,HttpStatus.CREATED);//201
	}

	@GetMapping("/employees/{id}") // localhost:9999/v2/employees/8
	ResponseEntity<EmployeeEntity> findEmployee(@PathVariable int id) {
		if(id<=0) {
			throw new InvalidIdException("Id can't be zero or negative.");
		}
		EmployeeEntity employeeEntity = employeeService.findEmployee(id);
		if(employeeEntity == null) {
			throw new NoRecordFoundException("employee does not exist for this id"); 
		}
		return new ResponseEntity<>(employeeEntity,HttpStatus.OK);//200
	}

	@PostMapping("/employees")
	ResponseEntity<String> insertEmployee(@RequestBody EmployeeEntity employeeEntity) {
		try {
			employeeService.saveEmployee(employeeEntity);
		} catch (DataIntegrityViolationException e) {
			return new ResponseEntity<>("Duplicate Email is not allowed.",HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>("Some Issues",HttpStatus.OK);
		}
		return new ResponseEntity<>("Registered Successfully",HttpStatus.OK);
	}

	@DeleteMapping("/employees/{id}")
	ResponseEntity<String> deleteEmployee(@PathVariable int id) {
		try {
		employeeService.deleteEmployee(id);
		} catch (Exception e) {
			return new ResponseEntity<>("Id doesn't exists in the db or cannot be deleted.",HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Deleted successfully.",HttpStatus.OK);
	}

	@PutMapping("/employees/{id}")
	ResponseEntity<String> updateEmployee(@PathVariable int id, @RequestBody EmployeeEntity employeeEntity) {
		employeeEntity.setEmployeeId(id);
		try {
			employeeService.updateEmployee(employeeEntity);
		} catch (DataIntegrityViolationException e) {
			return new ResponseEntity<>("Duplicate Email is not allowed.",HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>("Id not present in the database",HttpStatus.OK);
		}
		return new ResponseEntity<>("updated successfully",HttpStatus.OK);
	}

	/*
	 * Another method
	 * 
	 * @PutMapping("/employees") String updateEmployee(@RequestBody EmployeeEntity
	 * employeeEntity) { employeeService.updateEmployee( employeeEntity); return
	 * "updated successfully."; }
	 */

}
