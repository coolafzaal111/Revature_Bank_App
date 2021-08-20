package com.bank.controller;

import java.io.IOException;
import com.google.gson.JsonSyntaxException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.exception.BusinessException;
import com.bank.model.Bank;
import com.bank.model.Registration;
import com.bank.service.BankCRUDService;
import com.bank.service.impl.BankCRUDServiceImpl;
import com.google.gson.Gson;

/**
 * Servlet implementation class CustomerRegistration
 */
public class CustomerRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BankCRUDService bankCrudService = new BankCRUDServiceImpl();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**"password": "1212121212121"
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	try{
    		//System.out.println("0");
    		Gson gson = new Gson();
    		Registration registartion = gson.fromJson(request.getReader(), Registration.class);
    		RequestDispatcher requestDispatcher=null;
    		registartion = bankCrudService.customRegistration(registartion);
    		String s=String.valueOf(registartion.getUsername());
    		Cookie c1 = new Cookie("username",s);
			response.addCookie(c1);
			response.setContentType("application/json;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.print(gson.toJson(registartion)); //POJO TO JSON
			//response.sendRedirect("index.html");
			if(registartion.getUsername()!=null) {
				System.out.println("Registration Successful");
				requestDispatcher=request.getRequestDispatcher("login.html");
				requestDispatcher.forward(request, response);
			}else {
				PrintWriter out1=response.getWriter();
				requestDispatcher=request.getRequestDispatcher("index.html");
				requestDispatcher.include(request, response);
				out1.print("<center><span style='color:red;'>invalid credentials</span></center>");
			}
		} catch(IllegalStateException | JsonSyntaxException e)
		{
			System.out.println("catch error");
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			System.out.println("catch 2");
			e.printStackTrace();
		}
    }
}

    	/*try {
    		System.out.println("1");
    	Gson gson = new Gson();
    	System.out.println("2");
    	//Bank bank= new Ban 
    	Bank bank = new Bank();
    	Bank bank = bankCrudService.customRegistration(bank);
    	Bank bank1 = gson.fromJson(request.getReader(), Bank.class);
    	System.out.println("3");
		RequestDispatcher requestDispatcher=null;
		System.out.println("4");
		
			bank1 = bankCrudService.customRegistration(bank1);
			System.out.println("5");
			response.setContentType("application/json;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.print(gson.toJson(bank1)); //POJO TO JSON
			if(bank1!=null) {
				System.out.println("Registration Successful");
				requestDispatcher=request.getRequestDispatcher("success");
				requestDispatcher.forward(request, response);
			}else {
				PrintWriter out1=response.getWriter();
				requestDispatcher=request.getRequestDispatcher("index.html");
				requestDispatcher.include(request, response);
				out1.print("<center><span style='color:red;'>invalid credentials</span></center>");
			}
		}catch(IllegalStateException | JsonSyntaxException e)
		{
			System.out.println("catch error");
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}*/
	
