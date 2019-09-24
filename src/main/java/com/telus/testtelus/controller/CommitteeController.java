package com.telus.testtelus.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.telus.testtelus.entity.Candidate;
import com.telus.testtelus.entity.User;
import com.telus.testtelus.entity.Vote;
import com.telus.testtelus.entity.Voter;
import com.telus.testtelus.service.CommitteeServiceImpl;
import com.telus.testtelus.service.SecurityServiceImpl;
import com.telus.testtelus.service.VoterServiceImpl;

@Controller
@RequestMapping("/committee")
public class CommitteeController {
	
	
	
	@Autowired
	private CommitteeServiceImpl  committeeService;
	  

	@Autowired
	private SecurityServiceImpl securityService;
	
    @Autowired
    @Qualifier("voterServiceImpl")
    private VoterServiceImpl voterService;
	    

	
	
	  
    @GetMapping("/{id}/candidates")
    public String showFormLogin(Model model, @PathVariable Integer id, Principal principal ) {
    	
    	
    	
    	List<Candidate> candidates = committeeService.findCandidatesByCommittee(id);
        
    	model.addAttribute("candidates", candidates);
    	model.addAttribute("committee", committeeService.findOneById(id));
    	
    	 User user = securityService.findUser(principal.getName());
    	 Voter voter = voterService.findByUser(user.getId());
    	 
    	Vote vote = voterService.findOneByIdVoterAndIdCommittee(voter.getId(), id);
    	
    	if(vote != null) {
    		model.addAttribute("candidateVoted", vote.getCandidateId().getId());	
    	}else{
    		model.addAttribute("candidateVoted", -1000);
    	}
    	
        
        return "vote";
    }
    
    
    @GetMapping("/vote/{idcandidate}")
    public String voteCandidate(Model model,
    		@PathVariable Integer idcandidate,
    		Principal principal) {
    	
    	
    	  
    	User user = securityService.findUser(principal.getName());
    	
    	 Voter voter = voterService.findByUser(user.getId());
    	 
    	 Vote vote = voterService.vote(idcandidate, voter.getId());
    	
       String message ="";
       String status = "OK";
    	 if(vote != null) {
    		 message= "Vote was saved successful!";
    		 
    		 
    	 }else {
    		 
    		 message = "Vote was not saved!";
    		 status = "ERROR";
    	 }
    	 
    	 model.addAttribute("message", message);
    	 model.addAttribute("status", status);
        
    	 
        return "redirect:/committee/"+vote.getCandidateId().getCommitteeId().getId()+"/candidates" ;
    }

  

}
