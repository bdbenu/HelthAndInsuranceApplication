<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://jqueryvalidation.org/files/demo/site-demos.css">
<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>
<script>
// just for the demos, avoids form submit
jQuery.validator.setDefaults({
  debug: true,
  success: "valid"
});
$( "#myform" ).validate({
  rules: {
    password: "required",
    confirmpassword: {
      equalTo: "#password"
    }
  }
});
</script>
</head>
<body>
<!--  unlockaccount-->
<form:form action="unlocacc" method="POST" modelAttribute="unlockacc" id="myform">
<table>

<tr><td> Email</td><td>${email}</td></tr>
<tr><td>Temporary password</td><td><form:input path="tempPazzword"/></td></tr>
<tr><td>New Password</td><td><form:input path="newPazzword" id="password"/></td></tr>
<tr><td>Confirm-Password</td><td><form:input path="confirmPazzword" id="confirmpassword"/></td></tr>
<tr><td></td><td><span id="errorId" style="color:red;"></span></td></tr>
<tr><td></td><td><input type="submit" value="UNLOCK" onclick="return validatePwd();"></td></tr>

</table>
</form:form>

</body>
</html>