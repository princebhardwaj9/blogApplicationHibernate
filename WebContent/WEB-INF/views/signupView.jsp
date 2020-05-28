<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Code Wall</title>
<link type="text/css" rel="stylesheet" href="./css/signup.css">
</head>
<body>
	<nav>
		<img src="./assets/blogger-logo.png" alt="logo" height="50" width="100" />
		<ul>
			<li><a href = "${pageContext.request.contextPath}/login">Login</a></li>
			<li><a href = "${pageContext.request.contextPath}/signup">SignUp</a></li>
		</ul>
	</nav>
	<div class = "welcome">WELCOME BACK</div>
	<div class="text">
		Share your knowledge, what you have learn with our community.
	</div>
	<div class = "signup">
		<div class = "title">SignUp</div>
		<form action="${pageContext.request.contextPath}/signup" method="post">
			<label for="name">Name</label>
			<input class="name" id="name" name="name" type="text">
			
			<label for="email">Email</label>
			<input class="email" id="email" name="email" type="email">
			
			<label for="mobile">Mobile</label>
			<input class="mobile" id="mobile" name="mobile" type="text">
			
			<label for ="password">Password</label>
			<input class="password" id="password" name="password" type="password">
			
			<label for ="confirm-password">Confirm Password</label>
			<input class="password" id="confirm-password" name="confirm-password" type="password">
			<button type="submit">Sign Up</button>
			<div>${message}</div>
		</form>
	</div>
</body>
</html>

<!-- hint="Must consist atleast 8 char, a symbol, a lower-case, a upper-case letter & a digit" -->