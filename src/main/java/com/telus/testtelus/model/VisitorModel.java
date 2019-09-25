package com.telus.testtelus.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class VisitorModel {
	
	
	    private Integer id;
	    private String date;
	    private int quantity;
	    private String printFormat;

	    public VisitorModel() {
	    }

	    public VisitorModel(Integer id) {
	        this.id = id;
	    }

	    public VisitorModel(Integer id, String date, int quantity) {
	        this.id = id;
	        this.date = date;
	        this.quantity = quantity;
	        this.printFormat = this.date.toString() +" | #"+this.quantity;
	    }

	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public String getDate() {
	        return date;
	    }

	    public void setDate(String date) {
	        this.date = date;
	    }

	    public int getQuantity() {
	        return quantity;
	    }

	    public void setQuantity(int quantity) {
	        this.quantity = quantity;
	    }

		public String getPrintFormat() {
			return printFormat;
		}

		public void setPrintFormat(String printFormat) {
			this.printFormat = printFormat;
		}
	    
	    

}
