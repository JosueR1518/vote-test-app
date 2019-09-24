package com.telus.testtelus.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telus.testtelus.entity.Candidate;
import com.telus.testtelus.entity.Committee;
import com.telus.testtelus.repository.CandidateRepository;

@Service
public class CandidateServiceImpl {

	
	@Autowired
	private CandidateRepository candidateRepository;
	
	
	
	
	public List<Map<String, Object>>  getRegistered(){
		
		
		List<Candidate> candidates = candidateRepository.findAll(); 
		
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		
		for (Candidate candidate : candidates) {
			Map<String, Object> data = new HashMap();
			
			
			Committee committee = candidate.getCommitteeId();
		    data.put( "surnames", candidate.getSurname() );
		    data.put( "name", candidate.getName());
		    data.put( "email", candidate.getEmail() );
		    data.put( "id_document", candidate.getIdDocument() );
		    data.put( "country", committee.getDepartmentId().getAreaId().getCountryId().getName() );
		    data.put( "department", committee.getDepartmentId().getName());
		    data.put( "committee", committee.getName());
		    
		    list.add(data);
		}
		
		
	    
	    
	    return list;
		
	}
}
