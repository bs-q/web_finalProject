<!DOCTYPE html>
<html lang="en">
<head>
    <title>Shopping Cart</title>
    <link rel="stylesheet" href="./assets/css/shopping-cart.css">
        <link rel="stylesheet" href="./assets/css/footer.css" />

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://kit.fontawesome.com/a076d05399.js"></script>
</head>
<body>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <%@taglib
    prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
         <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
                  <a href="./wishlist"> <i class="far fa-heart"></i> Wish list </a>
                </div>
                <div class="drop-box">
                  <a href="#">
                    <i class="fas fa-shopping-cart"></i> Shop Cart
                  </a>
                </div>
                <div class="drop-box">
                  <a href="./logout"> <i class="fas fa-sign-out-alt"></i> Log out </a>
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
    <div class=" title">
        <div class="title-name">Shopping Cart</div>
    </div>
    <section class="product-list">
        <div class="properties">
            <table>
                <tr>
                    <th class="t-product">PRODUCTS</th>
                    <th class="t-name">NAME</th>
                    <th class="t-unitprice">UNIT PRICE</th>
                    <th class="t-quantity">QUANTITY</th>
                    <th class="t-total">TOTAL</th>
                </tr>

                <c:set var="total" scope="request" value="${0}"/>
                <c:forEach var="i" items="${requestScope.items}">
                    <tr>
                    <td><img src="${i.shoes.color.image}" alt="Hinh Mau"></td>
                    <td>${i.shoes.shoesName}</td>
                    <td>${i.shoes.shoesPrice}</td>
                    <td>${i.cartItemsQuantity}</td>
                    <td><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${i.shoes.shoesPrice*i.cartItemsQuantity}" /></td>
                    <td>
                    <c:set var="sum" scope="request"><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${total+i.shoes.shoesPrice*i.cartItemsQuantity}" /></c:set>
                    <c:set var="total" value="${sum}"/>

                    <a href="./delete?cid=${requestScope.cartId}&id=${i.cartItemsId}"><i class="fas fa-trash"></i></a></td>
                </tr>
                </c:forEach>
                
            </table>
        </div>
    </section>
    <div class="cart-footer">
        <div class="note">
            <textarea name="note" class="note-input" id="" cols="30" rows="10" placeholder="Add a note to your order"></textarea>
        </div>
        <div class="total">
            <div class="total-content">
                <div class="sum-price">
                    <div class="label">Total</div>
                    <div class="price"> ${total}</div>
                </div>
                <div class="shipping">
                    Shipping and taxes calculated at checkout
                </div>
                <div class="btn-option">
                    <input type="button" value="Continue Shopping" onclick="location.href='./product';loading()" class="btn">
                    <input type="button" value="Check out" class="btn" onclick="location.href='./checkout';loading()" >
                </div>
            </div>
        </div>
    </div>
        <div id="loading" class="loading" style="opacity: 0; visibility: hidden">
      <img src="./assets/img/load.gif" />
    </div>
    <script src="./assets/js/loading.js"></script>
</body>
</html>