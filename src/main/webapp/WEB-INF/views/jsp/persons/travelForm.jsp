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
		<form:form action="/persons/saveTravel">
		
			<form:hidden path="passportId" />
	
			<spring:bind path="startDate">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label">purpose</label>
					<div class="col-sm-10">
						<form:input  path="startDate" class="form-control" id="startDate" placeholder="startDate" />
						<form:errors path="startDate" class="control-label" />
					</div>
			  	</div>		
			</spring:bind>
			
			<spring:bind path="endDate">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label">purpose</label>
					<div class="col-sm-10">
						<form:input  path="endDate" class="form-control" id="endDate" placeholder="endDate" />
						<form:errors path="endDate" class="control-label" />
					</div>
			  	</div>		
			</spring:bind>
			
			<spring:bind path="purpose">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label">purpose</label>
					<div class="col-sm-10">
						<form:input  path="purpose" class="form-control" id="purpose" placeholder="purpose" />
						<form:errors path="purpose" class="control-label" />
					</div>
			  	</div>		
			</spring:bind>
			
			<spring:bind path="country">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label">Country</label>
					<div class="col-sm-5">
						<form:select path="country" class="form-control">
							<form:option value="NONE" label="--- Select ---" />
							<form:options items="${countries}" />
						</form:select>
						<form:errors path="country" class="control-label" />
					</div>
					<div class="col-sm-5"></div>
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