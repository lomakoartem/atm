<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<head>
    <style>
        a{color: black}
    </style>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Being Java Guys | Registration Form</title>
</head>
<body style="background-color: gray">
<center>
    <br><br><br><br><br><br>
    <div style="color: black;font-size: 30px">Welcome TO  User Registration Page</div>
    <br><br>
    <script type="text/javascript">
        function ValidateEmail(mail) {
            if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(registerForm.email.value)) {
                return (true)
            }
            alert("You have entered an invalid email address!")
            return (false)
        }
        function validate() {
            var user_first_name = document.getElementById("user_first_name");
            var user_login = document.getElementById("user_login");
            var email = document.getElementById("email");

            var valid = true;
            if (user_first_name.value.length <= 0 || user_login.value.length <= 0 || email.value.length <= 0) {
                alert("Don't leave the field empty!");
                valid = false;
            }
            else {
                if (!ValidateEmail(email))
                    valid = false;
            }
            return valid;
        }
        ;
    </script>
    <c:url var="userRegistration" value="saveUser.html"/>
    <form:form id="registerForm" modelAttribute="user" method="post" action="${userRegistration}"
               onsubmit="return validate();">
        <table width="400px" height="150px">
            <tr>
                <td><form:label path="user_first_name">User Name</form:label></td>
                <td><form:input path="user_first_name"/></td>
            </tr>

            <tr>
                <td><form:label path="user_login">User Login</form:label></td>
                <td><form:input path="user_login"/></td>
            </tr>
            <tr>
                <td><form:label path="email">User Email</form:label></td>
                <td><form:input path="email"/></td>
            </tr>
            <tr>
                <td><form:label path="user_password">Create Password</form:label></td>
                <td><form:input path="user_password" type="password"/></td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input type="submit" value="Register"/>
                </td>
            </tr>
        </table>

    </form:form>
    <br>
    <a href="/index.jsp"><b>Go to Welcome Page</b></a>
</center>
</body>
</html>
