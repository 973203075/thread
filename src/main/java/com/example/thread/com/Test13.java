package com.example.thread.com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test13 {
    public static void main(String[] args) {

        List<UserVo> lset = new ArrayList<>();
        lset.add(new UserVo("qq", 11));
        Map<String,UserVo> map = new HashMap<>();
        map.put("m",lset.get(0));
        lset.get(0).setName("wwwww");
        System.out.println(map.get("m"));

    }
}
