package com.copasso.billbook.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MDUtils {
    /**
     * 通过用户名和密码明文生成作者的账号加密密码
     * @param userName
     * @param userPass
     * @return 加密密码
     * @throws NoSuchAlgorithmException
     */
    public static String generatePass(String userName,String userPass) throws NoSuchAlgorithmException {
        return encodeMD5ToStr(userName + userPass);
    }


    public static byte[] encodeMD5ToByte(String data) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] encryptData = messageDigest.digest(data.getBytes());
        return encryptData;
    }

    public static String encodeMD5ToStr(String data) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        String encryptData = StringUtils.byte2hex(messageDigest.digest(data.getBytes(StandardCharsets.UTF_8)));
        return encryptData;
    }

    public static byte[] encodeMD2ToByte(String data) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD2");
        byte[] encryptData = messageDigest.digest(data.getBytes(StandardCharsets.UTF_8));
        return encryptData;
    }

    public static String encodeMD2ToStr(String data) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD2");
        String encryptData = StringUtils.byte2hex(messageDigest.digest(data.getBytes(StandardCharsets.UTF_8)));
        return encryptData;
    }
}
