<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Register</title>
    <link rel="stylesheet" type="text/css" href="./assets/css/login.css" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <script src="https://kit.fontawesome.com/a076d05399.js"></script>
    <script src="./assets/js/form-validate.js"></script>
  </head>
  <body>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <div class="form-main form-register">
      <h1 style="margin-bottom: 45px">Register</h1>
      <form method="POST" action="register" name="registration">
        <div class="login-user">
          <i class="fas fa-user-alt"></i>
          <input type="text" name="firstname" class="input" placeholder="First
          name" value="<c:out value="${firstname}" />" />
        </div>
        <div class="login-user">
          <i class="fas fa-user-alt"></i>
          <input
            type="text"
            name="lastname"
            class="input"
            placeholder="Last name"
          />
        </div>
        <div class="login-user">
          <i class="fas fa-envelope"></i>
          <input
            id="email"
            type="email"
            name="email"
            class="input"
            placeholder="Email@email.com"
          />
        </div>
        <div class="login-user">
          <i class="fas fa-lock"></i>
          <input
            type="password"
            name="password"
            class="input"
            placeholder="Password"
          />
        </div>
        <div class="login-user">
          <i class="fas fa-key"></i>
          <input
            type="password"
            name="password-cf"
            class="input"
            placeholder="Confirm Password"
          />
        </div>
        <div class="forgot">
          <div class="remember">
            <input type="checkbox" name="remember" id="remember" />
            <label for="remember">Show Password</label>
          </div>
          <a href="./login.html">Return to Sign-in page?</a>
        </div>
        <button class="btn" type="submit">Register</button>
      </form>
    </div>
  </body>
</html>
