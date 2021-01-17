<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="./assets/css/login.css" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <script src="https://kit.fontawesome.com/a076d05399.js"></script>
  </head>
  <body>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <div class="form-main form-login">
      <h1 style="margin-bottom: 40px">Sign in</h1>
      <form action="login" method="POST">
        <div class="login-user">
          <i class="fas fa-user-alt"></i>
          <input
            type="email"
            name="email"
            value="${requestScope.email}"
            id="email"
            class="input"
            placeholder="Email"
            pattern="^[\w.+\-]+@gmail\.com$"
            required
          />
        </div>
        <div class="login-user">
          <i class="fas fa-lock"></i>
          <input
            type="password"
            name="password"
            id="password"
            value="${requestScope.password}"
            class="input"
            required
            placeholder="Password"
            pattern="^\S{6,}$"
          />
        </div>
        <div class="forgot">
          <div class="remember">
            <input type="checkbox" name="remember" id="remember" />
            <label for="remember">Remember me</label>
          </div>
          <a href="#">Forgot Password?</a>
        </div>
        <button class="btn" type="submit">Sign in</button>
        <c:if test="${requestScope.valid==false}">
          <p style="color: red">the email or password is incorrect</p>
        </c:if>
      </form>
      <div class="register">
        <span>Don't have an account?</span>
        <a href="./register"><b>&nbspRegister</b></a>
      </div>
    </div>
    <script src="./assets/js/login-validate.js"></script>
  </body>
</html>
