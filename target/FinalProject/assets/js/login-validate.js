/*
 * File Created: Friday, 15th January 2021 11:32:08 pm
 * Author: Bui Si Quan (18110041@student.hcmute.edu.vn)
 * -----
 * Last Modified: Friday, 15th January 2021 11:32:09 pm
 */
const email = document.getElementById("email");

email.addEventListener("input", function (event) {
  if (email.validity.typeMismatch) {
    email.setCustomValidity("I am expecting an e-mail address!");
  } else if (email.validity.patternMismatch) {
    email.setCustomValidity("we only support gmail");
  } else {
    email.setCustomValidity("");
  }
});

const password = document.getElementById("password");
password.addEventListener("input", function (event) {
  if (password.validity.patternMismatch) {
    password.setCustomValidity("Must have at least 6 characters");
  } else {
    password.setCustomValidity("");
  }
});
