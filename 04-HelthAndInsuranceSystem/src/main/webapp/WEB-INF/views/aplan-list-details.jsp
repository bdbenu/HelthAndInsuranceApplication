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
<h1>PLAN LIST</h1>
<table>
<tr>
<td>SL NO</td>
<td>PLAN NAME</td>
<td>Start Date</td>
<td>END DATE</td>
<td>EDIT</td>
<td>DELETE</td>
</tr>
<c:forEach items="${allPlan}" var="c" varStatus="index">
<tr>
<td>${index.count}</td>
<td>${c.planName} </td>
<td>${c.planStartDate}</td>
<td>${c.planEndtDate}</td>
<td>${c.planDescrption}</td>
<td><a href="deletePlan?pid=${c.planId}" onclick="return iconfirm()" type="submit">DELETE</a></td>
<td><a href="editPlan?pid=${c.planId}">Edit</a></td>
<td></td>
</tr>
</c:forEach>


</table>
</body>
</html>