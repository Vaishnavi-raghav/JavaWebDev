package javawebapplication.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javawebapplication.Model.UserModel;
import javawebapplication.bean.UserBean;
import javawebapplication.utility.DataUtility;
import javawebapplication.utility.ServletUtility;
@WebServlet(name = "user",urlPatterns = {"/user"})
public class user extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public user() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//RequestDispatcher rd = request.getRequestDispatcher(JWAView.UserView);	
		//rd.forward(request, response);
		UserModel model = new UserModel();
		long id = DataUtility.getLong(request.getParameter("id"));
		if(id>0) {
			UserBean bean = null;
			bean = model.FindByPk(id);
			request.setAttribute("bean", bean);
		}
	
		ServletUtility.forward(JWAView.UserView, request, response);}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserBean user = new UserBean();
	    user.setFirstName(request.getParameter("firstName"));
	    user.setLastName(request.getParameter("lastName"));
	    user.setLogin(request.getParameter("login"));
	    user.setPassword(request.getParameter("password"));
	    user.setDob(DataUtility.getDate(request.getParameter("dob")));
	    user.setMobileNo(request.getParameter("mobile"));
	    
	    user.setId(DataUtility.getLong(request.getParameter("id")));
	    
		if (user.getId() > 0) {
			// to update
			long i = UserModel.UpdateUser(user);
			if (i > 0) {
				ServletUtility.setSuccessMessage("User Updated sucessfully", request);
				System.out.println("Updated");
			} else {
				ServletUtility.setErrorMessage("Not Updated", request);
			}
		}
		else {
		long i = UserModel.addUser(user);
		if (i > 0) {
			ServletUtility.setSuccessMessage("User register sucessfully", request);
			System.out.println("adduser");

		} else {
			ServletUtility.setErrorMessage("Not insterted", request);
		}
		
		}
		
		
		request.getRequestDispatcher(JWAView.UserView).forward(request, response);
	}
}
