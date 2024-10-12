package com.example.demo.utils;

import com.google.gson.Gson;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class MethodUtils {
    public static String generateNumberOtp() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int digit = random.nextInt(10);
            sb.append(digit);
        }
        return sb.toString();
    }

    public static String generateOrderCode(){
        Random random = new Random();

        int firstDigit = random.nextInt(9) + 1;
        StringBuilder sb = new StringBuilder();
        sb.append(firstDigit);

        for (int i = 1; i < 10; i++) {
            int digit = random.nextInt(10);
            sb.append(digit);
        }

        return sb.toString();
    }

    public static String HmacSignatureGenerate(String checksumKey, String data) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance("HmacSHA256");
        SecretKeySpec secretKeySpec = new SecretKeySpec(checksumKey.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
        mac.init(secretKeySpec);
        return Hex.encodeHexString(mac.doFinal(data.getBytes(StandardCharsets.UTF_8)));
    }

    public static String convertToJson(Object object) {
        return new Gson().toJson(object);
    }

    public static <T> T convertJsonToObject(String jsonString, Class<T> tClass) {
        return new Gson().fromJson(jsonString, tClass);
    }
}
