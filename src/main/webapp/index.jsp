<!--
File Created: Saturday, 16th January 2021 12:07:42 am
Author: Bui Si Quan (18110041@student.hcmute.edu.vn)
-----
-->
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>ok bro</title>
  </head>
  <body>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <h1>fuck you all</h1>
    <c:out value="${email}" />
    <c:forEach var="c" items="${allShoes}">
      <p>${c.shoesName}</p>
      <p>${c.shoesPrice}</p>
      <p>-----------</p>
    </c:forEach>

    <c:forEach var="c" items="${cookie}">
      <p>${c.value.name}</p>
      <p>${c.value.value}</p>
      <p>---</p>
    </c:forEach>
  </body>
</html>
