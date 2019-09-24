package com.telus.testtelus.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.telus.testtelus.entity.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Serializable> {

	
	@Query(value = "SELECT c.* FROM candidate c WHERE c.committee_id =:idCommittee",nativeQuery = true) 
	public abstract List<Candidate> findByCommitteeId(@Param(value = "idCommittee") Integer idCommittee);
}
