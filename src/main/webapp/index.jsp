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
<title>Home Page</title>
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
						href="index.jsp">Home</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div
		style="background-color: #DDDDDD; width: 100%; padding-left: 100px; padding-right: 100px; padding-top: 30px; padding-bottom: 30px">
		<h3 align="center">Welcome.!</h3>
	</div>
	<div class="container p-2">
		<div class="container">
			<div class="row">
				<div class="col justify-content-center p-5">
					<a href="u-registration.jsp"
						class="btn btn-outline-dark btn-lg btn-block" role="button">Register</a>
				</div>
				<div class="col justify-content-center p-5">
					<a href="u-login.jsp"
						class="btn btn-outline-dark btn-lg btn-block" role="button">Login</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>