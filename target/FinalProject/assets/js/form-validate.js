/*
 * File Created: Friday, 15th January 2021 9:19:31 pm
 * Author: Bui Si Quan (18110041@student.hcmute.edu.vn)
 * -----
 * Last Modified: Friday, 15th January 2021 9:19:31 pm
 */
const email = document.getElementById("email");
email.addEventListener("input", function (event) {
  if (email.validity.typeMismatch) {
    email.setCustomValidity("I am expecting an e-mail address!");
  } else {
    email.setCustomValidity("");
  }
});
