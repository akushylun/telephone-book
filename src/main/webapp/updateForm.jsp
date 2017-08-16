<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/css/style.css" />" rel="stylesheet">
</head>
<body>

	<c:import url="header.jsp" />

	<div class="container">
		<sf:form class="form-register" action="/updateForm" method="post"
			modelAttribute="record">

			<h2 class="form-signin-heading">Update form</h2>
 			
 			<input type="hidden" name="record" value="${record.id}" />
 			
			<sf:label path="surname">Surname</sf:label>
			<sf:input path="surname" class="form-control"
				value="${record.surname}" />
			<sf:errors path="surname" />

			<sf:label path="name">Name</sf:label>
			<sf:input path="name" class="form-control" value="${record.name}" />
			<sf:errors path="name" />

			<sf:label path="middleName">Middle name</sf:label>
			<sf:input path="middleName" class="form-control"
				value="${record.middleName}" />
			<sf:errors path="middleName" />

			<sf:label path="mobileTel">Mobile Tel</sf:label>
			<sf:input path="mobileTel" class="form-control"
				value="${record.mobileTel}" />
			<sf:errors path="mobileTel" />

			<sf:label path="homeTel">Home Tel</sf:label>
			<sf:input path="homeTel" class="form-control"
				value="${record.homeTel}" />
			<sf:errors path="homeTel" />

			<sf:label path="address">Address</sf:label>
			<sf:input path="address" class="form-control"
				value="${record.address}" />
			<sf:errors path="address" />

			<sf:label path="email">Email</sf:label>
			<sf:input path="email" class="form-control" value="${record.email}" />
			<sf:errors path="email" />

			<br />

			<button class="btn btn-success">Create</button>

		</sf:form>
	</div>

</body>
</html>