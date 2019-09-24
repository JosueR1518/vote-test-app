package com.telus.testtelus.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telus.testtelus.entity.Country;

@Repository("countryRepository")
public interface CountryRepository extends JpaRepository<Country, Serializable>{

}
