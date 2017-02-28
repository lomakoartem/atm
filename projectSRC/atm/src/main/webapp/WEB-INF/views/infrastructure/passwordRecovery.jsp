<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <style>
        a{
            color: black;
            font-weight: bold;
        }
    </style>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Recover Password Page</title>
</head>
<body style="background-color: gray">
<center>
    <br><br><br><br><br><br>
    <div style="color: black;font-size: 30px"><b>Recover your password</b></div>
    <br><br>
    <c:url var="userPasswordRecovery" value="/generatePassword.html"/>
    <form:form id="registerForm"  action="${userPasswordRecovery}">
        <tr>
            <td><b>Enter your email:</b></td>
            <td><input name ="email" /></td>

        </tr>
            </tr>
                <tr><td></td><td>
                <input type="submit" value="Get New Password" />
            </td></tr>

    </form:form>
    <br>
    <%--<a href="/index.html" >Click Here to see User List</a>--%>
</center>
</body>
</html>

<html>
