package com.telus.testtelus.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telus.testtelus.entity.VisitorCounter;

@Repository
public interface VisitorCounterRepository extends JpaRepository<VisitorCounter, Serializable>{

	
	
	public abstract VisitorCounter findOneByDate(String date);
}
