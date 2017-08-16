<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>

<jsp:include page="fragments/header.jsp" />

<body>

	<div class="container">

		<h1>Error Page</h1>

		<p>${exception.message}</p>

	</div>

	<jsp:include page="fragments/footer.jsp" />

</body>
</html>,