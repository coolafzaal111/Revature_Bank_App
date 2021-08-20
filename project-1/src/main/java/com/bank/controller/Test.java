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
 * Servlet implementation class Test
 */
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*Gson gson = new Gson();
		BankCRUDService bankCrudService=new BankCRUDServiceImpl();
		Bank bank = gson.fromJson(request.getReader(), Bank.class);
		try {
			bank = bankCrudService.customRegistration(bank);
			response.setContentType("application/json;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.print(gson.toJson(bank)); //POJO TO JSON
			response.sendRedirect("openaccount.html");
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
			response.sendRedirect("invalid.html");
		}*/
	}

}
