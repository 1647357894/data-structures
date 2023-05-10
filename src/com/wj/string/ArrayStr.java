package com.wj.string;

import java.util.Arrays;

/**
 * @author wangjie
 * @date 2020/8/26 21:11
 */
public class ArrayStr {
    String a;

    public static void main(String[] args) {
        String str = "abcdefg";
        char[] chars = str.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = chars.length-1; i >=0; i--) {
            sb.append(chars[i]);
        }
        System.out.println("sb.toString() = " + sb.toString());



    }
}
