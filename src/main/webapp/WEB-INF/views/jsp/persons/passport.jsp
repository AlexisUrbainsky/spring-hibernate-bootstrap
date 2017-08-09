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

		<h1>Passport</h1>

		<table class="table table-sm">

			<tr>
				<th>Name:</th>
				<th>Last Name:</th>
				<th>Sex:</th>
			</tr>

			<tr class="bg-info">
				<td>${person.name}</td>
				<td>${person.lastName}</td>
				<td>${person.sex}</td>
			</tr>

			<tr>
				<th>Nationality:</th>
				<th>Expedition Date:</th>
				<th>Expiration Date:</th>
			</tr>

			<tr class="bg-info">
				<td>${person.passport.nationality}</td>
				<td>${person.passport.expeditionDate}</td>
				<td>${person.passport.expirationDate}</td>
			</tr>

		</table>

		<br></br>
		
		<h1>Travels</h1>
		
		<br></br>
		
		<table class="table">

			<thead class="thead-inverse">
				<tr>
					<th>Country</th>
					<th>Start Date</th>
					<th>End Date</th>
					<th>Purpose</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="travel" items="${person.passport.travels}">
					<tr>
						<td>${travel.country.countryName}</td>
						<td>${travel.startDate}</td>
						<td>${travel.endDate}</td>
						<td>${travel.purpose}</td>
					</tr>
				</c:forEach>
			</tbody>

		</table>

	</div>
	
	
	
	<!-- Add Button to Add Travels -->
	
	<spring:url value="/persons/${person.id}/addTravel" 			var="addTravelUrl" />
	
	<button class="btn btn-info" onclick="location.href='${addTravelUrl}'">Add Travel</button>
	
	<jsp:include page="../fragments/footer.jsp" />

</body>

</html>