<!--
File Created: Friday, 15th January 2021 6:12:58 pm
Author: Bui Si Quan (18110041@student.hcmute.edu.vn)
-----
Last Modified: Friday, 15th January 2021 6:12:58 pm
-->
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>list cookie</title>
  </head>
  <body>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:forEach var="c" items="${cookie}">
      <p>${c.value.name}</p>
      <p>${c.value.value}</p>
    </c:forEach>
  </body>
</html>
