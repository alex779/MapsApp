
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cities</title>
        <style type="text/css">
            table, td{
                border: 1px solid black;
            }
        </style>
    </head>
    <body>
        <table style="">
            <tr>
                <td>id</td>
                <td>name</td>
                <td>location</td>
                <td>edit</td>
                <td>remove</td>
            </tr>

            <c:forEach var="city" items="${cities}">
                <tr>
                    <td>${city.id}</td>
                    <td>${city.name}</td>
                    <td>${city.location}</td>
                    <td><a href="edit?id=${city.id}">edit</a></td>
                    <td><a href="delete?id=${city.id}">remove</a></td>
                </tr>
            </c:forEach>
        </table>

        <form action="<c:url value='/welcome'/>" method="get">
            <input type="submit" value="Back">
        </form>

    </body>
</html>

