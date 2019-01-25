package com.example.thread.com;

import java.util.concurrent.CompletableFuture;

public class Test6 {

    public static void main(String[] args) {

//        String result = CompletableFuture.supplyAsync(()
//                -> "hello").thenApply(s -> s + " world").join();
//        System.out.println(result);
//        CompletableFuture.supplyAsync(() -> {
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return "hello";
//        }).thenRun(() -> System.out.println("hello world"));
//        while (true){}


//        String result = CompletableFuture.supplyAsync(() -> {
//            try {
//                System.out.println(Thread.currentThread().getName());
//                Thread.sleep(6000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return "hello";
//        }).thenCombineAsync(CompletableFuture.supplyAsync(() -> {
//            try {
//                System.out.println(Thread.currentThread().getName());
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return "world";
//        }), (s1, s2) -> s1 + " " + s2).join();
//        System.out.println(result);


//        CompletableFuture.supplyAsync(() -> {
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return "hello";
//        }).thenAcceptBoth(CompletableFuture.supplyAsync(() -> {
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return "world";
//        }), (s1, s2) -> System.out.println(s1 + " " + s2));
//        while (true){}

//        CompletableFuture.supplyAsync(() -> {
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return "s1";
//        }).runAfterBothAsync(CompletableFuture.supplyAsync(() -> {
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return "s2";
//        }), () -> System.out.println("hello world"));
//        while (true){}


//        String result = CompletableFuture.supplyAsync(() -> {
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return "s1";
//        }).applyToEither(CompletableFuture.supplyAsync(() -> {
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return "hello world";
//        }), s -> s).join();
//        System.out.println(result);

//        CompletableFuture.supplyAsync(() -> {
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return "s1";
//        }).acceptEither(CompletableFuture.supplyAsync(() -> {
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return "hello world";
//        }), System.out::println);
//        while (true){}


//        CompletableFuture.supplyAsync(() -> {
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return "s1";
//        }).runAfterEither(CompletableFuture.supplyAsync(() -> {
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return "s2";
//        }), () -> System.out.println("hello world"));
//        while (true) {
//        }

//        String result = CompletableFuture.supplyAsync(() -> {
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            if (1 == 1) {
//                throw new RuntimeException("测试一下异常情况");
//            }
//            return "s1";
//        }).exceptionally(e -> {
//            System.out.println(e.getMessage());
//            return e.getMessage();
//        }).join();
//        System.out.println(result);

        String result = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            if (1 == 1) {
//                throw new RuntimeException("测试一下异常情况");
//            }
            return "s1";
        }).whenComplete((s, t) -> {
            System.out.println(s);
            System.out.println(t.getMessage());
        }).exceptionally(e -> {
            System.out.println(e.getMessage());
            return "hello world";
        }).join();
        System.out.println(result);

//        String result = CompletableFuture.supplyAsync(() -> {
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            //出现异常
//            if (1 == 1) {
//                throw new RuntimeException("测试一下异常情况");
//            }
//            return "s1";
//        }).handle((s, t) -> {
//            if (t != null) {
//                return "hello world";
//            }
//            return s;
//        }).join();
//        System.out.println(result);
//
//    }\
        }
}
