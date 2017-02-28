<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<style>
    a{color: black}
</style>
<body style="background-color: gray">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
    <title>Login page</title>
    <style>
        .error {
            color: red;
        }
    </style>
    <sec:authorize access="isAuthenticated()">
        <% response.sendRedirect("/success-login"); %>
    </sec:authorize>
</head>
<body>

<center><h1>Login page</h1>
<p>
    <c:if test="${error == true}">
        <b class="error">Invalid login or password.</b>
    </c:if>
</p>
<form method="post" action="<c:url value='/j_spring_security_check'/>" >
    <table>
        <tbody>
        <tr>
            <td>Login:</td>
            <td><input type="text" name="j_username" id="j_username"size="30" maxlength="40"  /></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="j_password" id="j_password" size="30" maxlength="32" /></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Login" /></td>
        </tr>
        </tbody>
    </table>
</form>
    <a href="/password-recovery.html"><b>Forgot Your Password?</b></a>
<p>
<a href="index.jsp" ><b>Go to Welcome Page<b></a>
    <%--<a href="${pageContext.request.contextPath}/index.html">Home page</a><br/>--%>
</p>
</center>
</body>
</body>
</html>