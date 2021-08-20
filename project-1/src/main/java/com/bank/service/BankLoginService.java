package com.bank.service;

import com.bank.exception.BusinessException;
import com.bank.model.Bank;
import com.bank.model.Customer;

public interface BankLoginService {
	public boolean custLogin(Customer customer) throws BusinessException;
	public boolean employeeLogin(Bank bank) throws BusinessException;
	

}
