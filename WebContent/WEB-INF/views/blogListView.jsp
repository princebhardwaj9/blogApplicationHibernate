<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Code Wall</title>
<link rel="stylesheet" href="./css/blog.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
</head>
<body>
<nav>
	<img src="./assets/blogger-logo.png" alt="logo" height="50" width="100" />
	<ul>
		<li><a href="${pageContext.request.contextPath}/myBlogs">My Blogs</a></li>
		<li><a href="${pageContext.request.contextPath}/allBlogs">All Blogs</a></li>
		<li><a href="${pageContext.request.contextPath}/login">Logout</a></li>
	</ul>
</nav>

<form action="#" method="post">
<input id="title" name="title" placeholder="Title" type="text"/>
<textarea id="description" name="description" placeholder="Description"></textarea>
<button id="post" type="submit">POST</button>
</form>

</body>
</html>