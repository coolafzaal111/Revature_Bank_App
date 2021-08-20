package com.bank.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.bank.dao.impl.BankDAOImpl;
import com.bank.exception.BusinessException;
import com.bank.dao.BankDAO;
import com.bank.model.Account;
import com.bank.model.Bank;
import com.bank.model.Registration;
import com.bank.model.Transaction;
import com.bank.service.BankCRUDService;

public class BankCRUDServiceImpl implements BankCRUDService {
	private BankDAO bankDAO= new BankDAOImpl();
	/*@Override
	 customRegistration(Registration registration) throws BusinessException{
		if(registration.getName()!=null && registration.getEmail()!=null && registration.getUsername()!=null && registration.getPassword()!=null && registration.getMobileno()!=0) {
			registration= bankDAO.customRegistration(registration);
		}else {
			throw new BusinessException("Invalid Details");
		}
		return registration;
	}*/
	@Override
	public Bank openCustomerAccount(Bank bank) throws BusinessException {
		if(bank.getUsername()!=null && bank.getCustfname()!=null && bank.getCustlname()!=null && bank.getCustdob()!=null && bank.getCustadhar()!=null && bank.getCustpan()!=null && bank.getCustcity()!=null && bank.getCuststate()!=null && bank.getCustopeningbalance()!=0) {
			bank= bankDAO.openCustomerAccount(bank);
		}else {
			throw new BusinessException();
		}
		return bank;
	}
	@Override
	public Transaction depositAmount(Transaction transaction) throws BusinessException {
		transaction= bankDAO.depositAmount(transaction);
		return transaction;
	}
	@Override
	public List<Bank> getCustomerDetails() throws BusinessException {
		Bank bank= new Bank();
		List<Bank> customList= new ArrayList<>();
		customList= bankDAO.getCustomerDetails();
		return customList;
	}
	@Override
	public List<Account> getCustomerAccountDetails() throws BusinessException {
		Bank bank= new Bank();
		List<Account> accountList= new ArrayList<>();
		accountList= bankDAO.getCustomerAccountDetails();
		return accountList;
	}
	@Override
	public Transaction withdrawAmount(Transaction transaction) throws BusinessException {
		transaction= bankDAO.withdrawAmount(transaction);
		return transaction;
	}
	@Override
	public Registration customRegistration(Registration registration) throws BusinessException {
		if(registration.getName()!=null && registration.getEmail()!=null && registration.getUsername()!=null && registration.getPassword()!=null && registration.getMobileno()!=0) {
			registration= bankDAO.customRegistration(registration);
		}else {
			throw new BusinessException("Invalid Details");
		}
		return registration;
	}
	

}
