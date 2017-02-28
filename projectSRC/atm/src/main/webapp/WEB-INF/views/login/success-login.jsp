<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: a.lomako
  Date: 2/1/2017
  Time: 6:52 PM
  To change this template use File | Settings | File Templates.
--%>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<style>
    a{
        color: black;
        font-weight: bold;
    }
</style>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
    <title>Welcome page</title>
</head>
<body style="background-color: grey">
<center>
    <p><h1>You are logged in</h1></p><br/>
<h1>Welcome </h1>
<a href="/all" >Lookup for ATMs</a></br>
<%--
<a href="${pageContext.request.contextPath}/getPlayerInfo">See your statistics</a><br/>
--%>

    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <a href="${pageContext.request.contextPath}/admin/first"><%--See all players statistics--%>Visit admin page</a><br/>
    </sec:authorize>

    <c:url value="/logout" var="logoutUrl" />
    <a href="${logoutUrl}">Log Out</a>
<%--    <a href="<c:url value="/j_spring_security_logout" />" >Logout</a> <br/>--%>
<%--    <a href="${pageContext.request.contextPath}/index.html">Home page</a><br/></p>--%></center>
</body>
</html>