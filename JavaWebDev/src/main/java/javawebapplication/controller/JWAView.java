package javawebapplication.controller;

public interface JWAView {
	public String APP_CONTEXT = "/JavaWebDev";
	public String PAGE_FOLDER = "/jsp";

	
	public String LoginView = PAGE_FOLDER +"/LoginView.jsp"; 
	public String UserView = PAGE_FOLDER +"/UserView.jsp"; 
	public String homepage = PAGE_FOLDER +"/home.jsp";
	public String WelcomeView = PAGE_FOLDER +"/WelcomeView.jsp";
	public String UserViewList = PAGE_FOLDER +"/UserViewList.jsp";
		
	//using servlet to help manage the urls from the server
	
	public String login = APP_CONTEXT+"/login";
	public String user = APP_CONTEXT+"/user";
	public String homePage = APP_CONTEXT+"/homePage";
    public String WelcomeCTL = APP_CONTEXT+"/WelcomeCTL";
    public String UserListCTL = APP_CONTEXT+"/UserListCTL";
	
	
}
