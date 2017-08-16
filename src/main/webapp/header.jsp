<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet"
	type="text/css">

<header>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.jsp">TelephoneBook</a>
			</div>

			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">

					<li class="active"><a href="/telephoneBook">Telephone Book</a></li>

				</ul>

				<ul class="nav navbar-nav navbar-right">
					<li><a href="/login">Login</a></li>
					<li><a href="/logout">Logout</a></li>
				</ul>

			</div>
		</div>
	</nav>
</header>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>