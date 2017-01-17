package com.hsenid.reader;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

/**
 * Created by 0004072 on 1/17/17.
 */
public class Utilities {
    public String getSHA(String convertMe, int length) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-".concat(String.valueOf(length)));
        return byteArray2Hex(md.digest(convertMe.getBytes()));
    }

    private String byteArray2Hex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash) {
            formatter.format("%02x", b);
        }
        return formatter.toString();
    }
}
