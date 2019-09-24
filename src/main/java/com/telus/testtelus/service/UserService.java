/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telus.testtelus.service;

import java.sql.Date;
import java.util.List;

import com.telus.testtelus.entity.User;
import com.telus.testtelus.entity.VisitorCounter;
import com.telus.testtelus.model.UserModel;

/**
 *
 * @author jaml
 */
public interface UserService {
    
    
    
     public abstract void save(UserModel user);

     public abstract User findByUsername(String username);
     
     
     
     public abstract VisitorCounter findByDate(String date);
     public abstract List<VisitorCounter> findAllVisitorCounter(String date);
     public abstract VisitorCounter updateVisitorCounter(VisitorCounter visitor);
}
