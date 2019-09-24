package com.telus.testtelus.service;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.telus.testtelus.entity.User;
import com.telus.testtelus.repository.UserRepository;

import org.slf4j.Logger;

@Service
public class SecurityServiceImpl {
	
	
	@Autowired
    private AuthenticationManager authenticationManager;

	/*
	 * @Autowired private UserDetailsService userDetailsService;
	 */
    
    @Autowired
    @Qualifier("userCustomeService")
    private UserDetailsService userDetailsService;
    
    
    @Autowired
    @Qualifier("userRepository")
    private UserRepository userRepository;

    
    private static final Logger logger = LoggerFactory.getLogger(SecurityServiceImpl.class);

   
    public User findAunthenticatedUser() {
        Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
        if (userDetails instanceof UserDetails) {
           // return ;
            
            return userRepository.findOneByUsername(((UserDetails)userDetails).getUsername());
        }

        return null;
    }
    
    
    public User findUser(String userName) {
      
            return userRepository.findOneByUsername(userName);
        

       
    }

   
    public void authenticatedUser(String username, String password) {
    	
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());

        authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        if (usernamePasswordAuthenticationToken.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            logger.debug(String.format("Authenticated user: %s successfully!", username));
        }
}

}
