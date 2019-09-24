package com.telus.testtelus.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.telus.testtelus.entity.VisitorCounter;

@Repository
public interface VisitorCounterRepository extends JpaRepository<VisitorCounter, Serializable>{

	
	
	public abstract VisitorCounter findOneByDate(String date);
	
	
	
	@Query(value = "SELECT v.* FROM visitor_counter v ORDER BY v.date DESC",nativeQuery = true) 
	public abstract List<VisitorCounter> findAllOrderByDateDesc();
}
