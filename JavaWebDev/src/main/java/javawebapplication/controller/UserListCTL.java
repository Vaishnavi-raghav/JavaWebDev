  package javawebapplication.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javawebapplication.Model.UserModel;
import javawebapplication.utility.DataUtility;
import javawebapplication.utility.ServletUtility;

/**
 * Servlet implementation class UserListCtl
 */
@WebServlet(name="UserListCTL" ,urlPatterns= {"/UserListCTL"})
public class UserListCTL extends HttpServlet {
  private static final long serialVersionUID = 1L;
       
    
    public UserListCTL() {
        super();
        // TODO Auto-generated constructor stub
    }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
	  UserModel model=new UserModel();
	  
	  long id= DataUtility.getLong(request.getParameter("id"));
	  if(id>0) {
		  UserModel.delete(id);
		  ServletUtility.setSuccessMessage("Data Deleted Successfully", request);
	  }
	  
	    List list=null;
	    list=model.list();
	    
	    if(list==null && list.size()==0){
	      ServletUtility.setErrorMessage("Record Not Found", request);
	    }
	    
	    ServletUtility.setList(list, request);
	    ServletUtility.forward(JWAView.UserViewList, request, response);
	    // ServletUtility.forward("jsp/UserViewList.jsp", request, response);
	  }
  
  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }

}