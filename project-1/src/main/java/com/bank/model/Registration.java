package com.bank.model;

public class Registration {
	private String name;
	private String email;
	private String username;
	private String password;
	private int mobileno;
	
	public Registration() {
		// TODO Auto-generated constructor stub
	}

	public Registration(String name, String email, String username, String password, int mobileno) {
		super();
		this.name = name;
		this.email = email;
		this.username = username;
		this.password = password;
		this.mobileno = mobileno;
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

	public int getMobileno() {
		return mobileno;
	}

	public void setMobileno(int mobileno) {
		this.mobileno = mobileno;
	}

	@Override
	public String toString() {
		return "Registration [name=" + name + ", email=" + email + ", username=" + username + ", password=" + password
				+ ", mobileno=" + mobileno + "]";
	}
	

}
