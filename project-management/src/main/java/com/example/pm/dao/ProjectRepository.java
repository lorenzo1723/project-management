package com.example.pm.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.example.pm.entity.Project;

public interface ProjectRepository extends CrudRepository<Project, Long>{
	@Override
	public List<Project> findAll();
	
}
