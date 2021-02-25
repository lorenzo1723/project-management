package com.example.pm;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.pm.dao.EmployeeRepository;
import com.example.pm.dao.ProjectRepository;
import com.example.pm.entity.Employee;
import com.example.pm.entity.Project;

@SpringBootApplication
public class ProjectManagementApplication {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjectManagementApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner() {
		return args -> {
			Employee firstEmployee = new Employee("Lorenzo", "Orlando", "lorenzo.orlando724@company.it");
			Employee secondEmployee = new Employee("Alessandra", "Amorico", "alessandra.amorico38@company.it");
			Employee thirdEmployee = new Employee("Raffaele", "Terracciano", "raffaele.terracciano.104@company.it");
			Employee fourthEmployee = new Employee("Federica", "Toppi", "federica.toppy4316@company.it");
			
			Project firstProject = new Project("Hire new Junior Developers", "The goal is to hire two new Junior Developers", "INPROGRESS");
			Project secondProject = new Project("Update SSL Licenses", "The goal is to update our expired SSL licenses",  "NOTSTARTED");
			Project thirdProject = new Project("Write documentation for out private Software", "The goal is to document our software", "INPROGRESS");
			
			firstProject.addEmployee(fourthEmployee);
			firstProject.addEmployee(secondEmployee);
			firstProject.addEmployee(thirdEmployee);
			secondProject.addEmployee(firstEmployee);
			thirdProject.addEmployee(firstEmployee);
			
			firstEmployee.setProjects(Arrays.asList(secondProject, thirdProject));
			secondEmployee.setProjects(Arrays.asList(firstProject));
			thirdEmployee.setProjects(Arrays.asList(firstProject));
			fourthEmployee.setProjects(Arrays.asList(firstProject));
			
			employeeRepository.save(firstEmployee);
			employeeRepository.save(secondEmployee);
			employeeRepository.save(thirdEmployee);
			employeeRepository.save(fourthEmployee);
			
			projectRepository.save(firstProject);
			projectRepository.save(secondProject);
			projectRepository.save(thirdProject);
		};
	}
}
