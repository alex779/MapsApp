

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit road</title>
    </head>
    <body>

        <form method="POST">
            <input type="hidden" name="id" value="${road.name}"/>
            <table>
                <tr>
                    <td>id</td>
                    <td>${road.id}</td>
                </tr>
                <tr>
                    <td>name</td>
                    <td><input type="text" value="${road.name}" name="roadName"/></td>
                </tr>
           
            </table>
            <input type="submit" value="edit">
        </form>

        <form action="<c:url value='/roads'/>" method="get">
            <input type="submit" value="Back">
        </form>
    </body>
</html>