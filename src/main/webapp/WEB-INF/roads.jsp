
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Roads</title>
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
                <td>location 1</td>    
                <td>location 2</td>   
                <td>city id 1</td>   
                <td>city id 2</td>   
                <td>edit</td>
                <td>remove</td>
            </tr>

            <c:forEach var="road" items="${roads}">
                <tr>
                    <td>${road.id}</td>
                    <td>${road.name}</td>
                    <td>${road.location1}</td>
                    <td>${road.location2}</td>
                    <td>${road.cityid}</td>
                    <td>${road.cityid1}</td>
                    <td><a href="roadEdit?id=${road.id}">edit</a></td>
                    <td><a href="roadDelete?id=${road.id}">remove</a></td>

                </tr>
            </c:forEach>
        </table>

        <form action="<c:url value='/welcome'/>" method="get">
            <input type="submit" value="Back">
        </form>

    </body>
</html>



