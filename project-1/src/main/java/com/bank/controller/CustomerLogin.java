package com.bank.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.exception.BusinessException;
import com.bank.model.Bank;
import com.bank.model.Customer;
import com.bank.service.BankLoginService;
import com.bank.service.impl.BankLoginServiceImpl;

/**
 * Servlet implementation class CustomerLogin
 */
public class CustomerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.setContentType("text/html");
		Customer customer=new Customer();
		BankLoginService bankLoginService=new BankLoginServiceImpl();
		PrintWriter out=response.getWriter();
		customer.setUsername(request.getParameter("username"));
		customer.setPassword(request.getParameter("password"));
		
		RequestDispatcher requestDispatcher=null;
		try {
			if(bankLoginService.custLogin(customer)) {
				//success
				response.sendRedirect("customerwelcomepage.html");
//				HttpSession session=request.getSession();
//				requestDispatcher=request.getRequestDispatcher("employeewelcomepage.html");
//				requestDispatcher.include(request, response);
			//	requestDispatcher.forward(request, response);
			}
		} catch (BusinessException e) {
			//failure
			requestDispatcher=request.getRequestDispatcher("login.html");
			requestDispatcher.include(request, response);
			out.print("<center><span style='color:red;'>Invalid Customer Login Credentials</span></center>");
			
		}
	}
}

