package com.telus.testtelus.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telus.testtelus.entity.Candidate;
import com.telus.testtelus.entity.Committee;
import com.telus.testtelus.model.CandidateModel;
import com.telus.testtelus.repository.CandidateRepository;

@Service
public class CandidateServiceImpl {

	
	@Autowired
	private CandidateRepository candidateRepository;
	
	
	
	
	public List<CandidateModel>  getRegistered(){
		
		
		List<Candidate> candidates = candidateRepository.findAll(); 
		
		List<CandidateModel> list = new ArrayList<>();
		
		for (Candidate candidate : candidates) {
			CandidateModel data = new CandidateModel();
			
			
			Committee committee = candidate.getCommitteeId();
			
		    data.setSurnames( candidate.getSurname() );
		    data.setName( candidate.getName());
		    data.setEmail( candidate.getEmail() );
		    data.setIdDocument(candidate.getIdDocument() );
		    data.setCountry(committee.getDepartmentId().getAreaId().getCountryId().getName() );
		    data.setDepartment( committee.getDepartmentId().getName());
		    data.setCommitttee( committee.getName());
		    
		    list.add(data);
		}
		
		
	    
	    
	    return list;
		
	}
}
