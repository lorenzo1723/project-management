package com.example.pm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.pm.dao.EmployeeRepository;
import com.example.pm.dao.ProjectRepository;
import com.example.pm.entity.Employee;
import com.example.pm.entity.Project;
import com.example.pm.util.Util;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	@Autowired
	ProjectRepository projectRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@GetMapping
	public String displayProjectsList(Model model) {
		Util.setPageTitle(model, "Projects List");
		loadMultipleProjects(model);
		
		return "projects/list-projects";
	}
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		Util.setPageTitle(model, "Create Project");
		loadSingleProject(model);
		loadEmployees(model);
		
		return "projects/new-project";
	}
	
	@PostMapping("/save")
	public String createProject(Project project, Model model) {
		projectRepository.save(project);
		return "redirect:/projects/";
	}
	
	private void loadEmployees(Model model) {
		List<Employee> employees = employeeRepository.findAll();
		model.addAttribute("employees", employees);
 	}
	
	private void loadSingleProject(Model model) {
		model.addAttribute("project", new Project());
	}
	
	private void loadMultipleProjects(Model model) {
		List<Project> projects = projectRepository.findAll();
		model.addAttribute("projects", projects);
	}
}
