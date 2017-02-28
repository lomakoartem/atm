<%--
  Created by IntelliJ IDEA.
  User: a.lomako
  Date: 2/23/2017
  Time: 1:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <center>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
    <title>Reverse Geocoding</title>
    <style>
        #map-canvas {
            height: 500px;
            width: 500px;
            margin: 0px;
            padding: 0px
        }
    </style>
    <script src="https://maps.googleapis.com/maps/api/js?libraries=places&key=AIzaSyA1anp3AH4guxGZbpoG1BTg0XCPZi7d5k4"></script>
    <script>
        var geocoder;
        var map;
        var infowindow = new google.maps.InfoWindow();
        var marker;
        function initialize() {
            geocoder = new google.maps.Geocoder();
            var latlng = new google.maps.LatLng(52.2129919, 5.2793703); //center in Netherlands
            var mapOptions = {
                zoom : 8,
                center : latlng,
                mapTypeId : 'roadmap'
            }
            map = new google.maps.Map(document.getElementById('map-canvas'),
                mapOptions);
        }
        function codeLatLng(input) {
            var latlngStr = input.split(',', 2);
            var lat = parseFloat(latlngStr[0]);
            var lng = parseFloat(latlngStr[1]);
            var latlng = new google.maps.LatLng(lat, lng);
            geocoder.geocode({
                'latLng' : latlng
            }, function(results, status) {
                if (status == google.maps.GeocoderStatus.OK) {
                    if (results[1]) {
                        map.setZoom(11);
                        marker = new google.maps.Marker({
                            position : latlng,
                            map : map
                        });
                        infowindow.setContent(results[1].formatted_address);
                        infowindow.open(map, marker);
                    } else {
                        alert('No results found');
                    }
                } else {
                    alert('Geocoder failed due to: ' + status);
                }
            });
        }
        google.maps.event.addDomListener(window, 'load', initialize);
    </script>
    <a href="<c:url value="/success-login.html" />" > Home</a>
    </center>
</head>

<body>
<center><div id="map-canvas"></div></center>
<%--
<h1><c:out value="${fn:length(addresses)}"/> ING ATMs in : ${city}</h1>
--%>
<center>
<ul>
    <c:forEach items="${addresses}" var="address">
        <li>
            ${address.address.street}
         ${address.address.housenumber}
         ${address.address.postalcode}

            <a href="#"
               onclick="codeLatLng('${address.address.geoLocation.lat}, ${address.address.geoLocation.lng}')"> Show in Map </a>
        </li>
    </c:forEach>
</ul></center>

</body>
</html>