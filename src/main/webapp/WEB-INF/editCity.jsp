
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit city</title>
    </head>
    <body>

        <form method="POST">
            <input type="hidden" name="id" value="${city.name}"/>
            <table>
                <tr>
                    <td>id</td>
                    <td>${city.id}</td>
                </tr>
                <tr>
                    <td>name</td>
                    <td><input type="text" value="${city.name}" name="cityName"/></td>
                </tr>
           
            </table>
            <input type="submit" value="edit">
        </form>

        <form action="<c:url value='/cities'/>" method="get">
            <input type="submit" value="Back">
        </form>
    </body>
</html>
