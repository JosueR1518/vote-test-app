package com.telus.testtelus.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.telus.testtelus.entity.Candidate;
import com.telus.testtelus.entity.Vote;
import com.telus.testtelus.entity.Voter;
import com.telus.testtelus.repository.CandidateRepository;
import com.telus.testtelus.repository.VoteRepository;
import com.telus.testtelus.repository.VoterRepository;

@Service
public class VoterServiceImpl {
	
	
	    @Autowired
	    @Qualifier("voterRepository")
	    private VoterRepository voterRepository;
	    
	    
	    @Autowired
	    private VoteRepository voteRepository;
	    
	    
	    @Autowired
	    private CandidateRepository candidateRepository;
	    
	    
	    public Voter findByUser(Integer idUser) {

	    	return voterRepository.findByUserId(idUser);
	    }
	    
	    
	    
	    public Vote vote(Integer idCandidate,Integer idVoter) {
	    	
	    	
	    	Vote vote = voteRepository.findOneByCandidateIdAndVoterId(idCandidate, idVoter);
	    	
	    	Candidate candidate = candidateRepository.findOne(idCandidate);
	    	Voter voter = voterRepository.findOne(idVoter);
	    	
	    	if(vote == null) {
	    		
	    		/**
	    		 * Validate no duplicate votes
	    		 */
	    		vote = voteRepository.findOneByIdCandidateAndIdCommittee(idVoter, candidate.getCommitteeId().getId());
	    		
	    		if(vote != null) {
	    			
	    			/**
	    			 * Update candidate per committee
	    			 */
	    			vote.setCandidateId(candidate);
	    			vote.setDate(new Date());
	    			
	    			
	    		}else {
	    			
	    			/**
	    			 * make a new vote per committee
	    			 */
	    			vote = new Vote();
		    		vote.setCandidateId(candidate);
		    		vote.setVoterId(voter);
		    		vote.setDate(new Date());
	    			
	    			
	    		}
	    		
	    	/**
	    	 * Save/Update vote after verification of no duplicates per committee	
	    	 */
	    	vote = voteRepository.save(vote);	
	    		
	    			    		
	    	}
	    	
	    	
	    	return vote;
	    }
	    
	    
	    
	    public Vote findOneByIdVoterAndIdCommittee(Integer idVoter, Integer idCommitte) {
	    	
	    	
	    	return voteRepository.findOneByIdCandidateAndIdCommittee(idVoter, idCommitte);
	    }
	    

}
