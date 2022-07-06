<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>Home</title>
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
		<h3>Welcome.!</h3>
	</div>
	<div class="container p-2">
		<div class="row">
			<div class="col">
				<h3>Login page</h3>
			</div>	
		</div>
		<br>
		<div class="row">
			<div class="col">
			<form action="UserLogin" method="post">
				Username : <input type="text" name="username" placeholder="Enter Username"> <br><br>
				Password : <input type="password" name="password" placeholder="Enter Password"> <br><br>
				<input type="submit" value="Log In"/>
			</form><br>
			<a href="user-products-display.jsp"></a>
		</div>
		</div>
	</div>	
</body>
</html>