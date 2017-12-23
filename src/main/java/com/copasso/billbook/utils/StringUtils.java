package com.copasso.billbook.utils;

import java.util.Random;

/**
 * 字符串工具类
 */
public class StringUtils {
    /**
     * 二进制转十进制
     * @param buff
     * @return
     */
    public static String byte2hex(byte[] buff)
    {
        if ((buff == null) || (buff.length <= 0)) {
            return "";
        }

        String tmpStr = null;
        StringBuilder hexStr = new StringBuilder();

        for (int n = 0; n < buff.length; n++) {
            tmpStr = Integer.toHexString(buff[n] & 0xFF);
            if (tmpStr.length() == 1) {
                hexStr.append("0");
            }
            hexStr.append(tmpStr);
        }
        return hexStr.toString().toUpperCase();
    }

    public static String byte2Hex(byte[] b, boolean upper)
    {
        String result = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0xFF);
            if (stmp.length() == 1)
                result = new StringBuilder().append(result).append("0").append(stmp).toString();
            else {
                result = new StringBuilder().append(result).append(stmp).toString();
            }
        }
        if (upper) {
            return result.toUpperCase();
        }
        return result.toLowerCase();
    }

    /**
     * 将金额字符串为null时转换成0.00
     * @param str
     * @return
     */
    public static String  null2Zero(String str){
        if(str==null)
            str="0.00";
        return str;
    }

    /**
     * 随机返回颜色Color十六进制字符串
     * @return
     */
    public static String randomColor(){
        //红色
        String red;
        //绿色
        String green;
        //蓝色
        String blue;
        //生成随机对象
        Random random = new Random();
        //生成红色颜色代码
        red = Integer.toHexString(random.nextInt(256)).toUpperCase();
        //生成绿色颜色代码
        green = Integer.toHexString(random.nextInt(256)).toUpperCase();
        //生成蓝色颜色代码
        blue = Integer.toHexString(random.nextInt(256)).toUpperCase();

        //判断红色代码的位数
        red = red.length()==1 ? "0" + red : red ;
        //判断绿色代码的位数
        green = green.length()==1 ? "0" + green : green ;
        //判断蓝色代码的位数
        blue = blue.length()==1 ? "0" + blue : blue ;
        //生成十六进制颜色值
        return "#"+red+green+blue;
    }
}

