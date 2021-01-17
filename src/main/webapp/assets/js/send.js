/*
 * File Created: Sunday, 17th January 2021 4:22:05 pm
 * Author: Bui Si Quan (18110041@student.hcmute.edu.vn)
 * -----
 */
var XMLHttpRequest = require("xmlhttprequest").XMLHttpRequest;
var request = new XMLHttpRequest();
request.open("GET", "http://localhost:8080/FinalProject/js?shoesId=1", true);
request.send()

setTimeout(() => {
    console.log(request.status)
}, 2000);