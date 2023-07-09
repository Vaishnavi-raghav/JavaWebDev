<%@page import="javawebapplication.bean.UserBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="javawebapplication.utility.ServletUtility"%>
<%@page import="java.util.List"%>
<%@ include file="header.jsp"%>

<h3 style="color: green;"><%=ServletUtility.getSuccessMessage(request)%></h3>

<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">FName</th>
      <th scope="col">LName</th>
      <th scope="col">Login</th>
      <th scope="col">Password</th>
      <th scope="col">MobileNo</th>
      <th scope="col">Date of Birth</th>
       <th scope="col">Action</th>
      
    </tr>
  </thead>

<%
int index = 1;
List list = ServletUtility.getList(request);
Iterator it = list.iterator();
while(it.hasNext())
		{
	UserBean user = (UserBean)it.next();

%>

  <tbody>
  <tr>
      <th scope="row"><%=user.getId()%></th>
      <td><%=user.getFirstName()%></td>
      <td><%=user.getLastName()%></td>
      <td><%=user.getLogin()%></td>
      <td><%=user.getPassword()%></td>
      <td><%=user.getMobileNo()%></td>
      <td><%=user.getDob()%></td>
      <td><a href="user?id=<%=user.getId()%>">Edit</a></td>
      <td><a class="btn btn-danger" href="UserListCTL?id=<%=user.getId()%>">Delete</a></td>
       
  </tr>
  <%}%>
  </tbody>
</table>
<%@ include file="footer.jsp"%>