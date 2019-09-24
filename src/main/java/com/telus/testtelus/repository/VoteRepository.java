/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telus.testtelus.repository;

import com.telus.testtelus.entity.Vote;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jaml
 */
@Repository
public interface VoteRepository extends JpaRepository<Vote, Serializable>{
    
	
	@Query(value = "SELECT v.* FROM vote v "
			+ "WHERE v.voter_id = :idVoter AND v.candidate_id = :idCandidate",nativeQuery = true) 
	public abstract Vote findOneByCandidateIdAndVoterId(@Param(value = "idVoter") Integer idVoter,@Param(value = "idCandidate") Integer idCandidate);
	
	
	
	@Query(value = "SELECT v.* FROM vote v "
			+ "INNER JOIN candidate c  ON v.candidate_id = c.id "
			+ "INNER JOIN committee co ON c.committee_id = co.id "
			+ "WHERE v.voter_id = :idVoter AND co.id = :idCommittee",nativeQuery = true) 
	public abstract Vote findOneByIdCandidateAndIdCommittee(@Param(value = "idVoter") Integer idVoter,@Param(value = "idCommittee") Integer idCommittee);
	
	
}
