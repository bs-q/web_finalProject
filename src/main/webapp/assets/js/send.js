/*
 * File Created: Sunday, 17th January 2021 4:22:05 pm
 * Author: Bui Si Quan (18110041@student.hcmute.edu.vn)
 * -----
 */
var XMLHttpRequest = require("xmlhttprequest").XMLHttpRequest;
var request = new XMLHttpRequest();
request.open("GET", "http://localhost:8080/FinalProject/add", true);
request.send();

request.onreadystatechange = function () {
  if (this.readyState == 4) {
    request.status==200
    
    console.log(this.status);
    window.alert("fuck you");
  }
  
};
