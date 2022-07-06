<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% String table = (String) request.getAttribute("table");  %>
		<body>
		 <div>
		 <h1>Details of device</h1>
		  <%=table %> <br><br>
		 </div> <br><br>
		 <input type="submit" value="Add Claim" onCLick="UserClaimController">
		 
		 
</body>
</html>