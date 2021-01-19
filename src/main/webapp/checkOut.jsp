<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Check out</title>
    <link rel="stylesheet" href="./assets/css/check-out.css" />
    <link rel="stylesheet" href="./assets/css/footer.css" />

    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <script src="https://kit.fontawesome.com/a076d05399.js"></script>
  </head>
  <body>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <%@taglib
    prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> <%@ taglib
    prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

    <div class="nav-bar">
      <div class="nav-bar-left">
        <div class="logo">Group 1</div>
        <div class="nav-bar-option">
          <ul>
            <li><a href="./home"> Home </a></li>
            <li><a href="./product"> Product </a></li>
            <li><a href="#"> About Us </a></li>
          </ul>
        </div>
      </div>
      <div class="nav-bar-right">
        <ul>
          <li id="log-in">
            <c:choose>
              <c:when test="${email==null}">
                <a href="./login" class="show-dropdown">
                  <i class="fas fa-user"></i>

                  Log in
                </a></c:when
              >
              <c:when test="${email!=null}">
                <a href="#" class="show-dropdown">
                  <i class="fas fa-user"></i>
                  <c:set var="name" value="${fn:split(email, '@')}" />
                  Hello, ${name[0]}
                </a>
              </c:when>
            </c:choose>
            <c:if test="${email!=null}"
              ><div class="dropdown-list">
                <div class="drop-box" onclick="on()">
                  <a href="./wishlist">
                    <i class="far fa-heart"></i> Wish list
                  </a>
                </div>
                <div class="drop-box">
                  <a href="#">
                    <i class="fas fa-shopping-cart"></i> Shop Cart
                  </a>
                </div>
                <div class="drop-box">
                  <a href="./logout">
                    <i class="fas fa-sign-out-alt"></i> Log out
                  </a>
                </div>
              </div>
            </c:if>
          </li>
          <c:if test="${email==null}"
            ><li><a href="#">Sign up</a></li></c:if
          >
        </ul>
      </div>
    </div>
    <div class="title">
      <div class="title-name">Check out</div>
    </div>
    <div class="container">
      <form class="check-info" method="POST" action="./order">
        <div class="header">
          <div class="header-name">Contact information</div>
          <div class="header-option">
            Already have an account? <a href="#">Log in</a>
          </div>
        </div>
        <input
          type="email"
          placeholder="Email"
          class="input-box"
          name="email"
        />
        <input
          type="tel"
          placeholder="Phone Number"
          class="input-box"
          name="phone"
        />
        <div class="header">
          <div class="header-name">Shipping address</div>
        </div>
        <div class="input-divice">
          <input
            type="text"
            placeholder="First name"
            class="input-box"
            name="fname"
          />
          <input
            type="text"
            placeholder="Last name"
            class="input-box"
            name="lname"
          />
        </div>
        <input
          type="address"
          placeholder="Address"
          class="input-box"
          name="address"
        />
        <input
          type="address"
          placeholder="Apartment, suite, ect.(optional)"
          class="input-box"
          name="apartment"
        />
        <input
          type="address"
          placeholder="City"
          class="input-box"
          name="city"
        />
        <div class="btn-option">
          <input type="submit" value="Confirm order" class="btn" />
          <input
            type="button"
            onclick="location.href='./product'"
            value="Continue Shopping"
            class="btn"
          />
        </div>
        <c:set var="total" scope="request" value="${0}" />

        <c:forEach var="i" items="${requestScope.items}">
          <c:set var="sum" scope="request"
            ><fmt:formatNumber
              type="number"
              minFractionDigits="2"
              maxFractionDigits="2"
              value="${total+i.shoes.shoesPrice*i.cartItemsQuantity}"
          /></c:set>
          <c:set var="total" value="${sum}" />
        </c:forEach>
        <input name="total" value="${total+30}" hidden />
        <input name="cid" value="${requestScope.cartid}" hidden />
      </form>
      <form action=""></form>
      <div class="check-cost">
        <div class="header">
          <div class="header-name">Your Order</div>
        </div>
        <div class="order-table">
          <table>
            <tr>
              <th>Product Name</th>
              <th>Total</th>
            </tr>
            <tr>
              <td>Cart Subtotal</td>
              <td>$ ${total}</td>
            </tr>
            <tr>
              <td>Shipping</td>
              <td>$30</td>
            </tr>
            <tr>
              <td>Order Total</td>
              <td>$ ${total+30}</td>
            </tr>
          </table>
        </div>
      </div>
    </div>
    <div class="footer">
      <div class="footer-content">
        <div class="footer-column">
          <div class="footer-head"><i class="fab fa-drupal"></i></div>
          <div class="footer-sub">
            "Live as if you were die tomorrow. Learn as ifyou were to live
            forever"
          </div>
          <div class="footer-sub" style="text-align: right">
            --Mabathma Gandhi--
          </div>
        </div>
        <div class="footer-column">
          <div class="footer-head">Contact</div>
          <div class="footer-sub">
            <i class="fas fa-map-marker-alt"></i>
            1 Vo Van Ngan St, Thu Duc City, HCM City
          </div>
          <div class="footer-sub">
            <i class="fas fa-phone"></i>
            Phone: 0918372548
          </div>
          <div class="footer-sub">
            <i class="fas fa-envelope"></i>
            Email: group1@student.hcmute.edu.vn
          </div>
        </div>
        <div class="footer-column">
          <div class="footer-head">Follow us</div>
          <div class="follow">
            <div class="footer-sub"><i class="fab fa-facebook"></i></div>
            <div class="footer-sub"><i class="fab fa-twitter"></i></div>
            <div class="footer-sub"><i class="fab fa-instagram"></i></div>
            <div class="footer-sub"><i class="fab fa-google-plus-g"></i></div>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>
