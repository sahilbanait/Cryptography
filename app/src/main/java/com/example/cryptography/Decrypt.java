package com.example.cryptography;

import android.util.Base64;
import android.util.Log;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class Decrypt {
    private static final String ALGORITHM = "AES";
    private static final byte[] keyValue = new byte[]{'T', '*', 'e', '>', 'e', 'W', 't', 'S', 'Q', 'P', 'r', '!', 't', 'M', 'N', '&'};
    public static String decode(String s) {
        String returnValue ="";
        try {
            Key key = generateKey();
            Cipher c = Cipher.getInstance(ALGORITHM);
            c.init(Cipher.DECRYPT_MODE, key);

            byte[] decodedValue = Base64.decode(s.getBytes(), Base64.DEFAULT);
            returnValue = new String(decodedValue);

        }
        catch(IllegalArgumentException | NoSuchAlgorithmException | NoSuchPaddingException |InvalidKeyException ie){

        }
        return returnValue;
    }
    private static Key generateKey() {
        Key key = new SecretKeySpec(keyValue, ALGORITHM);
        return key;
    }
}
