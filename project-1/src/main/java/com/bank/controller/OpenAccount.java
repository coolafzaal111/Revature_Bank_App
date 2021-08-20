package com.bank.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.exception.BusinessException;
import com.bank.model.Account;
import com.bank.model.Bank;
import com.bank.service.BankCRUDService;
import com.bank.service.impl.BankCRUDServiceImpl;
import com.google.gson.Gson;

/**
 * Servlet implementation class OpenAccount
 */
public class OpenAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OpenAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Gson gson = new Gson();
		Bank bank= gson.fromJson(request.getReader(), Bank.class);
		//Account account = gson.fromJson(request.getReader(), Account.class);
		//account.setCustomerid(id);
		try {
			BankCRUDService bankCRUDService= new BankCRUDServiceImpl();
			bank = bankCRUDService.openCustomerAccount(bank);
			response.setContentType("application/json;charset=UTF-8");
			PrintWriter out=response.getWriter();
			//System.out.println(bank);
			out.print(gson.toJson(bank)); //POJO TO JSON
			response.sendRedirect("customerwelcomepage.html");
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
			response.sendRedirect("Invalidemployee.html");
		}
	}

}
