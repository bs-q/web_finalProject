<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Home</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="./assets/css/home.css" />
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
            <li><a href="/home.html"> Home </a></li>
            <li><a href="/product.html"> Product </a></li>
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
              <c:forEach var="i" begin="1" end="4">
                <!--  -->
                <div class="product-box">
                  <div class="product-img">
                    <img src="./src/img/giay1.jpg" alt="Hinh giay" />
                  </div>
                  <div class="product-content">
                    <div class="product-name">${allShoes[i]}</div>
                    <div class="product-price">${allShoes[i].shoesPrice}</div>
                    <div class="btn-option">
                      <button class="btn">
                        <i class="fas fa-shopping-cart"></i>
                      </button>
                      <button class="btn"><i class="far fa-heart"></i></button>
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
              <div class="product-box">
                <div class="product-img">
                  <img src="./src/img/giay1.jpg" alt="Hinh giay" />
                </div>
                <div class="product-content">
                  <div class="product-name">Ultra Boost 2019</div>
                  <div class="product-price">$721.00</div>
                  <div class="btn-option">
                    <button class="btn">
                      <i class="fas fa-shopping-cart"></i>
                    </button>
                    <button class="btn"><i class="far fa-heart"></i></button>
                    <button class="btn"><i class="far fa-heart"></i></button>
                  </div>
                </div>
              </div>
              <div class="product-box">
                <div class="product-img">
                  <img src="./src/img/giay1.jpg" alt="Hinh giay" />
                </div>
                <div class="product-content">
                  <div class="product-name">Ultra Boost 2019</div>
                  <div class="product-price">$721.00</div>
                  <div class="btn-option">
                    <button class="btn">
                      <i class="fas fa-shopping-cart"></i>
                    </button>
                    <button class="btn"><i class="far fa-heart"></i></button>
                    <button class="btn"><i class="far fa-heart"></i></button>
                  </div>
                </div>
              </div>
              <div class="product-box">
                <div class="product-img">
                  <img src="./src/img/giay1.jpg" alt="Hinh giay" />
                </div>
                <div class="product-content">
                  <div class="product-name">Ultra Boost 2019</div>
                  <div class="product-price">$721.00</div>
                  <div class="btn-option">
                    <button class="btn">
                      <i class="fas fa-shopping-cart"></i>
                    </button>
                    <button class="btn"><i class="far fa-heart"></i></button>
                    <button class="btn"><i class="far fa-heart"></i></button>
                  </div>
                </div>
              </div>
              <div class="product-box">
                <div class="product-img">
                  <img src="./src/img/giay1.jpg" alt="Hinh giay" />
                </div>
                <div class="product-content">
                  <div class="product-name">Ultra Boost 2019</div>
                  <div class="product-price">$721.00</div>
                  <div class="btn-option">
                    <button class="btn">
                      <i class="fas fa-shopping-cart"></i>
                    </button>
                    <button class="btn"><i class="far fa-heart"></i></button>
                    <button class="btn"><i class="far fa-heart"></i></button>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <!--  -->
          <div class="item">
            <div class="list-product">
              <div class="product-box">
                <div class="product-img">
                  <img src="./src/img/giay1.jpg" alt="Hinh giay" />
                </div>
                <div class="product-content">
                  <div class="product-name">Ultra Boost 2019</div>
                  <div class="product-price">$721.00</div>
                  <div class="btn-option">
                    <button class="btn">
                      <i class="fas fa-shopping-cart"></i>
                    </button>
                    <button class="btn"><i class="far fa-heart"></i></button>
                    <button class="btn"><i class="far fa-heart"></i></button>
                  </div>
                </div>
              </div>
              <div class="product-box">
                <div class="product-img">
                  <img src="./src/img/giay1.jpg" alt="Hinh giay" />
                </div>
                <div class="product-content">
                  <div class="product-name">Ultra Boost 2019</div>
                  <div class="product-price">$721.00</div>
                  <div class="btn-option">
                    <button class="btn">
                      <i class="fas fa-shopping-cart"></i>
                    </button>
                    <button class="btn"><i class="far fa-heart"></i></button>
                    <button class="btn"><i class="far fa-heart"></i></button>
                  </div>
                </div>
              </div>
              <div class="product-box">
                <div class="product-img">
                  <img src="./src/img/giay1.jpg" alt="Hinh giay" />
                </div>
                <div class="product-content">
                  <div class="product-name">Ultra Boost 2019</div>
                  <div class="product-price">$721.00</div>
                  <div class="btn-option">
                    <button class="btn">
                      <i class="fas fa-shopping-cart"></i>
                    </button>
                    <button class="btn"><i class="far fa-heart"></i></button>
                    <button class="btn"><i class="far fa-heart"></i></button>
                  </div>
                </div>
              </div>
              <div class="product-box">
                <div class="product-img">
                  <img src="./src/img/giay1.jpg" alt="Hinh giay" />
                </div>
                <div class="product-content">
                  <div class="product-name">Ultra Boost 2019</div>
                  <div class="product-price">$721.00</div>
                  <div class="btn-option">
                    <button class="btn">
                      <i class="fas fa-shopping-cart"></i>
                    </button>
                    <button class="btn"><i class="far fa-heart"></i></button>
                    <button class="btn"><i class="far fa-heart"></i></button>
                  </div>
                </div>
              </div>
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
              <div class="product-box">
                <div class="product-img">
                  <img src="./src/img/giay1.jpg" alt="Hinh giay" />
                </div>
                <div class="product-content">
                  <div class="product-name">Ultra Boost 2019</div>
                  <div class="product-price">$721.00</div>
                  <div class="btn-option">
                    <button class="btn">
                      <i class="fas fa-shopping-cart"></i>
                    </button>
                    <button class="btn"><i class="far fa-heart"></i></button>
                    <button class="btn"><i class="far fa-heart"></i></button>
                  </div>
                </div>
              </div>
              <div class="product-box">
                <div class="product-img">
                  <img src="./src/img/giay1.jpg" alt="Hinh giay" />
                </div>
                <div class="product-content">
                  <div class="product-name">Ultra Boost 2019</div>
                  <div class="product-price">$721.00</div>
                  <div class="btn-option">
                    <button class="btn">
                      <i class="fas fa-shopping-cart"></i>
                    </button>
                    <button class="btn"><i class="far fa-heart"></i></button>
                    <button class="btn"><i class="far fa-heart"></i></button>
                  </div>
                </div>
              </div>
              <div class="product-box">
                <div class="product-img">
                  <img src="./src/img/giay1.jpg" alt="Hinh giay" />
                </div>
                <div class="product-content">
                  <div class="product-name">Ultra Boost 2019</div>
                  <div class="product-price">$721.00</div>
                  <div class="btn-option">
                    <button class="btn">
                      <i class="fas fa-shopping-cart"></i>
                    </button>
                    <button class="btn"><i class="far fa-heart"></i></button>
                    <button class="btn"><i class="far fa-heart"></i></button>
                  </div>
                </div>
              </div>
              <div class="product-box">
                <div class="product-img">
                  <img src="./src/img/giay1.jpg" alt="Hinh giay" />
                </div>
                <div class="product-content">
                  <div class="product-name">Ultra Boost 2019</div>
                  <div class="product-price">$721.00</div>
                  <div class="btn-option">
                    <button class="btn">
                      <i class="fas fa-shopping-cart"></i>
                    </button>
                    <button class="btn"><i class="far fa-heart"></i></button>
                    <button class="btn"><i class="far fa-heart"></i></button>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="item">
            <div class="list-product">
              <div class="product-box">
                <div class="product-img">
                  <img src="./src/img/giay1.jpg" alt="Hinh giay" />
                </div>
                <div class="product-content">
                  <div class="product-name">Ultra Boost 2019</div>
                  <div class="product-price">$721.00</div>
                  <div class="btn-option">
                    <button class="btn">
                      <i class="fas fa-shopping-cart"></i>
                    </button>
                    <button class="btn"><i class="far fa-heart"></i></button>
                    <button class="btn"><i class="far fa-heart"></i></button>
                  </div>
                </div>
              </div>
              <div class="product-box">
                <div class="product-img">
                  <img src="./src/img/giay1.jpg" alt="Hinh giay" />
                </div>
                <div class="product-content">
                  <div class="product-name">Ultra Boost 2019</div>
                  <div class="product-price">$721.00</div>
                  <div class="btn-option">
                    <button class="btn">
                      <i class="fas fa-shopping-cart"></i>
                    </button>
                    <button class="btn"><i class="far fa-heart"></i></button>
                    <button class="btn"><i class="far fa-heart"></i></button>
                  </div>
                </div>
              </div>
              <div class="product-box">
                <div class="product-img">
                  <img src="./src/img/giay1.jpg" alt="Hinh giay" />
                </div>
                <div class="product-content">
                  <div class="product-name">Ultra Boost 2019</div>
                  <div class="product-price">$721.00</div>
                  <div class="btn-option">
                    <button class="btn">
                      <i class="fas fa-shopping-cart"></i>
                    </button>
                    <button class="btn"><i class="far fa-heart"></i></button>
                    <button class="btn"><i class="far fa-heart"></i></button>
                  </div>
                </div>
              </div>
              <div class="product-box">
                <div class="product-img">
                  <img src="./src/img/giay1.jpg" alt="Hinh giay" />
                </div>
                <div class="product-content">
                  <div class="product-name">Ultra Boost 2019</div>
                  <div class="product-price">$721.00</div>
                  <div class="btn-option">
                    <button class="btn">
                      <i class="fas fa-shopping-cart"></i>
                    </button>
                    <button class="btn"><i class="far fa-heart"></i></button>
                    <button class="btn"><i class="far fa-heart"></i></button>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="item">
            <div class="list-product">
              <div class="product-box">
                <div class="product-img">
                  <img src="./src/img/giay1.jpg" alt="Hinh giay" />
                </div>
                <div class="product-content">
                  <div class="product-name">Ultra Boost 2019</div>
                  <div class="product-price">$721.00</div>
                  <div class="btn-option">
                    <button class="btn">
                      <i class="fas fa-shopping-cart"></i>
                    </button>
                    <button class="btn"><i class="far fa-heart"></i></button>
                    <button class="btn"><i class="far fa-heart"></i></button>
                  </div>
                </div>
              </div>
              <div class="product-box">
                <div class="product-img">
                  <img src="./src/img/giay1.jpg" alt="Hinh giay" />
                </div>
                <div class="product-content">
                  <div class="product-name">Ultra Boost 2019</div>
                  <div class="product-price">$721.00</div>
                  <div class="btn-option">
                    <button class="btn">
                      <i class="fas fa-shopping-cart"></i>
                    </button>
                    <button class="btn"><i class="far fa-heart"></i></button>
                    <button class="btn"><i class="far fa-heart"></i></button>
                  </div>
                </div>
              </div>
              <div class="product-box">
                <div class="product-img">
                  <img src="./src/img/giay1.jpg" alt="Hinh giay" />
                </div>
                <div class="product-content">
                  <div class="product-name">Ultra Boost 2019</div>
                  <div class="product-price">$721.00</div>
                  <div class="btn-option">
                    <button class="btn">
                      <i class="fas fa-shopping-cart"></i>
                    </button>
                    <button class="btn"><i class="far fa-heart"></i></button>
                    <button class="btn"><i class="far fa-heart"></i></button>
                  </div>
                </div>
              </div>
              <div class="product-box">
                <div class="product-img">
                  <img src="./src/img/giay1.jpg" alt="Hinh giay" />
                </div>
                <div class="product-content">
                  <div class="product-name">Ultra Boost 2019</div>
                  <div class="product-price">$721.00</div>
                  <div class="btn-option">
                    <button class="btn">
                      <i class="fas fa-shopping-cart"></i>
                    </button>
                    <button class="btn"><i class="far fa-heart"></i></button>
                    <button class="btn"><i class="far fa-heart"></i></button>
                  </div>
                </div>
              </div>
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
