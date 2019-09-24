package com.telus.testtelus.model;

public class UserModel {
	
	private Integer id;
	private String username;
	private String password;
	private String email;
	private String name;
	private String surname;
	private int idDocument;
	private Integer idCountry;
	
	
	
	
	public Integer getIdCountry() {
		return idCountry;
	}
	public void setIdCountry(int idCountry) {
		this.idCountry = idCountry;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getIdDocument() {
		return idDocument;
	}
	public void setIdDocument(int idDocument) {
		this.idDocument = idDocument;
	}
	@Override
	public String toString() {
		return "UserModel [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", name=" + name + ", surname=" + surname + ", idDocument=" + idDocument + "]";
	}
	
	
	
	
	
}
