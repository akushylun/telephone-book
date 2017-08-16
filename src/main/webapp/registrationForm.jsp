<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="<c:url value="/css/style.css" />" rel="stylesheet">

</head>
<body>

	<c:import url="header.jsp" />

	<div class="container">
		<sf:form class="form-register" action="/registration" method="POST"
			commandName="person">

			<h2 class="form-signin-heading">Please register</h2>

			<sf:label path="fullName">FullName</sf:label>
			<sf:input path="fullName" class="form-control" placeholder="fullName" />
			<sf:errors path="fullName" />

			<sf:label path="username">UserName</sf:label>
			<sf:input path="username" class="form-control" placeholder="username" />
			<sf:errors path="username" />
			<br />

			<sf:label path="password">Password</sf:label>
			<sf:input path="password" class="form-control" placeholder="Password" />
			<sf:errors path="password" />
			<br />

			<button class="btn btn-success">Register</button>

		</sf:form>
	</div>
</body>
</html>