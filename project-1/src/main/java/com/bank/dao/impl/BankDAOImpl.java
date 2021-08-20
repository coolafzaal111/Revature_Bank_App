package com.bank.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.prefs.BackingStoreException;

import org.apache.log4j.Logger;

import com.bank.dbutil.PostgresConnection;
import com.bank.exception.BusinessException;
import com.bank.controller.EmployeeLogin;
import com.bank.dao.BankDAO;
import com.bank.model.Account;
import com.bank.model.Bank;
import com.bank.model.Customer;
import com.bank.model.Registration;
import com.bank.model.Transaction;

public class BankDAOImpl implements BankDAO{
	private static Logger log=Logger.getLogger(EmployeeLogin.class);

	public Registration customRegistration(Registration registration) throws BusinessException {
		
		try(Connection connection=PostgresConnection.getConnection()){
			String sql="insert into bank_schema.customer_registeration(name,email,username,password,mobileno) values(?,?,?,?,?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, registration.getName());
			preparedStatement.setString(2, registration.getEmail());
			preparedStatement.setString(3, registration.getUsername());
			preparedStatement.setString(4, registration.getPassword());
			preparedStatement.setInt(5, registration.getMobileno());
			
			int c=preparedStatement.executeUpdate();
			if(c!=1) {
				System.out.println("No row Affected");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.warn(e.getMessage());
			throw new BusinessException("Internal Error Occured....Kindly contact your SysAdmin!!");
		}
		
		return registration;
	}

	@Override
	public boolean custLogin(Customer customer) throws BusinessException {
		boolean b=false;
		try(Connection connection= PostgresConnection.getConnection()){
			String sql="select username,password from bank_schema.customer_registeration where username=? and password=?";
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setString(1, customer.getUsername());
			preparedStatement.setString(2, customer.getPassword());
			ResultSet resultSet= preparedStatement.executeQuery();
			if(resultSet.next()) {
				b=true;
			}else {
				throw new BusinessException("Invaid Login Credentials");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.warn(e.getMessage());
			throw new BusinessException("Internal Error Occured...contact SysAdmin");
		}
		return b;

	}

	@Override
	public boolean employeeLogin(Bank bank) throws BusinessException {
		boolean b=false;
		try(Connection connection=PostgresConnection.getConnection()){
			String sql="select empusername,emppassword from bank_schema.employee_details where empusername=? and emppassword=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, bank.getEmpusername());
			preparedStatement.setString(2, bank.getEmppassword());
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				b=true;
			}else {
				throw new BusinessException("Invaid Login Credentials");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.warn(e.getMessage());
			throw new BusinessException("Internal Error Occured...contact SysAdmin");
		}
		return b;
	}

	@Override
	public Bank openCustomerAccount(Bank bank) throws BusinessException {
		try(Connection connection=PostgresConnection.getConnection()){
			String sql="insert into bank_schema.customer_acc_details(custusername,custfname,custlname,custdob,custadhar,custpan,custcity,custstate,custopeningbalance) values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, bank.getCustusername());
			preparedStatement.setString(2, bank.getCustfname());
			preparedStatement.setString(3, bank.getCustlname());
			preparedStatement.setString(4, bank.getCustdob());
			preparedStatement.setString(5, bank.getCustadhar());
			preparedStatement.setString(6, bank.getCustpan());
			preparedStatement.setString(7, bank.getCustcity());
			preparedStatement.setString(8, bank.getCuststate());
			preparedStatement.setFloat(9, bank.getCustopeningbalance());
			int c=preparedStatement.executeUpdate();
			if(c!=1) {
				System.out.println("No row Affected");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.warn(e.getMessage());
			throw new BusinessException();
		}
		return bank;
	}

	@Override
	public Transaction depositAmount(Transaction transaction) throws BusinessException {
		try(Connection connection=PostgresConnection.getConnection()){
			String sql="insert into bank_schema.transaction_details(trantype,openingbalance,tranamount,closingbalance,custusername) values(?,?,?,?,?)";
			String sql1="update bank_schema.customer_acc_details set custopeningbalance=? where custusername=?";
			PreparedStatement preparedStatement= connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			PreparedStatement preparedStatement1= connection.prepareStatement(sql1);
			preparedStatement.setString(1, transaction.getTrantype());
			preparedStatement.setFloat(2, transaction.getOpeningbalance());
			preparedStatement.setFloat(3, transaction.getTranamount());
			preparedStatement.setFloat(4, transaction.getClosingbalance());
			preparedStatement.setString(5, transaction.getCustusername());
			preparedStatement1.setFloat(1, transaction.getClosingbalance());
			preparedStatement1.setString(2, transaction.getCustusername());
			int c= preparedStatement.executeUpdate();
			int c1= preparedStatement.executeUpdate();
			if(c==1 && c1==1) {
				ResultSet resultSet= preparedStatement.getGeneratedKeys();
				if(resultSet.next()) {
					transaction.setTranid(resultSet.getInt(6));
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.warn(e.getMessage());
			throw new BusinessException();
		}
		return transaction;
	}

	@Override
	public Account getBalanceByCustUserName(String custusername) throws BusinessException {
		Account account= new Account();
		try(Connection connection=PostgresConnection.getConnection()){
			String sql="select custusername,custopeningbalance from bank_schema.customer_acc_details where custusername=?";
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setString(1, custusername);
			ResultSet resultSet= preparedStatement.executeQuery();
			if(resultSet.next()) {
				account.setCustusername(resultSet.getString("custusername"));
				account.setCustopeningbalance(resultSet.getFloat("custopeningbalance"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.warn(e.getMessage());
			throw new BusinessException();
		}
		return null;
	}

	@Override
	public List<Bank> getCustomerDetails() throws BusinessException {
		List<Bank> customList= new ArrayList<>();
		try(Connection connection=PostgresConnection.getConnection()){
			String sql= "select custusername,custfname,custlname,custdob,custadhar,custpan,custcity,custstate,custopeningbalance from bank_schema.customer_acc_details";
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			ResultSet resultSet= preparedStatement.executeQuery();
			while(resultSet.next()) {
				Bank bank= new Bank();
				bank.setCustusername(resultSet.getString("custusername"));
				bank.setCustfname(resultSet.getString("custfname"));
				bank.setCustlname(resultSet.getString("custlname"));
				bank.setCustdob(resultSet.getString("custdob"));
				bank.setCustadhar(resultSet.getString("custadhar"));
				bank.setCustpan(resultSet.getString("custpan"));
				bank.setCustcity(resultSet.getString("custcity"));
				bank.setCuststate(resultSet.getString("custstate"));
				bank.setCustopeningbalance(resultSet.getFloat("custopeningbalance"));
				customList.add(bank);
			}
			if(customList.size()==0) {
				throw new BusinessException("No customer found");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.warn(e.getMessage());
			throw new BusinessException();
		}
		return customList;
	}

	@Override
	public List<Account> getCustomerAccountDetails() throws BusinessException {
		List<Account> accountList= new ArrayList<>();
		try(Connection connection=PostgresConnection.getConnection()){
			String sql="select custusername,custfname,custopeningbalance from bank_schema.customer_acc_details";
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			ResultSet resultSet= preparedStatement.executeQuery();
			while(resultSet.next()) {
				Account account= new Account();
				account.setCustusername(resultSet.getString("custusername"));
				account.setCustfname(resultSet.getString("custfname"));
				account.setCustopeningbalance(resultSet.getFloat("custopeningbalance"));
				accountList.add(account);
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.warn(e.getMessage());
			throw new BusinessException();
		}
		return accountList;
	}

	@Override
	public Transaction withdrawAmount(Transaction transaction) throws BusinessException {
		try(Connection connection=PostgresConnection.getConnection()){
			String sql="insert into bank_schema.transaction_details(trantype,openingbalance,tranamount,closingbalance,custusername) values(?,?,?,?,?)";
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setString(1, transaction.getTrantype());
			preparedStatement.setFloat(2, transaction.getOpeningbalance());
			preparedStatement.setFloat(3, transaction.getTranamount());
			preparedStatement.setFloat(4, transaction.getClosingbalance());
			preparedStatement.setString(5, transaction.getCustusername());
			String sql1="update bank_schema.customer_acc_details set custopeningbalance=? where custusername=?";
			PreparedStatement preparedStatement1= connection.prepareStatement(sql1);
			preparedStatement1.setFloat(1, transaction.getClosingbalance());
			preparedStatement1.setString(2, transaction.getCustusername());
			int c= preparedStatement.executeUpdate();
			int c1= preparedStatement.executeUpdate();
			if(c==1 && c1==1) {
				ResultSet resultSet= preparedStatement.getGeneratedKeys();
				if(resultSet.next()) {
					transaction.setTranid(resultSet.getInt(6));
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.warn(e.getMessage());
			throw new BusinessException();
		}
		return null;
	}

	

	private void transaction(String s, long accountno) {
		// TODO Auto-generated method stub
		
	}

	

	

	/*@Override
	public List<Transaction> getTransactionDetail(String custusername) throws BusinessException {
		List<Transaction> transactionList= new ArrayList<>();
		try(Connection connection=PostgresConnection.getConnection()){
			String sql="select trantype,openingbalance,tranamount,closingbalance,custusername,tranid from bank_schema.transaction_details where custusername=?";
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setString(1, custusername);
			ResultSet resultSet= preparedStatement.executeQuery();
			while(resultSet.next()) {
				Transaction transaction= new Transaction();
				transaction.setTrantype(resultSet.getString("tantype"));
				transaction.setOpeningbalance(resultSet.getFloat("openingbalance"));
				transaction.setTranamount(resultSet.getFloat("tranamount"));
				transaction.setClosingbalance(resultSet.getFloat("closingbalance"));
				transaction.setCustusername(resultSet.getString("custusername"));
				transaction.setTranid(resultSet.getInt("tranid"));
				transactionList.add(transaction);
			}
			if(transactionList.size()==0) {
				throw new BusinessException("No transaction has commpleted to show");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.warn(e.getMessage());
			throw new BusinessException();
		}
		return transactionList;
	}*/

	
	
	

}
