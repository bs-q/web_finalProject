<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Home</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="./assets/css/home.css" />
    <link rel="stylesheet" href="./assets/css/footer.css" />
    <link
      rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
    />
    <script src="https://kit.fontawesome.com/a076d05399.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  </head>
  <body>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <%@taglib
    prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
            <a href="#" class="show-dropdown">
              <i class="fas fa-user"></i>
              <c:choose>
                <c:when test="${email==null}"> Log in </c:when>
                <c:when test="${email!=null}">
                  <c:set var="name" value="${fn:split(email, '@')}" />
                  Hello, ${name[0]}
                </c:when>
              </c:choose>
            </a>
            <c:if test="${email!=null}"
              ><div class="dropdown-list">
                <div class="drop-box">
                  <a href="./wishlist"> <i class="far fa-heart"></i> Wish list </a>
                </div>
                <div class="drop-box">
                  <a href="./cart">
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
    <div class="container">
      <h2>Carousel</h2>
      <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
          <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
          <li data-target="#myCarousel" data-slide-to="1"></li>
          <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner">
          <div class="item active">
            <img
              src="./assets/img/poster-main.png"
              alt="Poster 1"
              style="width: 100%; height: 720px"
            />
          </div>

          <div class="item">
            <img
              src="./assets/img/poster-main1.png"
              alt="Poster 2"
              style="width: 100%; height: 720px"
            />
          </div>

          <div class="item">
            <img
              src="./assets/img/poster5.jpg"
              alt="Poster 3"
              style="width: 100%; height: 720px"
            />
          </div>
        </div>

        <!-- Left and right controls -->
        <a class="left carousel-control" href="#myCarousel" data-slide="prev">
          <span class="glyphicon glyphicon-chevron-left"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#myCarousel" data-slide="next">
          <span class="glyphicon glyphicon-chevron-right"></span>
          <span class="sr-only">Next</span>
        </a>
      </div>
    </div>
    <div class="container">
      <h2>Men's</h2>
      <div id="myCarousel-product" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
          <li
            data-target="#myCarousel-product"
            data-slide-to="0"
            class="active"
          ></li>
          <li data-target="#myCarousel-product" data-slide-to="1"></li>
          <li data-target="#myCarousel-product" data-slide-to="2"></li>
        </ol>
        <!-- 12 picture -->
        <!-- Wrapper for slides -->
        <div class="carousel-inner">
          <div class="item active">
            <div class="list-product">
              <c:forEach var="i" begin="0" end="3">
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
                        onclick="addSuccess(this.id)"
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
          </div>

          <!--  -->
          <div class="item">
            <div class="list-product">
              <c:forEach var="i" begin="4" end="7">
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
                        onclick="addSuccess(this.id)"
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
          </div>
          <!--  -->
          <div class="item">
            <div class="list-product">
              <c:forEach var="i" begin="8" end="11">
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
                        onclick="addSuccess(this.id)"
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
          </div>
        </div>

        <!-- Left and right controls -->
        <a
          class="left carousel-control btn-control"
          href="#myCarousel-product"
          data-slide="prev"
        >
          <span class="glyphicon glyphicon-chevron-left"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a
          class="right carousel-control btn-control"
          href="#myCarousel-product"
          data-slide="next"
        >
          <span class="glyphicon glyphicon-chevron-right"></span>
          <span class="sr-only">Next</span>
        </a>
      </div>
    </div>
    <div class="container">
      <h2>Women's</h2>
      <div id="myCarousel-product2" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
          <li
            data-target="#myCarousel-product2"
            data-slide-to="0"
            class="active"
          ></li>
          <li data-target="#myCarousel-product2" data-slide-to="1"></li>
          <li data-target="#myCarousel-product2" data-slide-to="2"></li>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner">
          <div class="item active">
            <div class="list-product">
              <c:forEach var="i" begin="12" end="15">
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
                        onclick="addSuccess(this.id)"
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
          </div>
          <div class="item">
            <div class="list-product">
              <c:forEach var="i" begin="16" end="19">
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
                        onclick="addSuccess(this.id)"
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
          </div>
          <div class="item">
            <div class="list-product">
              <c:forEach var="i" begin="20" end="23">
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
                        onclick="addSuccess(this.id)"
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
          </div>
        </div>

        <!-- Left and right controls -->
        <a
          class="left carousel-control btn-control"
          href="#myCarousel-product2"
          data-slide="prev"
        >
          <span class="glyphicon glyphicon-chevron-left"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a
          class="right carousel-control btn-control"
          href="#myCarousel-product2"
          data-slide="next"
        >
          <span class="glyphicon glyphicon-chevron-right"></span>
          <span class="sr-only">Next</span>
        </a>
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
    <script src="./assets/js/send.js"></script>
  </body>
</html>
