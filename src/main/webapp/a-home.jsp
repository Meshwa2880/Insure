<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>Admin Home</title>
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
						href="AdminHomeController">Home</a></li>
				</ul>
				<ul class="navbar-nav flex-grow-1">
					<li class="nav-item"><a class="nav-link text-white"
						href="index.jsp">Logout</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container p-2">
		
	
  	<h4 align="center">Welcome Admin</h4>
  	<br>
  	<div class="container">
  	<div class="row">
  		<div class="col justify-content-center">
	  	<!-- View all user accounts -->
	  	<a href="AdminUserSearchController" class="btn btn-outline-dark btn-lg btn-block" role="button">All Users</a>
	  	</div>
	  	
	  	<div class="col justify-content-center">
	  	<!-- View all products -->
	  	<a href="AdminProductSearchController" class="btn btn-outline-dark btn-lg btn-block" role="button">All Products</a>
	  	</div>
	  	
	  	<div class="col justify-content-center">
	  	<!-- Add products -->
	  	<a href="AdminAddProductController" class="btn btn-outline-dark  btn-lg btn-block" role="button">Add New Product</a>
	  	</div>
	  	
	  	<div class="col justify-content-center">
	  	<!-- View claims -->	
	  	<a href="AdminClaimApprovalController" class="btn btn-outline-dark btn-lg btn-block" role="button">Claim Requests</a>
		</div>
		
		<div class="col justify-content-center">
		<!-- View reports -->
	  	<a href="AdminReportsController" class="btn btn-outline-dark btn-lg btn-block" role="button">Reports</a>
	  	</div>
	  	</div>
  	</div>
  	
	</div>
</body>
</html>