package com.telus.testtelus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.telus.testtelus.entity.Voter;
import com.telus.testtelus.repository.VoterRepository;

@Service
public class VoterServiceImpl {
	
	
	    @Autowired
	    @Qualifier("voterRepository")
	    private VoterRepository voterRepository;
	    
	    
	    
	    
	    
	    public Voter findByUser(Integer idUser) {
	    	
	    	
	    	return voterRepository.findByUserId(idUser);
	    }
	    

}
