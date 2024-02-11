package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.EmployeeEntity;
import com.repository.EmployeeRepository;
import com.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@Autowired
	EmployeeRepository employeeRepository;

	@GetMapping("/") // '/' is the path of the default URL
	String displayLoginPage1() {

		return "login"; // Returns login.jsp
	}

	@GetMapping("/login") // '/login' is the path of the URL
	String displayLoginPage() {

		return "login"; // Returns login.jsp
	}

	@GetMapping("/registration")

	String displayRegistrationPage() {

		return "employeeRegistration";

	}

	@GetMapping("/showAll")

	String displayShowAllPage(Model model) {
		List<EmployeeEntity> listOfEmployees = employeeService.findAllEmployees();
		model.addAttribute("listOfEmployees", listOfEmployees);

		return "showAll";

	}

	@GetMapping("/deleteEmployee")

	String deleteEmp(@RequestParam int employeeId, Model model) {

		employeeService.deleteEmp(employeeId);
		/*
		 * List<EmployeeEntity> listOfEmployees = employeeService.findAllEmployees();
		 * model.addAttribute("listOfEmployees", listOfEmployees);
		 */

		return "redirect:showAll";

	}

	

	@PostMapping("/registration")

	String doRegistration(@ModelAttribute EmployeeEntity employeeEntity, Model model) {

		// employeeRepository.save(employeeEntity);

		employeeService.saveEmployee(employeeEntity);
		model.addAttribute("message", "Successfully saved");
		return "employeeRegistration";

	}

	@PostMapping("/login")
	String doLogin(@RequestParam String email, @RequestParam String pswd, Model model) {

		EmployeeEntity employeeEntity = employeeService.loginEmployee(email, pswd);
		// EmployeeEntity
		// employeeEntity=employeeRepository.findByEmailIdAndPassword(email,pswd);
		if (employeeEntity != null) {
			model.addAttribute(employeeEntity);

			return "congrats";// go to congrats.jsp

		} else {
			model.addAttribute("msg", "Incorrect credentials.. Please try again"); // 'msg' is a variable that stores a
																					// message
			return "login"; // Go back to login.jsp page
		}
	}
	@GetMapping("/updateEmployee") //display edit page

	String updateEmp(@RequestParam int employeeId, Model model) {

		EmployeeEntity employeeEntity = employeeService.updateEmp(employeeId);

		model.addAttribute("employeeEntity", employeeEntity);
		return "edit"; // edit.jsp

	}

	@PostMapping("/finalUpdateEmployee") //display update page
	String finalUpdate(@ModelAttribute EmployeeEntity employeeEntity, Model model) {

		employeeService.saveEmployee(employeeEntity);
		model.addAttribute("msg", "Successfully Updated");
		return "redirect:showAll";
	}
}
