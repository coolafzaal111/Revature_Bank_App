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
import com.bank.service.BankCRUDService;
import com.bank.service.BankLoginService;
import com.bank.service.impl.BankCRUDServiceImpl;
import com.bank.service.impl.BankLoginServiceImpl;

/**
 * Servlet implementation class EmployeeLogin
 */
public class EmployeeLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * Default constructor. 
     */
    public EmployeeLogin() {
    	super();
    	// TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		Bank bank = new Bank();
		bank.setEmpusername(request.getParameter("empid"));
		bank.setEmppassword(request.getParameter("emppassword"));
		BankLoginService bankLoginService = new BankLoginServiceImpl();
		PrintWriter out=response.getWriter();
		RequestDispatcher requestDispatcher = null;
		try {
			//System.out.println("in try");
			if(bankLoginService.employeeLogin(bank)) {
//				HttpSession session=request.getSession();
//				session.setAttribute("empusername", bank.getEmpusername());
				response.sendRedirect("customerdetails.html");
			}
			else {
				requestDispatcher=request.getRequestDispatcher("login.html");
				//requestDispatcher.include(request, response);
				out.print("<center><span style='color:red;'>Invalid Login Credentials</span></center>");
			}
		} catch (BusinessException e) {
			//System.out.println("in catch");
			//out.print("Invalid Details");
			requestDispatcher=request.getRequestDispatcher("login.html");
			requestDispatcher.include(request, response);
			out.print("<center><span style='color:red;'>Invalid Login Credentials</span></center>");
		}
	}

}
