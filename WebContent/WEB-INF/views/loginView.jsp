<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Code Wall</title>
<link type="text/css" rel="stylesheet" href="./css/login.css">
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
	<div class = "login">
		<div class = "title">LOGiN</div>
		<form action="${pageContext.request.contextPath}/login" method="post">
			<label for="email">EMAiL</label>
			<input class="email" name="email" id="email" type="email">
			<label for ="password">Password</label>
			<input class="password" name="password" id="password" type="password">
			<button type="submit">LOGiN</button>
			<div class="message">${message}</div>
			<span>forgot <a href="#">password</a>?</span>
		</form>
	</div>
</body>
</html>