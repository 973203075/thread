package com.example.thread.com;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Test2 {
    public static class Shop {
    private String name;
    private Random random = new Random();

    public Shop(String name){
       this.name = name;
    }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        //直接获取价格
     public double getPrice(String product){
        return calculatePrice(product);
     }
     //模拟延迟
     public static  void delay(){
        try{
            Thread.sleep(1000L);
        }catch(InterruptedException e){
             e.printStackTrace();
        }
     }
     //模拟获取价格的服务
     private double calculatePrice(String product){
        delay();
     return random.nextDouble() * product.charAt(0) + product.charAt(1);
     }

    //异步获取价格
    public Future<Double> getPriceAsync(String product){
        CompletableFuture<Double> future = new CompletableFuture<>();
        new Thread(()   ->  {
        double price = calculatePrice(product);
        future.complete(price);
        }).start();
        return future;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Shop shop = new Shop("BaseShop");
        long start  = System.currentTimeMillis();
        Future<Double> future = shop.getPriceAsync("My price");
        long invocationTime  = System.currentTimeMillis() - start;
        System.out.println("接口调用时间：" + invocationTime + "毫秒");
        doSomethingElse();
        double price = future.get();
        System.out.println(price);
        long retrievalTime = System.currentTimeMillis() - start;
        System.out.println("返回价格消耗时间：" + retrievalTime + "毫秒");

    }
    public static void doSomethingElse(){
        System.out.println("做其他的事情。。。");
    }
}
