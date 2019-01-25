package com.example.length;


import java.io.UnsupportedEncodingException;

public class Length {

    public static void main(String[] args) throws UnsupportedEncodingException {

        String s  = "www防守打";
        System.out.println(s.length());
        String s1 = new String(s.getBytes("gbk"), "ISO-8859-1");
        System.out.println(s1.length());
    }
}
