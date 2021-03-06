<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Register</title>
    <link rel="stylesheet" type="text/css" href="./assets/css/login.css" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <script src="https://kit.fontawesome.com/a076d05399.js"></script>
  </head>
  <body>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <div class="form-main form-register">
      <h1 style="margin-bottom: 45px">Register</h1>
      <form method="POST" action="register" name="registration">
        <div class="login-user">
          <i class="fas fa-user-alt"></i>
          <input
            type="text"
            name="firstname"
            class="input"
            placeholder="First name"
            value="${firstname}"
            required
            pattern="^[a-zA-Z\\s]+"
            maxlength="50"
          />
        </div>
        <div class="login-user">
          <i class="fas fa-user-alt"></i>
          <input
            type="text"
            value="${lastname}"
            name="lastname"
            class="input"
            placeholder="Last name"
            required
            pattern="^[a-zA-Z\\s]+"
            maxlength="50"
          />
        </div>
        <div class="login-user">
          <i class="fas fa-envelope"></i>
          <input
            id="email"
            type="email"
            name="email"
            value="${email}"
            class="input"
            placeholder="Email@email.com"
            pattern="^[\w.+\-]+@gmail\.com$"
            required
          />
        </div>
        <div class="login-user">
          <i class="fas fa-lock"></i>
          <input
            type="password"
            name="password"
            value="${password}"
            class="input"
            placeholder="Password"
            required
            pattern="^\S{6,}$"
            id="password"
            onchange=" if(this.checkValidity()) form.password_two.pattern = this.value;"
          />
        </div>
        <div class="login-user">
          <i class="fas fa-key"></i>
          <input
            type="password"
            name="password-cf"
            value="${conPassword}"
            class="input"
            placeholder="Confirm Password"
            required
            min="6"
            id="password_two"
          />
        </div>
        <div class="forgot">
          <div class="remember">
            <input type="checkbox" name="remember" id="remember" />
            <label for="remember">Show Password</label>
          </div>
          <a href="./login">Return to Sign-in page?</a>
        </div>
        <c:if test="${registered==true}">
          <p style="color: red">
            This email has been registered, try another one
          </p>
        </c:if>
        <button class="btn" type="submit">Register</button>
      </form>
    </div>
    <script src="./assets/js/form-validate.js"></script>
  </body>
</html>
