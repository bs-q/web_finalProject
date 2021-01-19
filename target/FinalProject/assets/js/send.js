/*
 * File Created: Sunday, 17th January 2021 4:22:05 pm
 * Author: Bui Si Quan (18110041@student.hcmute.edu.vn)
 * -----
 */
// var XMLHttpRequest = require("xmlhttprequest").XMLHttpRequest;
// var request = new XMLHttpRequest();
// request.open("GET", "http://localhost:8080/FinalProject/add?shoesId=101", true);
// request.send();

// request.onreadystatechange = function () {
//   if (this.readyState == 4) {
//     request.status == 200;

//     console.log(this.status);
//     window.alert("ok");
//   }
// };

function add(shoesId) {
  document.getElementById("loading").style.opacity = "100";
  document.getElementById("loading").style.visibility = "visible";
  var xhttp = new XMLHttpRequest();
  xhttp.open("GET", "./add?shoesId=" + shoesId, true);
  xhttp.send();
  xhttp.onreadystatechange = function () {
    if (this.readyState == 4) {
      if (this.status == 200) {
        alert("Add Successfully:");
      } else if (this.status == 410) {
        alert("login required");
      } else if (this.status == 406) {
        alert("wrong shoes id format");
      } else if (this.status == 409) {
        alert("wrong shoes id");
      } else if (this.status == 204) {
        alert("transaction failed");
      } else {
        alert("??? bug ???");
      }
      document.getElementById("loading").style.opacity = "0";
      document.getElementById("loading").style.visibility = "hidden";
    }
  };
}
