package javawebapplication.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javawebapplication.Model.UserModel;
import javawebapplication.bean.UserBean;
import javawebapplication.utility.ServletUtility;

/**
 * Servlet implementation class login
 */
@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//RequestDispatcher rd = request.getRequestDispatcher(JWAView.LoginView);	
		//rd.forward(request, response);
	
		
	String op = request.getParameter("operation");
	System.out.println("Operation:+" +op);
	try {
	if(op.equals("logout")) {
		HttpSession session=request.getSession(false);	
        session.invalidate();
		ServletUtility.setSuccessMessage("Logout Successful", request);
	}
	}catch(Exception e) {
		
	}
	ServletUtility.forward(JWAView.LoginView, request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 
		UserBean user = new UserBean();
	       String login=request.getParameter("login");
	       String pwd=request.getParameter("password");
	       HttpSession session=request.getSession(true);
	       user = UserModel.UserLogin(login,pwd);
	       if(user != null) {
	           //ServletUtility.setSuccessMessage(request.getParameter("login")+ " is login successfully", request);
	           
	    	   session.setAttribute("user", user.getFirstName()); 
	    	   
	    	   ServletUtility.redirect(JWAView.WelcomeCTL, request, response);
	      
	       }else {
	           ServletUtility.setErrorMessage("Invalid User", request);
	           ServletUtility.forward(JWAView.LoginView , request, response);
	       }
	  }
	}

  
