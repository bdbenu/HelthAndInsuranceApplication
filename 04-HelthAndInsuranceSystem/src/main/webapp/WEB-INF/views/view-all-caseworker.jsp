<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">

function iconfirm() {
    var r = confirm("Do you really want to delete this user? Press ok to confirm.");
    if (r==true)
      {
    
  return true;
  }
     else
  {
  alert("You pressed Cancel!");
 
  // return false here
  return false;
  }
}
</script>
</head>
<body>
<table>
<tr>
<td>SL No</td>
<td>Name</td>
<td>Gender</td>
<td>Log</td>
<td>Account Status</td>
</tr>
<c:forEach items="${all}" var="c" varStatus="index">
<tr>
<td>${index.count}</td>
<td>${c.firstName}   &nbsp;&nbsp;&nbsp;${c.lastName}</td>
<td>${c.gender}</td>
<td>${c.accountStatus}</td>
<td>${c.role}</td>
<td><a href="deletew?id=${c.caseWorkerId}" onclick="return iconfirm()" type="submit">DELETE</a></td>
<td><a href="edit?id=${c.caseWorkerId}">Edit</a></td>
<td></td>
</tr>
</c:forEach>
</table>
</body>
</html>