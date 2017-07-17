
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit page</title>
    </head>
    <body>
        <form action="<c:url value='/addCity'/>" method="get" >
            City name: <input type="text" name="cityName"/>
            City location: <input type="text" name="cityLocation"/>
            <input type="submit" value="Add new city"/>
            <span style="color:red;">${errMsgC}</span>

        </form>

        <form action="<c:url value='/addRoad'/>" method="get" >
            Road name: <input type="text" name="roadName"/>
            Road location 1: <input type="text" name="roadLocation1"/>
            Road location 2: <input type="text" name="roadLocation2"/>
            <input type="submit" value="Add new road"/>
            <span style="color:red;">${errMsgR}</span>
        </form>

        <span style="color:green;">${success}</span>

        <form action="<c:url value='/welcome'/>" method="get">
            <input type="submit" value="Back">
        </form>
    </body>
</html>
