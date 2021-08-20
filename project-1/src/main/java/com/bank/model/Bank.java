package com.bank.model;

public class Bank {
	//for user registration
	private String name;
	private String email;
	private String username;
	private String password;
	private int mobileno;
	
	//for employee login
	private String empusername;
	private String emppassword;
	
	//for bank account opening
	private String custusername;
	private String custfname;
	private String custlname;
	private String custdob;
	private String custadhar;
	private String custpan;
	private String custcity;
	private String custstate;
	private Float custopeningbalance;
	
	public Bank() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Bank(String name, String email, String username, String password, int mobileno) {
		super();
		this.name = name;
		this.email = email;
		this.username = username;
		this.password = password;
		this.mobileno = mobileno;
	}
	

	

	public Bank(String empusername, String emppassword) {
		super();
		this.empusername = empusername;
		this.emppassword = emppassword;
	}
	
	



	public Bank(String custusername, String custfname, String custlname, String custdob, String custadhar,
			String custpan, String custcity, String custstate, Float custopeningbalance) {
		super();
		this.custusername = custusername;
		this.custfname = custfname;
		this.custlname = custlname;
		this.custdob = custdob;
		this.custadhar = custadhar;
		this.custpan = custpan;
		this.custcity = custcity;
		this.custstate = custstate;
		this.custopeningbalance = custopeningbalance;
	}
	
	



	public String getCustusername() {
		return custusername;
	}



	public void setCustusername(String custusername) {
		this.custusername = custusername;
	}



	public String getCustfname() {
		return custfname;
	}



	public void setCustfname(String custfname) {
		this.custfname = custfname;
	}



	public String getCustlname() {
		return custlname;
	}



	public void setCustlname(String custlname) {
		this.custlname = custlname;
	}



	public String getCustdob() {
		return custdob;
	}



	public void setCustdob(String custdob) {
		this.custdob = custdob;
	}



	public String getCustadhar() {
		return custadhar;
	}



	public void setCustadhar(String custadhar) {
		this.custadhar = custadhar;
	}



	public String getCustpan() {
		return custpan;
	}



	public void setCustpan(String custpan) {
		this.custpan = custpan;
	}



	public String getCustcity() {
		return custcity;
	}



	public void setCustcity(String custcity) {
		this.custcity = custcity;
	}



	public String getCuststate() {
		return custstate;
	}



	public void setCuststate(String custstate) {
		this.custstate = custstate;
	}



	public Float getCustopeningbalance() {
		return custopeningbalance;
	}



	public void setCustopeningbalance(Float custopeningbalance) {
		this.custopeningbalance = custopeningbalance;
	}



	public String getEmpusername() {
		return empusername;
	}



	public void setEmpusername(String empusername) {
		this.empusername = empusername;
	}



	public String getEmppassword() {
		return emppassword;
	}



	public void setEmppassword(String emppassword) {
		this.emppassword = emppassword;
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
		return "Bank [name=" + name + ", email=" + email + ", username=" + username + ", password=" + password
				+ ", mobileno=" + mobileno + ", empusername=" + empusername + ", emppassword=" + emppassword
				+ ", custusername=" + custusername + ", custfname=" + custfname + ", custlname=" + custlname
				+ ", custdob=" + custdob + ", custadhar=" + custadhar + ", custpan=" + custpan + ", custcity="
				+ custcity + ", custstate=" + custstate + ", custopeningbalance=" + custopeningbalance + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((emppassword == null) ? 0 : emppassword.hashCode());
		//result = prime * result + ((empusername == null) ? 0 : empusername.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bank other = (Bank) obj;
		if (emppassword == null) {
			if (other.emppassword != null)
				return false;
		} else if (!emppassword.equals(other.emppassword))
			return false;
		if (empusername == null) {
			if (other.empusername != null)
				return false;
		} else if (!empusername.equals(other.empusername))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	
	

}
