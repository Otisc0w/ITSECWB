/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class PasswordUtils {
    private static final int SALT_BYTE_SIZE = 16; // Salt size in bytes
    private static final int HASH_BYTE_SIZE = 32; // Hash size in bytes
    private static final int PBKDF2_ITERATIONS = 10000; // Number of iterations
    private static final String HASH_ALGORITHM = "PBKDF2WithHmacSHA256"; // Hash algorithm

    public static boolean comparePasswords(String password, String hashedPassword, String salt) {
        byte[] passwordHash = hashPassword(password, salt);

        int diff = passwordHash.length ^ hashedPassword.length();
        for (int i = 0; i < passwordHash.length && i < hashedPassword.length(); i++) {
            diff |= passwordHash[i] ^ hashedPassword.charAt(i);
        }

        return diff == 0;
    }

    private static byte[] hashPassword(String password, String salt) {
        byte[] hash = null;
        try {
            char[] passwordChars = password.toCharArray();
            byte[] saltBytes = salt.getBytes();

            // Create the key
            MessageDigest digest = MessageDigest.getInstance(HASH_ALGORITHM);
            digest.reset();
            digest.update(saltBytes);

            byte[] hashedBytes = digest.digest(toBytes(passwordChars));

            // Perform PBKDF2 on the hashed password
            hash = pbkdf2(hashedBytes, saltBytes, PBKDF2_ITERATIONS, HASH_BYTE_SIZE);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace(System.out);
        }

        return hash;
    }

    private static byte[] pbkdf2(byte[] password, byte[] salt, int iterations, int bytes) {
        javax.crypto.SecretKeyFactory factory;
        try {
            factory = javax.crypto.SecretKeyFactory.getInstance(HASH_ALGORITHM);
            javax.crypto.spec.PBEKeySpec spec = new javax.crypto.spec.PBEKeySpec(toChars(password), salt, iterations, bytes * 8);
            return factory.generateSecret(spec).getEncoded();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    private static byte[] toBytes(char[] array) {
        byte[] bytes = new byte[array.length];
        for (int i = 0; i < array.length; i++) {
            bytes[i] = (byte) array[i];
        }
        return bytes;
    }

    private static char[] toChars(byte[] array) {
        char[] chars = new char[array.length];
        for (int i = 0; i < array.length; i++) {
            chars[i] = (char) (array[i] & 0xFF);
        }
        return chars;
    }

    public static String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[SALT_BYTE_SIZE];
        random.nextBytes(salt);
        return new String(salt);
    }
}

