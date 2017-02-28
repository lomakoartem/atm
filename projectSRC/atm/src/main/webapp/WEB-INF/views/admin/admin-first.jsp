<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
    <title>First Admin page</title>
</head>
<body style="background-color: gray">
<center>
<h1>Admin page</h1>

<p>
   <%-- <a href="&lt;%&ndash;${pageContext.request.contextPath}&ndash;%&gt;/admin/userList.html">Get ATMs on maps</a><br/>--%>
    <a href="<%--${pageContext.request.contextPath}--%>/admin/userList.html">See users info</a><br/>
    <a href="${pageContext.request.contextPath}/success-login">Home page</a><br/>

    <c:url value="/logout" var="logoutUrl" />
</p>
</center>
</body>
</html>
