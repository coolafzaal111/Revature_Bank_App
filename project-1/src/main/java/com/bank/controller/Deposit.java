package com.bank.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.exception.BusinessException;
import com.bank.model.Transaction;
import com.bank.service.BankCRUDService;
import com.bank.service.impl.BankCRUDServiceImpl;

/**
 * Servlet implementation class Deposit
 */
public class Deposit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Deposit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		RequestDispatcher requestDispatcher = null;

		BankCRUDService bankCRUDService= new BankCRUDServiceImpl();
		//Customerservice customerservice = new Customerserviceimpl();
		//HttpSession session = request.getSession(false);
		//int cid = (Integer) session.getAttribute("cid");
		float amount = Float.parseFloat(request.getParameter("amount"));
		//float amount = 10000.0f;
		String username = (request.getParameter("usename"));
		System.out.println(amount);
		System.out.println(username);

		if (amount > 0 && username!= null) {
			try {
				Transaction transaction = null;
				Transaction bal=bankCRUDService.depositAmount(transaction);
				
				//Transaction transaction;
				//bankCRUDService.depositAmount(transaction);
				
				System.out.println(amount);
				System.out.println(username);
			
				response.sendRedirect("welcomecustomer.html");
			
			}catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}} 
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
