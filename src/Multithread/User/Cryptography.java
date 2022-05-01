package Multithread.User;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;

public class Cryptography {

    private static Cipher cipher;

    static {
        try {
            cipher = Cipher.getInstance("AES");
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            e.printStackTrace();
        }
    }

    public static String encrypt(String message, SecretKey secretKey)
            throws Exception {
        byte[] plainTextByte = message.getBytes();
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedByte = cipher.doFinal(plainTextByte);
        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(encryptedByte);
    }

    public static String decrypt(String message, SecretKey secretKey)
            throws Exception {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] encryptedTextByte = decoder.decode(message);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedByte = cipher.doFinal(encryptedTextByte);
        return new String(decryptedByte);
    }

    public static String decrypt(List<String> message, SecretKey secretKey) throws Exception {
        StringBuilder s = new StringBuilder();

        for (String w : message) {
            s.append(decrypt(w, secretKey)).append(" ");
        }

        return s.toString();
    }

    public static String encrypt(List<String> message, SecretKey secretKey) throws Exception {
        StringBuilder s = new StringBuilder();

        for (String w : message) {
            s.append(encrypt(w, secretKey)).append(" ");
        }

        return s.toString();
    }

}
