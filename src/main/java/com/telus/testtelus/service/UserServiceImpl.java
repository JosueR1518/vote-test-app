/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telus.testtelus.service;

import com.telus.testtelus.entity.Country;
import com.telus.testtelus.entity.User;
import com.telus.testtelus.entity.VisitorCounter;
import com.telus.testtelus.entity.Voter;
import com.telus.testtelus.model.UserModel;
import com.telus.testtelus.repository.CountryRepository;
import com.telus.testtelus.repository.UserRepository;
import com.telus.testtelus.repository.VisitorCounterRepository;
import com.telus.testtelus.repository.VoterRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author jaml
 */
@Service("userServiceImpl")
public class UserServiceImpl implements UserService{

    
    @Autowired
    @Qualifier("userRepository")
    private UserRepository userRepository;
    
    @Autowired
    @Qualifier("voterRepository")
    private VoterRepository voterRepository;
    
    @Autowired
    @Qualifier("countryRepository")
    private CountryRepository countryRepository;
    
    
    @Autowired
    private VisitorCounterRepository visitorRepository;
    

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
     
      
    @Override
    public void save(UserModel userModel) {
        
        
    	
    	User user = new User();
        user.setPassword(bCryptPasswordEncoder.encode(userModel.getPassword()));
        user.setUsername(userModel.getUsername());
        
        
        
        user = userRepository.save(user);
        Voter voter = new Voter();
        		
        		 //Assign user as voter
        
       Country  country = countryRepository.findOne(userModel.getIdCountry());
        		
       				//voter.setId(1);
                voter.setIdDocument(userModel.getIdDocument());
                voter.setUserId(user);
                voter.setCountryId(country);
                voter.setName(userModel.getName());
                voter.setSurname(userModel.getSurname());
                voter.setEmail(userModel.getEmail());
                
        System.out.println(voter.toString());
        voter =   voterRepository.save(voter);
        
        

    }

    @Override
    public User findByUsername(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	@Override
	public VisitorCounter findByDate(String date) {
		
		
		return visitorRepository.findOneByDate(date);
	}

	@Override
	public List<VisitorCounter> findAllVisitorCounter(String date) {
		
		return visitorRepository.findAll();
	}

	@Override
	public VisitorCounter updateVisitorCounter(VisitorCounter visitor) {
	
		
		return visitorRepository.save(visitor);
	}
    
    
    
    
}
