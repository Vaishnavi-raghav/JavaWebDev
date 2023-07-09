<%@page import="javawebapplication.utility.ServletUtility"%>

<%@ include file="header.jsp"%>
<body>
	<!--header ends here-->
	<!--content starts here-->
	<div class="home-content-wrapper">
		<div class="overlay-box">
			<div class="container">
			<br><br>
			<center><b><%="Welcome "+session.getAttribute("user")%></b></center>
<h1><b><center>Login Successful</center></b></h1>
			</div>
		</div>
	</div>

<br>

<%@ include file="footer.jsp"%>
</body>
</html>