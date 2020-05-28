<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<div class="body-div1">
	<div>Your Blog Posts</div>
	<a href="${pageContext.request.contextPath}/BlogController"><button class="button" id="addBlog"><i class="fas fa-plus-circle"></i>Add New Post</button> </a>
</div>

<div class="body-div2">
	<c:forEach var="blog" items="${allBlogList}">
		<div class="article-card">
			<img src="./assets/java card image.svg" alt="">
			<div class="card-text">
				<h1 id="blog-title"><c:out value="${blog.getBlogtitle()}" /></h1>
				<p id="blog-description"><c:out value="${blog.getBlogDesc()}" /></p>
				<p>Posted on:<b><c:out value="${blog.getPostedOn()}" /></b></p>
			</div>
			<div class="card-buttons">
				<a href="edit?id=<c:out value='${blog.getBlogid()}' />"><button type="button" id="edit">EDIT</button></a><span>|</span><a href="delete?id=<c:out value='${blog.getBlogid()}' />"><button type="button" id="delete">DELETE</button></a>
			</div>
		</div>
	</c:forEach>
</div>

<div class="body-div3">
	<h1>${message}</h1>
</div>

</body>
</html>