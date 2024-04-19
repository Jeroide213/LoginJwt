package com.example.demoLoginJWT.Security;

import java.security.SecureRandom;
import java.util.Base64;

public class SecretKeyGenerator {
    public static void main(String[] args) {
        // Genera una clave secreta de 32 bytes
        byte[] secretKey = generateSecretKey(32);

        // Codifica la clave secreta en Base64 para su fácil almacenamiento y uso
        String base64EncodedSecretKey = Base64.getEncoder().encodeToString(secretKey);

        System.out.println("Secret Key: " + base64EncodedSecretKey);
    }
    public static byte[] generateSecretKey(int length) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] secretKey = new byte[length];
        secureRandom.nextBytes(secretKey);
        return secretKey;
    }
}