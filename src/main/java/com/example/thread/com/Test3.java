package com.example.thread.com;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Test3 {
    public static void main2(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(findPrice("java8实战"));
        long duration = System.currentTimeMillis() - start;
        System.out.println("总消耗时间：" + duration + "毫秒");
        start = System.currentTimeMillis();
        System.out.println(findPrice2("java8实战2"));
        duration = System.currentTimeMillis() - start;
        System.out.println("总消耗时间：" + duration + "毫秒");

    }

    private static List<String> findPrice(String product) {
        List<Test2.Shop> shops = Arrays.asList(
                new Test2.Shop("dddd"),
                new Test2.Shop("加瓦匠"),
                new Test2.Shop("京东商城"),
                new Test2.Shop("天猫商城"));
        return shops.parallelStream()
                .map(shop -> String.format("%s 的价格是 %.2f", shop.getName(),shop.getPrice(product)))
                .collect(Collectors.toList());
    }
    private static List<String> findPrice2(String product) {
        List<Test2.Shop> shops = Arrays.asList(
                new Test2.Shop("dddd"),
                new Test2.Shop("加瓦匠"),
                new Test2.Shop("京东商城"),
                new Test2.Shop("天猫商城"));
        List<CompletableFuture<String>> collect = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(
                        () -> shop.getName() + "的价格是 " +
                                shop.getPrice(product)
                )).collect(Collectors.toList());
        return collect.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());

    }

    public static void main(String[] args) {
        tt();
    }
    public static void tt(){
        CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1);
                System.out.println("supply " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "test ";
        }).thenApply(u -> {
            System.out.println("then " + Thread.currentThread().getName());
            return u + "in thenApply first";
        })
                .thenCompose(u -> CompletableFuture.supplyAsync(() -> {
                            System.out.println("supply2 " + Thread.currentThread().getName());
                            return u + "in thenCompose second";
                        })
                ).thenAccept(u -> {
            System.out.println("then2 " + Thread.currentThread().getName());
            System.out.println("qqqq"  + "in thenAccept last");
        });
    }
}
