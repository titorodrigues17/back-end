package com.curiosity.backend.service;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AesService {

    private static final String SECRET_KEY = "1234567890123456"; // 16 bytes para AES-128

    // Método para cifrar un texto
    public static String encrypt(String text) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedText = cipher.doFinal(text.getBytes());
        return Base64.getEncoder().encodeToString(encryptedText);
    }

    // Método para descifrar un texto
    public static String decrypt(String encryptedText) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decodedText = Base64.getDecoder().decode(encryptedText);
        byte[] decryptedText = cipher.doFinal(decodedText);
        return new String(decryptedText);
    }
}
