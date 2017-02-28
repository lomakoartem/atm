<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<style>
    a{
        color: black;
        font-weight: bold;
    }
</style>
<body background="../../images/background.png">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Players Details</title>
</head>
<body style="background-color: gray">
<center>
<br><br><br><br><br><br>
<div style="color: teal;font-size: 30px">User Details</div>
<br><br>
<c:if test="${!empty user}">
<table border="1" bgcolor="black" width="600px">
<tr style="background-color: black;color: white;text-align: center;" height="40px">
<td>User Id</td>
<td>First Name</td>
<td>Last Name</td>
<td>Status</td>
<td>Email</td>
<td>Edit</td>
    <td>Delete</td>
</tr>
<c:forEach items="${user}" var="user">
<tr style="background-color:white;color: black;text-align: center;" height="30px" >
<td><c:out value="${user.id}"/></td>
<td><c:out value="${user.user_first_name}"/></td>
    <td><c:out value="${user.user_login}"/></td>
    <td><c:out value="${user.role}"/></td>
    <td><c:out value="${user.email}"/></td>
    <td><a href="editplayer/${user.id}">Edit</a></td>
    <td><a href="deleteplayer/${user.id}">Delete</a></td>
</tr>
</c:forEach>
</table>
</c:if>
<br>
<%--<a href="register.html" >Click Here to add new User</a>--%>
</center>
</body>
</body>
</html>