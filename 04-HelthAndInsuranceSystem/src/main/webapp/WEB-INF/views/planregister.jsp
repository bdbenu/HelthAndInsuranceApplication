<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#startdate" ).datepicker();
  } );
  $( function() {
	    $( "#enddate" ).datepicker();
	  } );
  </script>
</head>
<body>
<h1 align="center">WELCOME TO PLAN</h1>
<div align="center">
<h1 align="left"><a href="getAllPlan">View All Plan</a></h1>
<h3 style="color: green">${sucMsg}${failMsg}</h3>
<form:form action="planregister" method="POST" modelAttribute="planmaster" >
<table>
<tr><td>Plan Name</td><td><form:input path="planName"/></td></tr>
<tr><td>Plan Description</td><td><form:input path="planDescrption"/></td></tr>
<tr><td>Plan start Date</td><td><form:input path="planStartDate" id="startdate"/></td></tr>
<tr><td>Plan END DATE</td><td><form:input path="planEndtDate" id="enddate"/></td></tr>
<tr><td></td><td><input type="submit" value="register"></td></tr>

</table>


</form:form>

</div>
</body>
</html>