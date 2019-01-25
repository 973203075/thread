package com.example.thread.com;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Test4 {
    private static  final Random random = new Random();
    public static  String randomDelay()
    {
        int delay = 500 + random.nextInt(2000);
        try {
            System.out.println(String.format("%s sleep in %d",Thread.currentThread().getName(),delay));
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(String.format("%s sleep in %s",Thread.currentThread().getName(),"end"));
        return Thread.currentThread().getName()+" return";
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        CompletableFuture[] futures = {CompletableFuture.supplyAsync(()->randomDelay()),
//                CompletableFuture.supplyAsync(()->randomDelay()),CompletableFuture.supplyAsync(()->randomDelay())};
//        CompletableFuture.allOf(futures).join();
//        System.out.println("all timeout process end");
//        CompletableFuture [] futures2 = {CompletableFuture.supplyAsync(()->randomDelay()),
//                CompletableFuture.supplyAsync(()->randomDelay()),CompletableFuture.supplyAsync(()->randomDelay())};
//        System.out.println(CompletableFuture.anyOf(futures2).get());
//        System.out.println("2 all timeout process end");

        CompletableFuture<String> completableFuture  =
                CompletableFuture.supplyAsync(()->randomDelay());
        completableFuture.acceptEither(CompletableFuture
                .supplyAsync(()->randomDelay()),
                u-> System.out.println(u)).join();


    }

}
