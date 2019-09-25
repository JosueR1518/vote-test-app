package com.telus.testtelus.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.telus.testtelus.entity.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Serializable> {

	
	@Query(value = "SELECT c.* FROM candidate c WHERE c.committee_id =:idCommittee",nativeQuery = true) 
	public abstract List<Candidate> findByCommitteeId(@Param(value = "idCommittee") Integer idCommittee);
	
	
	/*
	 * @Query(value =
	 * "SELECT co.id as idCommittee, c.id as idCandidate, count(v.id) as votes " +
	 * "FROM candidate c " + "INNER JOIN vote v ON c.id = v.candidate_id " +
	 * "INNER JOIN committee co ON c.committee_id = co.id " +
	 * "WHERE co.id =:idCommittee GROUP BY  co.id, c.id ") public abstract
	 * List<Object[]> getMostVoted(@Param(value = "idCommittee") Integer
	 * idCommittee);
	 */
}
