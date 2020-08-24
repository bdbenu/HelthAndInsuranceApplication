<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <script type="text/javascript">
function validatePwd(){
	var newPassword = $(#newPassword).val();
	var confiPassword = $(#confiPassword).val();
	if(newPassword!=confiPassword){
		return true;
		}
	$('#errorId').innerHTML = "New Password and confirm-password must be same";
	return false;
	
}
 </script>
</head>
<body>
<!--  unlockaccount-->
<form:form action="unlockaccount" method="POST" modelAttribute="unlockacc" id="loginForm" >
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