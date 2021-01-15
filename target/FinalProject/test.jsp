<!--
File Created: Thursday, 14th January 2021 10:54:02 pm
Author: Bui Si Quan (18110041@student.hcmute.edu.vn)
-----
Last Modified: Thursday, 14th January 2021 10:54:02 pm
-->
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>test jsp file</title>
  </head>
  <body>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <jsp:useBean id="user" scope="request" class="models.Color">
        <jsp:setProperty name="user" property="color" value="ok"/>
    </jsp:useBean>

  </body>
</html>
