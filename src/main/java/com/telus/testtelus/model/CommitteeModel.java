package com.telus.testtelus.model;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.telus.testtelus.entity.Candidate;
import com.telus.testtelus.entity.Department;

public class CommitteeModel {
	
	
	    private String name;
	    private Integer candidates;
	    private String mostVotedCandidate;
	    private String country;
	    private String department;
	    
	    
	    
		public String getMostVotedCandidate() {
			return mostVotedCandidate;
		}
		public void setMostVotedCandidate(String mostVotedCandidate) {
			this.mostVotedCandidate = mostVotedCandidate;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Integer getCandidates() {
			return candidates;
		}
		public void setCandidates(Integer candidates) {
			this.candidates = candidates;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public String getDepartment() {
			return department;
		}
		public void setDepartment(String departmentId) {
			this.department = departmentId;
		}
	    
	    
	    
	    

}
