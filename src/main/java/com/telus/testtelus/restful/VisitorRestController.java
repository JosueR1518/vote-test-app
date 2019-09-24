package com.telus.testtelus.restful;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.telus.testtelus.service.UserServiceImpl;

@RestController
public class VisitorRestController {

	
	@Autowired
	private UserServiceImpl userService;
	
	@RequestMapping(path = "/getVisitorsReport", method = RequestMethod.GET)
	public ResponseEntity<Object> getRegisteredCandidates(){
		
		return ResponseEntity.ok(userService.getVisitorsReport());
		
	}
}
