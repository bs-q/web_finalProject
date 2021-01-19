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
//     window.alert("fuck you");
//   }
// };
function addSuccess(shoesId) {
  var xhttp = new XMLHttpRequest();
  xhttp.open("GET", "./add?shoesId=" + shoesId, true);
  xhttp.send();
  xhttp.onreadystatechange = function () {
    if (this.readyState == 4) {
      if (this.status == 200) {
        alert("Add Successfully:" + shoesId);
      } else {
        alert("add failed:" + shoesId);
      }
    }
  };
}
