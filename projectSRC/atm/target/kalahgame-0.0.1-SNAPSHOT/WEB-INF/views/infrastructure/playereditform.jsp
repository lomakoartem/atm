<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<style>
    a{
        color: black;
        font-weight: bold;
    }
</style>
<body style="background-color: gray">
<c:url var="editsave" value="/admin/editsave" ></c:url>
<form:form method="post" action="${editsave}" >
    <table >
        <tr>
            <td></td>
            <td><form:hidden  path="id" /></td>
        </tr>
        <td><b> ENTER 1 for "ADMIN_ROLE", 2 for "USER_ROLE"</b></td>
        <tr>
            <td><b>Name :</b> </td>
            <td><form:input path="user_first_name"  /></td>
        </tr>
        <tr>
            <td><b>Login :</b></td>
            <td><form:input path="user_login" /></td>
        </tr>
        <tr>
            <td><form:hidden path="user_password" /></td>
        </tr>

        <tr>
            <td><b>Role:</b></td>
            <td><form:input path="role.id" /></td>
        </tr>
        <tr>
            <td><b>Email :</b></td>
            <td><form:input path="email" /></td>
        </tr>
        <tr>
            <td> </td>
            <td><input type="submit" value="Edit Save" /></td>
        </tr>
    </table>
</form:form>