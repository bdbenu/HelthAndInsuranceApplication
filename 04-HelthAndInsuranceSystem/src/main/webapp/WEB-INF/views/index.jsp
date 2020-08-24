<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>CASEWORKER REGISTER</h1>
		<form:form action="registerWorker" method="POST"
			modelAttribute="caseworker">
			<table>
				<tr>
					<td>FIRST NAME</td>
					<td><form:input path="firstName" /></td>
				</tr>
				<tr>
					<td>LAST NAME</td>
					<td><form:input path="lastName" /></td>
				</tr>
				<%-- <tr><td>GENDER</td><td><form:input path="gender"/></td></tr> --%>
				<tr>
					<td>GENDER</td>
					<td><form:radiobutton path="gender" value="MALE" />Male<form:radiobutton
							path="gender" value="FEMALE" />FEMALE</td>
				</tr>
				<tr>
					<td>EMAIL</td>
					<td><form:input path="caseWorkerEmail" /></td>
				</tr>
				
				<tr>
					<td></td>
					<td><form:select path="role">
							<form:option value="NONE" label="--- Select ---" />
							<form:option value="admin" label="admin" />
							<form:option value="caseworker" label="caseworker" />
						</form:select></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="REGISTER"></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>