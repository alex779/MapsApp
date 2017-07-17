
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome!</title>
    </head>
    <body>
        <form action="<c:url value='/roads'/>" method="get">
            <input type="submit" value="Roads list">
        </form>

        <form action="<c:url value='/cities'/>" method="get">
            <input type="submit" value="Cities list">
        </form>

        <form action="<c:url value='/addCity'/>" method="post">
            <input type="submit" value="Add new city or road">
        </form>

    </body>
</html>
