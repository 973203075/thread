package com.example.thread.com;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test7 {
    public static void main(String[] args) {
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

        long start = System.currentTimeMillis();
        //组装数据
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<CompletableFuture<UserVo>> manuPlanFormVoFuture = list.stream()
                .map(userVo -> CompletableFuture
                .supplyAsync(() -> {
                    long start2 = System.currentTimeMillis();
                    UserVo test = test(userVo);
                    userVo.setName(userVo.getName() + "1");
                    long end = System.currentTimeMillis();
                    System.out.println("test:" + (end - start2));
                    return test;
                }, executorService)
        .exceptionally(e -> {
            System.err.println(e.getMessage());
            return null;
        }))
                .collect(Collectors.toList());
        Map<String, List<List<UserVo>>> collect = manuPlanFormVoFuture.stream().map(CompletableFuture::join).collect(
                Collectors.groupingBy(
                UserVo::getName,
                Collectors.mapping(u -> Arrays.asList(u), Collectors.toList())
        ));

        long end = System.currentTimeMillis();
        System.err.println("耗时：" + (end - start));
        System.out.println(collect);
        executorService.shutdown();
    }

    private static <U> UserVo test(UserVo userVo) {
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(1000L);
            //int q = 1/0;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userVo;
    }
}
