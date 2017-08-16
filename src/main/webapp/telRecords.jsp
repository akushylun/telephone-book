<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/css/style.css" />" rel="stylesheet">
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet" />
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.12/css/dataTables.bootstrap.min.css"
	rel="stylesheet" />
</head>
<body>

	<c:import url="header.jsp" />

	<table id="example" class="table table-striped table-bordered">
		<thead>
			<tr>
				<th>#</th>
				<th>Surname</th>
				<th>Name</th>
				<th>Middle Name</th>
				<th>Mobile Telephone</th>
				<th>Home Telephone</th>
				<th>Address</th>
				<th>Email</th>
				<th>Update</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>

			<c:set var="count" value="0" scope="page" />
			<c:forEach var="record" items="${records}">
				<c:set var="count" value="${count + 1}" scope="page" />

				<tr>

					<td><c:out value="${count}" /></td>
					<td><c:out value="${record.surname}" /></td>
					<td><c:out value="${record.name}" /></td>
					<td><c:out value="${record.middleName}" /></td>
					<td><c:out value="${record.mobileTel}" /></td>
					<td><c:out value="${record.homeTel}" /></td>
					<td><c:out value="${record.address}" /></td>
					<td><c:out value="${record.email}" /></td>
					<td>
						<form action="/updateForm" method="get">
							<input type="hidden" name="record" value="${record.id}" /> <input
								type="hidden" name="record" value="${record.surname}" /> <input
								type="hidden" name="record" value="${record.name}" /> <input
								type="hidden" name="record" value="${record.middleName}" /> <input
								type="hidden" name="record" value="${record.mobileTel}" /> <input
								type="hidden" name="record" value="${record.homeTel}" /> <input
								type="hidden" name="record" value="${record.address}" /> <input
								type="hidden" name="record" value="${record.email}" />
							<button class="btn btn-warning">Update</button>
						</form>
					</td>
					<td>
						<form action="/deleteForm" method="post">
							<input type="hidden" name="record" value="${record.id}" />
							<button class="btn btn-danger">Delete</button>
						</form>
					</td>

				</tr>

			</c:forEach>
		</tbody>
	</table>
	<center>
		<a class="btn btn-primary" href="getRecordForm" role="button">New
			Record</a>
	</center>
	

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.12/js/jquery.dataTables.min.js"></script>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.12/js/dataTables.bootstrap.min.js"></script>
	<script src="/js/example.js"></script>
</body>
</html>