package com.bank.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.exception.BusinessException;
import com.bank.service.BankCRUDService;
import com.bank.service.impl.BankCRUDServiceImpl;

/**
 * Servlet implementation class Withdraw
 */
public class Withdraw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Withdraw() {
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
		long accountno = Long.parseLong(request.getParameter("accountno"));
		System.out.println(amount);
		System.out.println(accountno);
		float bal=-10;
		
			if (amount > 0 && accountno!= 0 && bal> amount ) {
			System.out.println(amount);
			System.out.println(accountno);

			response.sendRedirect("welcomecustomer.html");

		} else {
			out.print("<center><span><b><i>Withdrawl Failed</center></span></b></i>");
			requestDispatcher = request.getRequestDispatcher("welcomecustomer.html");

	}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
