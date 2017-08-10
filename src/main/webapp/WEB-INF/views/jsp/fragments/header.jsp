<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
	<title>Spring MVC - Hibernate - Bootstrap</title>
	<spring:url value="/resources/core/css/bootstrap.min.css" 	var="bootstrapCss" />
	<link href="${bootstrapCss}" rel="stylesheet" />
	<link href="${coreCss}" rel="stylesheet" />
</head>

<script type="text/javascript">

	function post(path, params, method) {
		method = method || "post"; 
	
		var form = document.createElement("form");
		form.setAttribute("method", method);
		form.setAttribute("action", path);
	
		for ( var key in params) {
			if (params.hasOwnProperty(key)) {
				var hiddenField = document.createElement("input");
				hiddenField.setAttribute("type", "hidden");
				hiddenField.setAttribute("name", key);
				hiddenField.setAttribute("value", params[key]);
	
				form.appendChild(hiddenField);
			}
		}
	
		document.body.appendChild(form);
		form.submit();
	}
</script>

<spring:url value="/persons" var="urlHome" />
<spring:url value="/persons/add" var="urlAddPerson" />

<nav class="navbar navbar-inverse ">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="${urlHome}">Spring MVC Form</a>
		</div>
		<div id="navbar">
			<ul class="nav navbar-nav navbar-right">
				<li class="active"><a href="${urlAddPerson}">Add Person</a></li>
			</ul>
		</div>
	</div>
</nav>
