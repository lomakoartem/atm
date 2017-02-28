<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: a.lomako
  Date: 2/22/2017
  Time: 4:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Bootstrap 101 Template</title>

<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->
<style>
    a{
        color: black;
        font-weight: bold;
        background-color: #7f7f7f;
    }

</style>
<head>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even){background-color: #f2f2f2}
    </style>
    <title>Title</title>
</head>
<body>
<div id="map-canvas"></div>
<%--<h1><c:out value="${fn:length(addresses)}"/> ING ATMs in : ${city}</h1>--%>
<%--<select name="city">
    <c:forEach var="atmLocations" items="${atmLocations}">
        <option value="${atmLocations.address.city} ${atmLocations.address.city == selectedCity ? 'selected="selected"' : ''}">"${atmLocations.address.city}"</option>
    &lt;%&ndash;    <td><a href="getatmsonmap/${atmLocations.address.city}">See location on map</a></td>&ndash;%&gt;
&lt;%&ndash;        <a href="getatmsonmap/?${atmLocations.address.city}">Continue</a>&ndash;%&gt;
    </c:forEach>
</select>--%>

<%--<button type="submit" value="submit" name="Submit">SUBMIT</button>--%>
<%--<select name="department">
    <c:forEach var="item" items="${dept}">
        <option value="${item.key}" ${item.key == selectedDept ? 'selected="selected"' : ''}>${item.value}</option>
    </c:forEach>
</select>--%>
<table>

<center>
  <%--  <table border="1" bgcolor="black" width="600px">--%>
        <tr style="background-color: black;color: white;text-align: center;" height="40px">
            <td> city </td>
            <td> street </td>
            <td> housenumber </td>
            <td> postalcode </td>
            <td> distance </td>
            <td> type </td>
            <td> GeoLocationLat </td>
            <td> GeoLocationLng </td>
            <td> SeeInMap </td>
        </tr>
        <c:forEach items="${atmLocations}" var="atmLocations">
            <tr style="background-color:white;color: black;text-align: center;" height="30px" >
                <td><c:out value="${atmLocations.address.city}"/></td>
                <td><c:out value="${atmLocations.address.street}"/></td>
                <td><c:out value="${atmLocations.address.housenumber}"/></td>
                <td><c:out value="${atmLocations.address.postalcode}"/></td>
                <td><c:out value="${atmLocations.distance}"/></td>
                <td><c:out value="${atmLocations.type}"/></td>
                <td><c:out value="${atmLocations.address.geoLocation.lat}"/></td>
                <td><c:out value="${atmLocations.address.geoLocation.lng}"/></td>
                <td> <a href="getatmsonmap/${atmLocations.address.city}">See on map</a></td>
            </tr>
        </c:forEach>
    </table>
</center>
</ul>
</body>
</html>
