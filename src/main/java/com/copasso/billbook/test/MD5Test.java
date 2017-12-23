package com.copasso.billbook.test;

import com.copasso.billbook.utils.MDUtils;

import java.security.NoSuchAlgorithmException;

public class MD5Test {

    public static void main(String[] args) {
        String password="user01";
        try {
            System.out.println(MDUtils.encodeMD2ToStr(password));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
