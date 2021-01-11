var cache = {};

var onCardOver = function (e, $card, $shoe) {
  var windowHeight = window.innerHeight;
  var windowWidth = window.innerWidth;

  var mousePercX = Math.round((e.pageX / windowWidth) * 100);
  var mousePercY = Math.round((e.pageY / windowHeight) * 100);

  var subtletyModifer = 0.08;
  $shoe.css(
    "transform",
    "rotateY(" +
      (mousePercX - 50) * subtletyModifer * -1 +
      "deg) " +
      "rotateX(" +
      (mousePercY - 50) * subtletyModifer +
      "deg) " +
      "translateZ(50px)"
  );
  $card.css(
    "transform",
    "rotateY(" +
      (mousePercX - 50) * subtletyModifer * -1 +
      "deg) " +
      "rotateX(" +
      (mousePercY - 50) * subtletyModifer +
      "deg)"
  );
};

(function () {
  $(function () {
    var $card = $(".card");
    var $shoe = $(".card__bg__image-hero");

    setTimeout(function () {
      $card.removeClass("loading");
    }, 50);
    setTimeout(function () {
      $shoe.removeClass("loading");
    }, 250);

    setTimeout(function () {
      $card.addClass("notransistion");
      $shoe.addClass("notransistion");
    }, 1000);

    window.addEventListener("mousemove", function (e) {
      onCardOver(e, $card, $shoe);
    });
  });
})();
