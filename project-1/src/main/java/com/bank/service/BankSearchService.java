package com.bank.service;

import com.bank.exception.BusinessException;
import com.bank.model.Account;

public interface BankSearchService {
	public Account getBalanceByCustUserName(String custusername) throws BusinessException;

}
