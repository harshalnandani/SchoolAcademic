<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<meta name="google-site-verification" content="dNuQrvDQp_MhfS50xu05GMhMc7XOJrub2CXg408UuhM" />
<title>School Academic</title>

<!-- Bootstrap core CSS -->
<link href="frontresource/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom fonts for this template -->
<link href="frontresource/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">
<link href='https://fonts.googleapis.com/css?family=Kaushan+Script'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700'
	rel='stylesheet' type='text/css'>

<!-- Custom styles for this template -->
<link href="frontresource/css/agency.css" rel="stylesheet">

</head>

<body id="page-top">

	<nav class="navbar navbar-expand-lg navbar-dark" id="mainNav1">
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarTogglerDemo01"
			aria-controls="navbarTogglerDemo01" aria-expanded="false"
			aria-label="Toggle navigation">
			Contacts <i class="fas fa-bars"></i>
		</button>
		<div class="collapse navbar-collapse" id="navbarTogglerDemo01">
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item"><a class="nav-link px-2" href="#"><i
						class="fab fa-facebook-square"></i></a></li>
				<li class="nav-item"><a class="nav-link px-2" href="#"><i
						class="fab fa-instagram"></i></a></li>
				<li class="nav-item"><a class="nav-link px-2" href="#"><i
						class="fab fa-twitter-square"></i></a></li>
				<li class="nav-item"><a class="nav-link px-2" href="#"><i
						class="fab fa-linkedin"></i></a></li>
			</ul>
			<ul class="navbar-nav  ml-auto">
				<li class="nav-item"><a class="nav-link px-2" href="#"><i
						class="fas fa-envelope"></i> info@schoolacademic.com</a></li>
				<li class="nav-item"><a class="nav-link px-2" href="#"><i
						class="fas fa-phone-square"></i> +91-7387183063</a></li>
			</ul>
		</div>
	</nav>
	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark sticky-top"
		id="mainNav">
		<div class="container">
			<a class="navbar-brand js-scroll-trigger" href="#page-top">School Academic</a>
			<button class="navbar-toggler navbar-toggler-right" type="button"
				data-toggle="collapse" data-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				Menu <i class="fas fa-bars"></i>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav text-uppercase ml-auto">
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="/">Home</a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="">About Us</a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="login">Login</a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="requestademo">Request A demo</a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="contactus">Contact Us</a></li>
				</ul>
			</div>
		</div>
	</nav>


	<%
		// Set to expire far in the past.
		response.setHeader("Expires", "Sun, 7 May 1995 12:00:00 GMT");

		// Set standard HTTP/1.1 no-cache headers.
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");

		// Set IE extended HTTP/1.1 no-cache headers (use addHeader).
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");

		// Set standard HTTP/1.0 no-cache header.
		response.setHeader("Pragma", "no-cache");
	%>

	<c:if test="${success!=null}">
		<div class="alert alert-success alert-dismissible fade show "
			role="alert" id="snackbar">
			<i class="fa fa-check" aria-hidden="true"></i> ${success}
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
	</c:if>

	<%
		request.setAttribute("success", null);
	%>

	<c:if test="${failure!=null}">
		<div class="alert alert-danger alert-dismissible fade show "
			role="alert" id="snackbar">
			<i class="fa fa-exclamation-triangle" aria-hidden="true" class="mr-2"></i>
			${failure}
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
	</c:if>
	<%
		request.setAttribute("failure", null);
	%>