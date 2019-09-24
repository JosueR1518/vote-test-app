package com.telus.testtelus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.telus.testtelus.entity.Country;
import com.telus.testtelus.repository.CountryRepository;

@Service("countryServiceImpl")
public class CountryServiceImpl {
	
	
	
	    @Autowired
	    @Qualifier("countryRepository")
	    private CountryRepository countryRepository;
	    
	    
	   public  List<Country> findAll(){
	    	
	    return this.countryRepository.findAll();
	    	
	    }
	    
	

}
