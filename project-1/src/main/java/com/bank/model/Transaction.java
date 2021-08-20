package com.bank.model;

public class Transaction {
	private String trantype;
	private Float openingbalance;
	private Float tranamount;
	private Float closingbalance;
	private String custusername;
	private int tranid;
	
	public Transaction() {
		// TODO Auto-generated constructor stub
	}

	public Transaction(String trantype, Float openingbalance, Float tranamount, Float closingbalance,
			String custusername) {
		super();
		this.trantype = trantype;
		this.openingbalance = openingbalance;
		this.tranamount = tranamount;
		this.closingbalance = closingbalance;
		this.custusername = custusername;
		this.tranid = tranid;
	}

	public String getTrantype() {
		return trantype;
	}

	public void setTrantype(String trantype) {
		this.trantype = trantype;
	}

	public Float getOpeningbalance() {
		return openingbalance;
	}

	public void setOpeningbalance(Float openingbalance) {
		this.openingbalance = openingbalance;
	}

	public Float getTranamount() {
		return tranamount;
	}

	public void setTranamount(Float tranamount) {
		this.tranamount = tranamount;
	}

	public Float getClosingbalance() {
		return closingbalance;
	}

	public void setClosingbalance(Float closingbalance) {
		this.closingbalance = closingbalance;
	}

	public String getCustusername() {
		return custusername;
	}

	public void setCustusername(String custusername) {
		this.custusername = custusername;
	}

	public int getTranid() {
		return tranid;
	}

	public void setTranid(int tranid) {
		this.tranid = tranid;
	}

	@Override
	public String toString() {
		return "Transaction [trantype=" + trantype + ", openingbalance=" + openingbalance + ", tranamount=" + tranamount
				+ ", closingbalance=" + closingbalance + ", custusername=" + custusername + ", tranid=" + tranid + "]";
	}
	
	

}
