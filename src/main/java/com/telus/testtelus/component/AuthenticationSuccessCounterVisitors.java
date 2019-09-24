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
			
			try {
				
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
				
				
				
				
				
				
				String fileName = "visitsPerDay.txt";
				
				FileWriter fw = new FileWriter(fileName,true);
				
				
				//Read file to get last line
				BufferedReader br = new BufferedReader(new FileReader(fileName));
				
				String lastLine = "";
				
				String sCurrentLine;
				String newLine;
				
				StringBuilder sb = new StringBuilder();
				
				while((sCurrentLine = br.readLine()) != null) {
					
					lastLine = sCurrentLine;
				}
				
				br = new BufferedReader(new FileReader(fileName));
				
				while((sCurrentLine = br.readLine()) != null) {
					
					if(lastLine.equals(sCurrentLine)) {
						
						String[] dateOld = lastLine.split("\\|");
						String oldDate = dateOld[0];
						
						
						if(currentDate.equals(oldDate)) {
							int countDay = Integer.parseInt(dateOld[1]);
							countDay++;
							
							sb.append(oldDate+"|"+countDay);
							sb.append("\n");
						}
						else {
							
							sb.append(oldDate+"|"+dateOld[1]);
							sb.append("\n");
							sb.append(currentDate+"|"+1);
							sb.append("\n");
						}
						
						
					}
					else {
						
						sb.append(sCurrentLine);
						sb.append("\n");
						
					}
					
					
					
					
					
				}
				
				//If file has not lines
				if(lastLine == "") {
					
					
					newLine = currentDate+"|"+"1";
					fw.write(newLine);
					
					
				}else {
					FileWriter fws = new FileWriter(fileName);
					fws.write(sb.toString());
					fws.close();
				}
				
				fw.close();
			

				
				
				
			} catch (FileNotFoundException | UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
		
	

}
