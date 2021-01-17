<!--
File Created: Sunday, 17th January 2021 10:05:12 am
Author: Bui Si Quan (18110041@student.hcmute.edu.vn)
-----
-->
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Product</title>
    <link rel="stylesheet" href="./assets/css/product.css" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <script src="https://kit.fontawesome.com/a076d05399.js"></script>
    <style>
      li .dropbtn {
        display: inline-block;
        color: white;
        text-align: center;
        padding: 14px 16px;
        text-decoration: none;
      }

      li.dropdown {
        display: inline-block;
      }

      .dropdown-content {
        display: none;
        position: absolute;
        background-color: #f9f9f9;
        min-width: 160px;
        box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
        z-index: 1;
      }

      .dropdown-content a {
        color: black;
        padding: 12px 16px;
        text-decoration: none;
        display: block;
        text-align: left;
      }

      .dropdown-content a:hover {
        background-color: #f1f1f1;
      }

      .dropdown:hover .dropdown-content {
        display: block;
      }
    </style>
  </head>
  <body>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <%@taglib
    prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

    <div class="nav-bar">
      <div class="nav-bar-left">
        <div class="logo">Group 1</div>
        <div class="nav-bar-option">
          <ul>
            <li><a href="#"> Home </a></li>
            <li><a href="#"> Product </a></li>
            <li><a href="#"> Home </a></li>
            <li><a href="#"> About Us </a></li>
          </ul>
        </div>
      </div>
      <div class="nav-bar-right">
        <ul>
          <c:if test="${email==null}">
            <li id="log-in">
              <a href="login">
                <i class="fas fa-user"></i>
                Log in
              </a>
            </li>
            <li><a href="register">Sign up</a></li>
          </c:if>
          <c:if test="${email!=null}">
            <li id="log-in" class="dropdown">
              <i class="fas fa-user"> </i
              ><c:set var="name" value="${fn:split(email, '@')}" />
              Hello, ${name[0]}
              <div class="dropdown-content">
                <a href="#">My cart</a>
                <a href="#">My account</a>
                <a href="#">Log out</a>
              </div>
            </li>
          </c:if>
        </ul>
      </div>
    </div>

    <div class="footer">
      <div class="footer-content">
        <div class="footer-column">
          <div class="footer-head">Product</div>
          <div class="footer-sub">Men</div>
          <div class="footer-sub">Women</div>
          <div class="footer-sub">Children</div>
        </div>
        <div class="footer-column">
          <div class="footer-head">About us</div>
          <div class="footer-sub">Member</div>
          <div class="footer-sub">Member</div>
          <div class="footer-sub">Member</div>
          <div class="footer-sub">Member</div>
        </div>
        <div class="footer-column">
          <div class="footer-head">About us</div>
          <div class="footer-sub">Member</div>
          <div class="footer-sub">Member</div>
          <div class="footer-sub">Member</div>
          <div class="footer-sub">Member</div>
        </div>
        <div class="footer-column">
          <div class="footer-head">About us</div>
          <div class="footer-sub">Member</div>
          <div class="footer-sub">Member</div>
          <div class="footer-sub">Member</div>
          <div class="footer-sub">Member</div>
        </div>
      </div>
    </div>
  </body>
</html>
