package com.telus.testtelus.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CandidateModel {
	
	    private String surnames;
	   
	    private String name;
	    private String email;
	    private int idDocument;
	    private String country;
	    private String department;
	    private String committtee;
	    
	    
	    
		public String getSurnames() {
			return surnames;
		}
		public void setSurnames(String surnames) {
			this.surnames = surnames;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public int getIdDocument() {
			return idDocument;
		}
		public void setIdDocument(int idDocument) {
			this.idDocument = idDocument;
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
		public void setDepartment(String department) {
			this.department = department;
		}
		public String getCommitttee() {
			return committtee;
		}
		public void setCommitttee(String committtee) {
			this.committtee = committtee;
		}

	    
	    
}
