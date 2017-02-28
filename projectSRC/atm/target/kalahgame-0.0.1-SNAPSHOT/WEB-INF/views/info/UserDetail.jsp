<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body background="../../images/background.png">
<head>
    <sec:authentication var="user" property="principal" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Players Details</title>
</head>
<body style="background-color: gray">
<center>
   <%-- <c:url var="user"/>--%>
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
            </tr>
                    <tr style="background-color:white;color: black;text-align: center;" height="30px" >
                <td><c:out value="${user.id}"/></td>
                    <td><c:out value="${user.user_first_name}"/></td>

                    <td><c:out value="${user.user_login}"/>
                    </td><td><c:out value="${user.role}"/></td>

                    <td><c:out value="${user.email}"/></td>
                </tr>
        </table>
    </c:if>
    <br>
<%--    <a href="register.html" >Click Here to add new User</a>--%>
    <a href="/success-login.html" >Menu</a>

</center>
</body>
</body>
</html>