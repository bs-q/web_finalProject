<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>throw cookie</title>
</head>
<body>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:forEach var="c" items="${cookie}">
        <p>${c.value.name}</p>
        <p>${c.value.value}</p>
    </c:forEach>

    <h1>fake cookie</h1>
    <p>${requestScope.cookie}</p>
</body>
</html>