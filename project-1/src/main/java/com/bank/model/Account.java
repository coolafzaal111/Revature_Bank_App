package com.bank.model;

public class Account {
	private String custusername;
	private String custfname;
	private float custopeningbalance;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}

	
	public Account(String custusername, String custfname, float custopeningbalance) {
		super();
		this.custusername = custusername;
		this.custfname = custfname;
		this.custopeningbalance = custopeningbalance;
	}
	

	public String getCustfname() {
		return custfname;
	}


	public void setCustfname(String custfname) {
		this.custfname = custfname;
	}


	public String getCustusername() {
		return custusername;
	}

	public void setCustusername(String custusername) {
		this.custusername = custusername;
	}

	public float getCustopeningbalance() {
		return custopeningbalance;
	}

	public void setCustopeningbalance(float custopeningbalance) {
		this.custopeningbalance = custopeningbalance;
	}

	@Override
	public String toString() {
		return "Account [custusername=" + custusername + ", custfname=" + custfname + ", custopeningbalance="
				+ custopeningbalance + "]";
	}

	
	

}
