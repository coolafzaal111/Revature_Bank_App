package com.bank.dao;

import java.util.List;

import com.bank.exception.BusinessException;
import com.bank.model.Account;
import com.bank.model.Bank;
import com.bank.model.Customer;
import com.bank.model.Registration;
import com.bank.model.Transaction;

public interface BankDAO {
	
	public Registration customRegistration(Registration registration) throws BusinessException;
	public boolean custLogin(Customer customer) throws BusinessException;
	public boolean employeeLogin(Bank bank) throws BusinessException;
	public Bank openCustomerAccount(Bank bank) throws BusinessException;
	public Transaction depositAmount(Transaction transaction) throws BusinessException;
	public Account getBalanceByCustUserName(String custusername) throws BusinessException;
	public List<Bank> getCustomerDetails() throws BusinessException;
	public List<Account> getCustomerAccountDetails() throws BusinessException;
	public Transaction withdrawAmount(Transaction transaction) throws BusinessException;
	//public List<Transaction> getTransactionDetail(String custusername) throws BusinessException;
	

}
