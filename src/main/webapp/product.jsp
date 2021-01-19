<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Product</title>
    <link rel="stylesheet" href="./assets/css/product.css" />
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
            <li><a href="./home" onclick="loading()"> Home </a></li>
            <li><a href="./product" onclick="loading()"> Product </a></li>
            <li><a href="#" onclick="loading()"> About Us </a></li>
          </ul>
        </div>
      </div>
      <div class="nav-bar-right">
        <ul>
          <li id="log-in">
            <c:choose>
              <c:when test="${email==null}">
                <a href="./login" onclick="loading()"class="show-dropdown">
                  <i class="fas fa-user"></i>

                  Log in
                </a></c:when
              >
              <c:when test="${email!=null}">
                <a href="#" onclick="loading()" class="show-dropdown">
                  <i class="fas fa-user"></i>
                  <c:set var="name" value="${fn:split(email, '@')}" />
                  Hello, ${name[0]}
                </a>
              </c:when>
            </c:choose>
            <c:if test="${email!=null}"
              ><div class="dropdown-list">
                <div class="drop-box">
                  <a href="./wishlist" onclick="loading()">
                    <i class="far fa-heart"></i> Wish list
                  </a>
                </div>
                <div class="drop-box">
                  <a href="./cart" onclick="loading()">
                    <i class="fas fa-shopping-cart"></i> Shop Cart
                  </a>
                </div>
                <div class="drop-box">
                  <a href="./logout" onclick="loading()">
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
      <div class="title-name">Product</div>
    </div>
    <div class="list-product">
      <c:forEach var="i" begin="0" end="28">
        <!--  -->
        <div class="product-box">
          <div class="product-img">
            <img src="${allShoes[i].color.image}" alt="Hinh giay" />
          </div>
          <div class="product-content">
            <div class="product-name">${allShoes[i].shoesName}</div>
            <div class="product-price">${allShoes[i].shoesPrice} $</div>
            <div class="btn-option">
              <button
                class="btn"
                id="${allShoes[i].shoesId}"
                onclick="add(this.id)"
              >
                <i class="fas fa-shopping-cart"></i>
              </button>
              <button class="btn"><i class="far fa-heart"></i></button>
            </div>
          </div>
        </div>
        <!--  --></c:forEach
      >
    </div>
    <div class="footer">
      <div class="footer-content">
        <div class="footer-column">
          <div class="footer-head"><i class="fab fa-drupal"></i></div>
          <div class="footer-sub">
            "Live as if you were die tomorrow. Learn as if you were to live
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
    <div id="loading" class="loading" style="opacity: 0; visibility: hidden">
      <img src="./assets/img/load.gif" />
    </div>
    <script src="./assets/js/loading.js"></script>
        <script src="./assets/js/send.js"></script>

  </body>
</html>
