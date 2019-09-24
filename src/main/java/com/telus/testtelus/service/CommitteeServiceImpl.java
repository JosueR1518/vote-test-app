package com.telus.testtelus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telus.testtelus.entity.Candidate;
import com.telus.testtelus.entity.Committee;
import com.telus.testtelus.repository.CandidateRepository;
import com.telus.testtelus.repository.CommitteeRepository;

@Service("committeeServiceImpl")
public class CommitteeServiceImpl {

	
	@Autowired
	private CommitteeRepository committeeRepository;
	
	
	@Autowired
	private CandidateRepository candidateRepository;
	
	
	
	public List<Committee> findByCountry(Integer idCountry) {
		
		
		return committeeRepository.findByCountry(idCountry);
	}
	
	
	
	public List<Candidate> findCandidatesByCommittee(Integer id) {
		
		
		return candidateRepository.findByCommitteeId(id);
	}
	
	
}
