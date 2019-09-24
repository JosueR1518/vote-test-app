package com.telus.testtelus.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.telus.testtelus.entity.User;
import com.telus.testtelus.entity.Voter;
import com.telus.testtelus.model.UserModel;
import com.telus.testtelus.service.CommitteeServiceImpl;
import com.telus.testtelus.service.CountryServiceImpl;
import com.telus.testtelus.service.SecurityServiceImpl;
import com.telus.testtelus.service.UserServiceImpl;
import com.telus.testtelus.service.VoterServiceImpl;



@Controller
public class UserController {
	
	
	    @Autowired
	    @Qualifier("userServiceImpl")
	    private UserServiceImpl userService;
	    
	    @Autowired
	    @Qualifier("countryServiceImpl")
	    private CountryServiceImpl countryServiceImpl;
	    
	    @Autowired
	    @Qualifier("voterServiceImpl")
	    private VoterServiceImpl voterService;
	    
	    
	    @Autowired
	    private CommitteeServiceImpl committeeService;
	    
	    
	    
	    
	    @Autowired
	    private SecurityServiceImpl securityService;
	    
	    

	    @GetMapping("/login")
	    public String showFormLogin(Model model,
	            @RequestParam(name = "error", required = false) String error,
	            @RequestParam(name = "logout", required = false) String logout) {
	    	
	        model.addAttribute("error", error);
	        model.addAttribute("logout", logout);
	        
	        
	        return "login";
	    }

	    @GetMapping({"/home", "/"})
	    public String succces(Model model, Principal principal) {
	    	
	    	
	    	
	    	  
	    	User user = securityService.findUser(principal.getName());
	    	
	    	if(user == null) {
	    		 return "redirect:/login";
	    		
	    	}
	    	
	    	  Voter voter = voterService.findByUser(user.getId());
	    	  System.out.println("Datos votante"+voter.toString());
    	      model.addAttribute("committees", committeeService.findByCountry(voter.getCountryId().getId()));
	      
	        return "home";
	    }
	    
	    
	    
	    @GetMapping(value = "/signup")
	    public String singInForm(Model model) {
	    	
	    	
	        model.addAttribute("user", new UserModel());
	        model.addAttribute("countries",countryServiceImpl.findAll());

	        return "signup";
	}
	    
	    
	    @PostMapping(value = "/signup")
	    public String singInSave(@Valid @ModelAttribute(name = "user") UserModel userNew, BindingResult bindingResult) {

	    	
	    	System.out.println(userNew.toString());

	    	 if (bindingResult.hasErrors()) {
	             return "signup";
	    	 }

	    	 userService.save(userNew);
	    	 
	    	 securityService.authenticatedUser(userNew.getUsername(), userNew.getPassword());

	    	 return "redirect:/home";	}

}
