package com.example.thread.com;

import java.util.ArrayList;
import java.util.List;

public class Test12 {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        for (String s : list) {
            System.out.println("11");
            System.out.println(s);
        }
    }
}
