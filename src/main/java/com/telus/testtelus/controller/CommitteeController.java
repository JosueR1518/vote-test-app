package com.telus.testtelus.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.telus.testtelus.entity.Candidate;
import com.telus.testtelus.entity.User;
import com.telus.testtelus.entity.Voter;
import com.telus.testtelus.service.CommitteeServiceImpl;

@Controller
public class CommitteeController {
	
	
	
	@Autowired
	private CommitteeServiceImpl  committeeService;
	  

	
	
	  
    @GetMapping("/committee/{id}/candidates")
    public String showFormLogin(Model model, @PathVariable Integer idCommittee ) {
    	
    	
    	
    	List<Candidate> candidates = committeeService.findCandidatesByCommittee(idCommittee);
        
    	model.addAttribute("candidates", candidates);
   
        
        
        return "vote";
    }
    
    
    @GetMapping("/committee/candidates")
    public String voteCandidate(Model model,
            @RequestParam(name = "error", required = false) String error,
            @RequestParam(name = "logout", required = false) String logout) {
    	
        model.addAttribute("error", error);
        model.addAttribute("logout", logout);
        
        
        return "login";
    }

  

}
