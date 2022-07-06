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

		<div class="row">
			<div class="col">
				<h3>Register New device</h3>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<form action="UserProductController" method="post">
					<table>
						<tr>
							<td>Enter username:</td>
							<td><input type="text" name="username" class="form-control"
								placeholder="Enter User Name" required></td>
						</tr>
						<tr>
							<td>Enter productname:</td>
							<td><input type="text" name="productname"
								class="form-control" placeholder="Enter Product Name" required></td>
						</tr>
						<tr>
							<td>Enter serial no:</td>
							<td><input type="text" name="serialno" class="form-control"
								placeholder="Enter Serial No" required></td>
						</tr>
						<tr>
							<td>Enter purchase date :</td>
							<td><input type="text" class="form-control"
								name="purchasedate" placeholder="YYYY-MM-DD" required></td>
						</tr>
						<tr>
							<td></td>
							<td><input type="submit" value="Submit" /></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>