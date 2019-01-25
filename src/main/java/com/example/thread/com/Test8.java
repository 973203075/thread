package com.example.thread.com;

import java.util.concurrent.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Test8 {

    public static void main(String[] args) {
        ExecutorService service = new ThreadPoolExecutor(20, 20,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
        long start = System.currentTimeMillis();
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> work(5000L), service)
                .thenAccept(integer -> work(1000L))
                .thenApply(aVoid -> "thenApply")
                .thenCombine(
                        CompletableFuture.supplyAsync(() -> work(4000L), service),
                        (x, y) -> x + y)
                .thenCombine(CompletableFuture.supplyAsync(() -> work(3000L), service),
                        (x, y) -> x + y)
                .thenCombine(CompletableFuture.supplyAsync(() -> work(2900L), service),
                        (x, y) -> x + y)
                .thenCombine(CompletableFuture.supplyAsync(() -> work(3100L), service),
                        (x, y) -> x + y)
                .handle((x, e) -> {
                    System.out.println("x:" + x);
                    System.out.println(Thread.currentThread().getName() + ":" + e.getMessage());
                    return e.getMessage();
                })
                .toCompletableFuture()
                ;

        System.out.println(Thread.currentThread().getName() + "=" + future.join());
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start));
        service.shutdown();







        service.shutdown();
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static <U> String work2(long l) {
        return String.valueOf(l);
    }


    private static long work(Long work) {
        try {
            Thread.sleep(work);
            System.out.println(Thread.currentThread().getName() + ":" + work);
            if("pool-1-thread-5".equals(Thread.currentThread().getName())){
                int i = 2/0;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return work;
    }
}
