package com.example.pm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.pm.dao.EmployeeRepository;
import com.example.pm.entity.Employee;
import com.example.pm.util.Util;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	EmployeeRepository employeeRepository;
	
	@GetMapping
	public String displayEmployeesList(Model model) {
		Util.setPageTitle(model, "Employees List");
		loadEmployeesList(model);
		
		return "employees/list-employees";
	}
	
	@GetMapping("/new")
	public String displayEmployeeForm(Model model) {
		Util.setPageTitle(model, "Create Employee");
		model.addAttribute("employee", new Employee());
		
		return "employees/new-employee";
	}
	
	@PostMapping("/save")
	public String createEmployee(Employee employee, Model model) {
		employeeRepository.save(employee);
		
		return "redirect:/employees/";
	}
	
	private void loadEmployeesList(Model model) {
		List<Employee> employees = employeeRepository.findAll();
		model.addAttribute("employees", employees);
	}
}
