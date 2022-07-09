package com.ATDevTechnologies.AtDeveTechnologies.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ATDevTechnologies.AtDeveTechnologies.Entity.*;
public interface StudentRepo extends JpaRepository<Student, Long> {

	
		
	}


