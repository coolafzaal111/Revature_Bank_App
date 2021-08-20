package com.bank.service;

import java.util.List;

import com.bank.exception.BusinessException;
import com.bank.model.Account;
import com.bank.model.Bank;
import com.bank.model.Registration;
import com.bank.model.Transaction;

public interface BankCRUDService {
	
	public Registration customRegistration(Registration registration) throws BusinessException;
	public Bank openCustomerAccount(Bank bank) throws BusinessException;
	public Transaction depositAmount(Transaction transaction) throws BusinessException;
	public List<Bank> getCustomerDetails() throws BusinessException;
	public List<Account> getCustomerAccountDetails() throws BusinessException;
	public Transaction withdrawAmount(Transaction transaction) throws BusinessException;
	
}
