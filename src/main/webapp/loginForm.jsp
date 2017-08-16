<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="<c:url value="/css/style.css" />" rel="stylesheet">

</head>

<body>
	<c:import url="header.jsp" />

	<div class="container">
		<c:url value="/login" var="loginProcessingUrl" />
		<sf:form class="form-signin" action="${loginProcessingUrl}"
			method="POST">

			<h2 class="form-signin-heading">Please sign in</h2>

			<label for="username" class="sr-only">userName</label>
			<input type="text" id="username" name="username" class="form-control"
				placeholder="Username" required autofocus>

			<c:if test="${not empty loginError}">
				<c:out value="${loginError}" />
			</c:if>

			<label for="inputPassword" class="sr-only">Password</label>
			<input type="password" id="inputPassword" name="password"
				class="form-control" placeholder="Password" required>

			<c:if test="${not empty passwordError}">
				<c:out value="${passwordError}" />
			</c:if>

			<div class="checkbox">
				<a href="/registration">Register</a>
			</div>

			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />

			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
				in</button>
		</sf:form>

	</div>

</body>
</html>
