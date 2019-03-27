package com.example.collector;

import com.example.bigDecimal.BigDecimalTest;
import com.example.thread.com.UserVo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: tiankuokuo
 * @description: 重写collectors测试
 * @date: 2019/1/25 15:26
 */
public class CollectorTest {
    public static void main(String[] args) {

        List<BigDecimal> list = new ArrayList<>();
        list.add(BigDecimal.valueOf(1.1));
        list.add(BigDecimal.valueOf(1.0));
        list.add(BigDecimal.valueOf(1.5));
        list.add(null);
        System.out.println(1.1+1.0+1.5+0.92);
        BigDecimal collect = list.stream().collect(CollectorsUtil.summingBigDecimal(value -> value));
        System.out.println(collect);

        List<UserVo> list2 = new ArrayList<>();
        list2.add(new UserVo("张三",12));
        list2.add(new UserVo("张三",12));
        list2.add(new UserVo("李四",18));
        list2.add(new UserVo("万物",16));
        list2.add(new UserVo("西瓜",51));
        list2.add(new UserVo("qq",16));
        list2.add(new UserVo("西瓜",18));
        list2.add(new UserVo("李四",18));
        list2.add(new UserVo("qq",108));
        list2.add(new UserVo("张三",128));
        list2.add(new UserVo("qq",148));
        list2.add(new UserVo("qq",148));
        list2.add(new UserVo("qq",158));
        list2.add(new UserVo("qq1",184));
    }
}
