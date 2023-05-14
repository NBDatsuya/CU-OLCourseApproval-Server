package ags.edu.cu.oca.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Hash {
    public static String hash(byte[] data, String algorithm) {
        try {
            var messageDigest = MessageDigest.getInstance(algorithm);
            messageDigest.update(data);
            var result = messageDigest.digest();
            return Base64.getUrlEncoder().encodeToString(result);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String sha512(byte[] data) {
        return hash(data, "SHA-512");
    }
}
