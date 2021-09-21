package com.example.cryptography;

import android.util.Base64;
import android.widget.Toast;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class Encrypt {
    private static final String ALGORITHM = "AES";
    private static final byte[] keyValue = new byte[]{'T', '*', 'e', '>', 'e', 'W', 't', 'S', 'Q', 'P', 'r', '!', 't', 'M', 'N', '&'};
    public static String encode(String s) {
        String returnValue ="";
        try {
            Key key = generateKey();
            Cipher c = Cipher.getInstance(ALGORITHM);
            c.init(Cipher.ENCRYPT_MODE, key);
            byte[] encodeValue = Base64.encode(s.getBytes(), Base64.DEFAULT);
            returnValue = new String(encodeValue);


        }
        catch(IllegalArgumentException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException ie){
        }
        return returnValue;
    }
    private static Key generateKey() {
        Key key = new SecretKeySpec(keyValue, ALGORITHM);
        return key;
    }

}
