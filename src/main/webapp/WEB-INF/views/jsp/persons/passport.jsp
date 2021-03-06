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

		<table class="table table-sm table-bordered">

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
				<td><fmt:formatDate type = "date" value = "${person.passport.expeditionDate}" /></td>
				<td><fmt:formatDate type = "date" value = "${person.passport.expirationDate}" /></td>
			</tr>

		</table>

		<br></br>
		
		<h1>Travels</h1>
		
		<br></br>
		
		<table class="table table-bordered">

			<thead >
				<tr>
					<th>Country</th>
					<th>Start Date</th>
					<th>End Date</th>
					<th>Purpose</th>
				</tr>
			</thead>
			
			<c:choose>
			    <c:when test="${not empty travels}">
			    	<tbody>
				    	<c:forEach var="travel" items="${travels}">
							<tr>
								<td>${travel.country.countryName}</td>
								<td><fmt:formatDate type = "date" value = "${travel.startDate}" /></td>
								<td><fmt:formatDate type = "date" value = "${travel.endDate}" /></td>
								<td>${travel.purpose}</td>
							</tr>
						</c:forEach>
					</tbody>
			    </c:when>
			    
			    <c:otherwise>
			    <tbody>
			   		 <tr>
						<td colspan="4" >
							<center><p>There is no travels made</p></center>
						</td>
					</tr>
				</tbody>
			    </c:otherwise>
			</c:choose>

		</table>

		<br></br>
		<spring:url value="/travels/${person.id}/addTravel" var="addTravelUrl" />
		
		<div>
			<div class="text-right">
		   		<button class="btn btn-info" onclick="location.href='${addTravelUrl}'">Add Travel</button>
		    </div>
		</div>
		
		
	</div>
	
	<jsp:include page="../fragments/footer.jsp" />

</body>

</html>