package com.bank.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.exception.BusinessException;
import com.bank.model.Bank;
import com.bank.service.BankCRUDService;
import com.bank.service.impl.BankCRUDServiceImpl;
import com.google.gson.Gson;

/**
 * Servlet implementation class CustomerCrud
 */
public class CustomerCrud extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerCrud() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    BankCRUDService bankCrudService = new BankCRUDServiceImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
  		Gson gson=new Gson();
  		PrintWriter out=response.getWriter();
  		try {
  			out.print(gson.toJson(bankCrudService.getCustomerDetails()));
  		} catch (BusinessException e) {
  			System.out.println(e.getMessage());
  		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new Gson();
		Bank bank = gson.fromJson(request.getReader(),Bank.class);
		try {
			bank = bankCrudService.openCustomerAccount(bank);
			//System.out.println(bank);
			response.setContentType("application/json;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.print(gson.toJson(bank)); //POJO TO JSON
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
