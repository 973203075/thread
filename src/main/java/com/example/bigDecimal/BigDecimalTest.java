package com.example.bigDecimal;

import java.math.BigDecimal;

public class BigDecimalTest {

    public static void main(String[] args) {


        BigDecimal e   =   new   BigDecimal(2.2);
        System.out.println("e:"+e);
        BigDecimal  f   =   new   BigDecimal(3.32);
        System.out.println("f:"+f);
        System.out.println("e+f="+e.add(f));

        System.out.println(new BigDecimal(0));
        System.out.println(new BigDecimal(String.valueOf(2.2)));
        System.out.println(new BigDecimal(100.02));

        System.out.println(new BigDecimal(2).add(null));
    }
}
