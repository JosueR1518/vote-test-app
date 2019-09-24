package com.telus.testtelus.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.telus.testtelus.repository.UserRepository;




@Service("userCustomeService")
public class UserDetailsCustomeService implements UserDetailsService {

	
	
	@Autowired
    @Qualifier("userRepository")
    private UserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		   com.telus.testtelus.entity.User  user = userRepository.findByUsername(username);
	        List<GrantedAuthority> authorities = builAuthorities(user.getRoles());

	        return new User(user.getUsername(), user.getPassword(), true, true, true, true, authorities);
	}
	
	

	
	  //agregando todos los roles los nombres
    private List<GrantedAuthority> builAuthorities(List<String> userRoles) {

        Set<GrantedAuthority> auths = new HashSet<>();
        for (String userRole : userRoles) {
            auths.add(new SimpleGrantedAuthority(userRole.toString()));
        }
        return new ArrayList<>(auths);
    }
	  
}
