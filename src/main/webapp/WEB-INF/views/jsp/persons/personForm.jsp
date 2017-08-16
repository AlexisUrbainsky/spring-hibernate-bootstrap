<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>

<jsp:include page="../fragments/header.jsp" />

<body>
	<div class="container">
	 
	<h1>Add Person</h1>
	
	<spring:url value="/persons" var="personActionUrl" />
	
	<form:form action="${personActionUrl}" method="post" modelAttribute="personForm"  class="form-horizontal" >
		
		<spring:bind path="name">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Name</label>
				<div class="col-sm-10">
					<form:input  path="name" class="form-control" id="name" placeholder="Name" />
					<form:errors path="name" class="control-label" />
				</div>
		  	</div>
		</spring:bind>
		
		<spring:bind path="lastName">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Last Name</label>
				<div class="col-sm-10">
					<form:input  path="lastName" class="form-control" id="lastName" placeholder="LastName" />
					<form:errors path="lastName" class="control-label" />
				</div>
		  	</div>
		</spring:bind>
		
		<spring:bind path="sex">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Sex</label>
				<div class="col-sm-10">
					<form:input  path="sex" class="form-control" id="sex" placeholder="Sex" />
					<form:errors path="sex" class="control-label" />
				</div>
		  	</div>		
		</spring:bind>

		<spring:bind path="email">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Email</label>
				<div class="col-sm-10">
					<form:input  path="email" class="form-control" id="email" placeholder="Email" />
					<form:errors path="email" class="control-label" />
				</div>
		  	</div>		
		</spring:bind>
		
		<spring:bind path="passport.nationality" >
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Nationality</label>
				<div class="col-sm-10">
					<form:input path="passport.nationality" class="form-control" id="nationality" placeholder="Nationality" />
					<form:errors path="passport.nationality" class="control-label" />
				</div>
		  	</div>
		</spring:bind>
		
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
		   		<button type="submit" class="btn-lg btn-primary pull-right">Add</button>
		    </div>
		</div>
		
	</form:form>
	
	</div>
	
	<jsp:include page="../fragments/footer.jsp" />
	
</body>

</html>