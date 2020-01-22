<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${employeelist}" var="employee" >
   <tr>
    <td>${user.id }</td>
    <td>${user.firstname }</td>
    <td>${user.lastname }</td>
    <td>${user.address }</td>
    <td>
     <spring:url value="/employeedetails/updateemployee/${employee.eid }" var="updateurl" />
     <a href="${updateurl}">Update</a>
    </td>
    <td>
     <spring:url value="/employeedetails/deleteemployee/${employee.eid }" var="deleteurl" />
     <a href="${deleteurl}">Delete</a>
    </td>
   </tr>    
  </c:forEach>
</body>
</html>