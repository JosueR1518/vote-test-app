package com.telus.testtelus.component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

import com.telus.testtelus.entity.VisitorCounter;
import com.telus.testtelus.service.UserServiceImpl;

@Component
public class AuthenticationSuccessCounterVisitors  implements  ApplicationListener<AuthenticationSuccessEvent> {

	
	
	    @Autowired
	    private UserServiceImpl userService;
	    
	    
		@Override
		public void onApplicationEvent(final AuthenticationSuccessEvent event) {
		
				DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				Date dateCurrent = new Date();
				String currentDate = formatter.format(dateCurrent);
				
				/**
				 * Save/Update visits to the WebApp
				 */
				
				VisitorCounter visitCounter = userService.findByDate(currentDate);
				
				if(visitCounter != null) {
					visitCounter.setQuantity(visitCounter.getQuantity()+ 1);
					
				}else {
					visitCounter = new VisitorCounter();
					visitCounter.setDate(currentDate);
					visitCounter.setQuantity(1);
				}
				
				visitCounter = userService.updateVisitorCounter(visitCounter);
				
	}
		
	

}
