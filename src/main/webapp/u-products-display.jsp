<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<title>Registration</title>

</head>

<body>
	<nav
		class="navbar navbar-expand-sm navbar-toggleable-sm navbar-light bg-dark border-bottom box-shadow mb-3">
		<div class="container">
			<a class="navbar-brand text-white">ABC Company</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target=".navbar-collapse"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="navbar-collapse collapse d-sm-inline-flex ">
				<ul class="navbar-nav flex-grow-1">
					<li class="nav-item"><a class="nav-link text-white"
						href="index.jsp">Logout</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container p-2">
		<%
		String username = (String) request.getAttribute("username");
		%>
		<%
		String table = (String) request.getAttribute("table");
		%>

		<div class="col">
			<h3 align="center">
				Welcome
				<%=username%>
				!
			</h3>
		</div>
		<div class="table">
			<h5>Registered devices</h5>
			<%=table%>
		</div>
		<form method="get" action="u-product-registration.jsp">
			<button type="submit">Register New Device</button>
		</form>
	</div>
</body>
</html>