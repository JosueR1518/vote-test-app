package com.telus.testtelus.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.telus.testtelus.entity.Committee;

@Repository
public interface CommitteeRepository extends JpaRepository<Committee, Serializable>{

	
	@Query(value = "SELECT c.* FROM committee c "
			+ "INNER JOIN department d ON c.deparment_id = d.id  "
			+ "INNER JOIN area a ON d.area_id = a.id "
			+ "INNER JOIN country co ON a.country_id = co.id "
			+ "WHERE co.id=:idCountry ", nativeQuery = true)
	public abstract List<Committee> findByCountry(@Param("idCountry") Integer idCountry);
	
	
	
	public abstract Committee findOneById(Integer id);
}
