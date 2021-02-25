package com.example.pm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.pm.dto.EmployeeProject;
import com.example.pm.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{
	@Override
	public List<Employee> findAll();
	
	@Query(nativeQuery = true, value = "SELECT e.first_name AS firstName, e.last_name AS lastName, e.email AS email, "
			+ " COUNT(pe.employee_id) AS projectCount FROM employee AS e"
			+ " LEFT JOIN project_employee AS pe"
			+ " ON pe.employee_id = e.employee_id"
			+ " GROUP BY e.first_name, e.last_name ORDER BY 3 DESC;")
	public List<EmployeeProject> getEmployeeProjects();
}
