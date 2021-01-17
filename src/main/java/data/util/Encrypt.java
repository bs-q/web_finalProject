/*
 * File Created: Saturday, 16th January 2021 10:13:45 pm
 * Author: Bui Si Quan (18110041@student.hcmute.edu.vn)
 * -----
 */
package data.util;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.*;
import javax.xml.bind.DatatypeConverter;

public class Encrypt {

    public static String sha1(String input) {
        String sha1 = null;
        try {
            MessageDigest msdDigest = MessageDigest.getInstance("SHA-1");
            msdDigest.update(input.getBytes("UTF-8"), 0, input.length());
            sha1 = DatatypeConverter.printHexBinary(msdDigest.digest());
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            Logger.getLogger(Encrypt.class.getName()).log(Level.SEVERE, null, e);
        }
        return sha1;
    }
}
