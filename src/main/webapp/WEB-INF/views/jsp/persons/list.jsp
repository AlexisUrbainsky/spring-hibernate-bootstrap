<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>

<jsp:include page="../fragments/header.jsp" />

<body>

	<div class="container">

		<h1>All Persons</h1>

		<table class="table table-striped">

			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Last Name</th>
					<th>Sex</th>
					<th>Action</th>
				</tr>
			</thead>

			<c:forEach var="person" items="${persons}">
				<tr>
					<td>${person.id}</td>
					<td>${person.name}</td>
					<td>${person.lastname}</td>
					<td>${person.sex}</td>
					<td>
						<spring:url value="/persons/${person.id}" 			var="personUrl" />
						<spring:url value="/persons/${persons.id}/delete" 	var="deleteUrl" />
						<spring:url value="/persons/${persons.id}/update" 	var="updateUrl" />
						<spring:url value="/persons/${persons.id}/passport"	var="updateUrl" />

						<button class="btn btn-info"
							onclick="location.href='${personUrl}'">View Person</button>
						<button class="btn btn-info"
							onclick="location.href='${passportUrl}'">View Passport</button>
						<button class="btn btn-primary"
							onclick="location.href='${updateUrl}'">Update</button>
						<button class="btn btn-danger"
							onclick="this.disabled=true;post('${deleteUrl}')">Delete</button>
					</td>
				</tr>
			</c:forEach>

		</table>

	</div>

	<jsp:include page="../fragments/footer.jsp" />

</body>

</html>