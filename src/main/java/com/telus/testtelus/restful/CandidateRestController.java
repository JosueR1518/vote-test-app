package com.telus.testtelus.restful;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.telus.testtelus.service.CandidateServiceImpl;


@RestController
public class CandidateRestController {

	   @Autowired
	   private CandidateServiceImpl  candidateService;
	
	
	
	@RequestMapping(path = "/getRegisteredCandidates", method = RequestMethod.GET)
	public ResponseEntity<Object> getRegisteredCandidates(){
		
		return ResponseEntity.ok(candidateService.getRegistered());
		
	}
	             
}
