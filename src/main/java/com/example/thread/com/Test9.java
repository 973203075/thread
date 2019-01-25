package com.example.thread.com;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Test9 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
         ExecutorService service = new ThreadPoolExecutor(20, 20,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
        List<UserVo> list = new ArrayList<>();
        list.add(new UserVo("张三",12));
        list.add(new UserVo("张三",12));
        list.add(new UserVo("李四",18));
        list.add(new UserVo("万物",16));
        list.add(new UserVo("西瓜",51));
        list.add(new UserVo("qq",16));
        list.add(new UserVo("西瓜",18));
        list.add(new UserVo("李四",18));
        list.add(new UserVo("qq",108));
        list.add(new UserVo("张三",128));
        list.add(new UserVo("qq",148));
        list.add(new UserVo("qq",148));
        list.add(new UserVo("qq",158));
        list.add(new UserVo("qq1",184));
        list.stream()
                .map(userVo -> CompletableFuture.supplyAsync(()
                        -> get(userVo),service)).collect(Collectors.toList());
        System.out.println("=============");
//        collect.forEach(userVoCompletableFuture -> System.out.println(userVoCompletableFuture.join()));
//        long end = System.currentTimeMillis();
//        System.out.println(end -start);
//
//        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
//            try {
//                Thread.sleep(10000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return "1111111111";
//        });
//        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "22222222222");
//        System.out.println(future1.join());
//        System.out.println(future1.join());
//        System.out.println(future1.join());

    }

    private static <U> UserVo get(UserVo userVo) {
        CompletableFuture<UserVo> future = CompletableFuture.supplyAsync(() -> {
            userVo.setName(userVo.getName() + "s");
            System.out.println("s"+Thread.currentThread().getName());
            return userVo;
        });
        UserVo join = future.join();
        System.out.println("p"+Thread.currentThread().getName());
        return join;
    }
}
