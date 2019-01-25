package com.example.thread.com;

import java.util.concurrent.CompletableFuture;

public class Test5 {

    public static String getTestResult()
    {
        int i = 10/0;
        return "test";
    }

    public static void main(String[] args) {
        CompletableFuture<String> completableFuture  = new CompletableFuture();
        new Thread(()->{
            try {
                completableFuture.complete(getTestResult());
            } catch (Exception e) {
                System.out.println("get exception in side");
                completableFuture.completeExceptionally(e);
            }
        }).start();
        completableFuture.exceptionally(e->"we hava a exception"+e.getMessage())
                .thenAccept(u-> System.out.println(u));
    }

}
