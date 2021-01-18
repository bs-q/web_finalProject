/*
 * File Created: Thursday, 14th January 2021 9:31:37 pm
 * Author: Bui Si Quan (18110041@student.hcmute.edu.vn)
 * -----
 * Last Modified: Thursday, 14th January 2021 9:31:57 pm
 */
package data.util;

import javax.servlet.http.*;

public class CookieUtil {

    
    public static String getCookieValue(Cookie[] cookies, String cookieName) {

        String cookieValue = "";
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookieName.equals(cookie.getName())) {
                    cookieValue = cookie.getValue();
                }
            }
        }
        return cookieValue;
    }
    public static void removeAllCookie(Cookie[]cookies,HttpServletResponse response) {   
        for (Cookie cookie : cookies) {
            cookie.setMaxAge(0);
            cookie.setPath("/");
            response.addCookie(cookie);
        }
    }
}
