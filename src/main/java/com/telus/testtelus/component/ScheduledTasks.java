package com.telus.testtelus.component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.telus.testtelus.model.CommitteeModel;
import com.telus.testtelus.service.CommitteeServiceImpl;

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    private static final String subjectMail = "Resume of committees statictics (10 AM CST)";
    
    private static final String subjectMessage = "Committees statictics (10 AM CST)";
	private static final String[] recipients = {
			"shopicars.sv@gmail.com"/* ,"ties_dataintegration@telusinternational.com​" */};
    
    
    @Autowired
    private CommitteeServiceImpl committeeService;
    
    @Autowired
    private JavaMailSender javaMailSender;
	

	/*
	 * @Scheduled(fixedRate = 5000) public void reportCurrentTime() {
	 * log.info("The time is now {}", dateFormat.format(new Date())); }
	 * 
	 */
    
    @Scheduled(cron = "0 * 10 24 * ?", zone = "CST")
    public void reportCommitteesStatistics() {
    	
    	log.info("The time is now in CST {}", dateFormat.format(new Date()));
    
    	
    	 

            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setTo(recipients);

            msg.setSubject(subjectMessage);
         

            List<CommitteeModel> committeesstatictics =  committeeService.getCommitteesStatistics();
            
            
            String jsonData = new Gson().toJson(committeesstatictics);
            msg.setText(subjectMail+"\n\n I have attached the statistics of committees in JSON format, \n\n"+jsonData);
            
            javaMailSender.send(msg);
    	
    	
    
    
    }
    
    
    
}