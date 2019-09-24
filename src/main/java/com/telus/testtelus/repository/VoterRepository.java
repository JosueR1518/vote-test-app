package com.telus.testtelus.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.telus.testtelus.entity.Voter;

@Repository("voterRepository")
public interface VoterRepository  extends JpaRepository<Voter, Serializable>{

	
	
	@Query(value = "SELECT v.* FROM voter v WHERE v.user_id =:idUser",nativeQuery = true) 
	public  Voter findByUserId(@Param(value = "idUser") Integer idUser);
}
