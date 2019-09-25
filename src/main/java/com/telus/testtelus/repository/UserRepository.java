/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telus.testtelus.repository;

import com.telus.testtelus.entity.User;

import java.io.Serializable;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author jaml
 */
@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Serializable>{
 
    
    
	 @Query(value = "SELECT u.* FROM user u WHERE u.username = :username",nativeQuery = true) 
     public abstract User findByUsername(@Param(value = "username") String username);
     
     @Query(value = "SELECT u.* FROM user u WHERE u.username = :username",nativeQuery = true) 
     public abstract User findOneByUsername(@Param(value = "username") String username);

    @Query(value = "SELECT u.* FROM users u WHERE u.username LIKE :username",nativeQuery = true) 
    public abstract List<User> findLikeUsername(@Param(value = "username") String username);
    
}
