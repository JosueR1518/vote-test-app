package com.telus.testtelus.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telus.testtelus.entity.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Serializable> {

	
	
	public abstract List<Candidate> findByCommitteeId(Integer idCommittee);
}
