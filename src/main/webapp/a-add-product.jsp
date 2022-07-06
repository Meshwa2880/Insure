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

<title>Add New Product</title>
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

		<div class="row">
			<div class="col">
				<h3>Add Product</h3>
			</div>

		</div>
		<div class="row">
			<div class="col">
				<form method="post" action="AdminAddProductController">
					<table>
						<tr>
							<td>Serial Number:</td>
							<td><input type="text" class="form-control" name="serialno"
								placeholder="Enter Serial Number"></td>
						</tr>
						<tr>
							<td>Product Name:</td>
							<td><input type="text" class="form-control"
								name="productname" placeholder="Enter Product Name"></td>
						</tr>
						<tr>
							<td>Model:</td>
							<td><input type="text" class="form-control" name="model"
								placeholder="Enter Model"></td>
						</tr>
						<tr>
							<td></td>
							<td><button type="submit">Submit</button></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>

</body>
</html>