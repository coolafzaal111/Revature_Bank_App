package com.bank.service.impl;

import com.bank.dao.impl.BankDAOImpl;
import com.bank.exception.BusinessException;
import com.bank.dao.BankDAO;
import com.bank.model.Bank;
import com.bank.model.Customer;
import com.bank.service.BankLoginService;

public class BankLoginServiceImpl implements BankLoginService {

	private BankDAO bankDAO= new BankDAOImpl();



	@Override
	public boolean employeeLogin(Bank bank) throws BusinessException {
		boolean b= false;
		if(bank.getEmpusername()!=null && bank.getEmppassword()!=null) {
			b = bankDAO.employeeLogin(bank);
		}else {
			throw new BusinessException("Invalid Details");
		}
		return b;
	}



	@Override
	public boolean custLogin(Customer customer) throws BusinessException {
		boolean b= false;
		if(customer.getUsername()!=null && customer.getPassword()!=null) {
			b = bankDAO.custLogin(customer);
		}else {
			throw new BusinessException("Invalid Details");
		}
		return b;
	}



	

	

}