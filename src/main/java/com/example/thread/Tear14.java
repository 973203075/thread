package com.example.thread;

import java.util.*;

public class Tear14 {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        students.add(new Student("张三","男",18));
        students.add(new Student("李四","男",20));
        students.add(new Student("韩梅梅","女",18));
        students.add(new Student("小红","女",45));

        Map<String, Integer> resultMap = new HashMap<>();
        for (Student student : students) {
            resultMap.merge(student.getSs(), student.getI(), (a, b) -> b + a);
        }
        for (Map.Entry<String, Integer> e : resultMap.entrySet()) {
            System.out.println("key:"+e.getKey()+"   "+"value:"+e.getValue());
        }
        System.out.println("------------1--------------");
        Map<String, List<Student>> resultMap2 = new HashMap<>();
        for (Student student : students) {
            List<Student> s = resultMap2.computeIfAbsent(student.getSs(), k -> new ArrayList<>());
            s.add(student);
        }
        System.out.println(resultMap2);
        System.out.println("--------------2------------");
        List<Student> studentList = Arrays.asList(
                new Student("apple",null,10),
                //new Student("orange","女",30),
                //  new Student("pink",null,60),
                new Student("pink","男",60),
                new Student("black","男",60),
                new Student("orange",null,150)
        );
        Map<String,String> map = new HashMap<String, String>();
        map.put("pink",null);//原来为空，测试现在不为空
        map.put("orange","女");//原来不为空，测试现在为空
        map.put("apple",null);//原来为空，测试现在为空
        studentList.stream().forEachOrdered(student->map.compute(student.getS(),(k,v)->{
            return student.getSs();}));
        System.out.println(map);


        System.out.println("------------3--------------");
        List<Student> studentList2 = Arrays.asList(
                new Student("apple",null,10),
                //new Student("orange","女",30),
                //  new Student("pink",null,60),
                new Student("pink","男",60),
                new Student("black","男",60),
                new Student("orange",null,150)
        );
        Map<String,String> map2 = new HashMap<String, String>();
        map2.put("pink",null);//原来为空，测试现在不为空
        map2.put("orange","女");//原来不为空，测试现在不为空
       // studentList2.stream().forEachOrdered(student->map2.computeIfAbsent(student.getS(),k->k).toUpperCase());
        studentList2.stream().forEachOrdered(student->map.computeIfAbsent(student.getS(),k->null));
        System.out.println(map2);
        System.out.println("--------------4-----------");
        List<Student> studentList3 = Arrays.asList(
                new Student("apple",null,10),
                new Student("pink","男",60),
                new Student("black","男",60),
                new Student("black","女",80)
        );
        Map<String,List<Student>> map3 = new HashMap<>();
        studentList3.stream().forEachOrdered(
                student->map3.computeIfAbsent(student.getS(),k->new ArrayList<Student>()).add(student)
        );
        System.out.println(map3);
        // {
        // apple=[Student{name='apple', sex='null', money=10.0}],
        // pink=[Student{name='pink', sex='男', money=60.0}],
        // black=[Student{name='black', sex='男', money=60.0}, Student{name='black', sex='女', money=80.0}]
        // }   add达到效果了

        System.out.println("---------------5-------------");
        List<Student> studentList4 = Arrays.asList(
                new Student("apple","女",10),
                new Student("pink","男",60),
                new Student("black","男",60),
                new Student("red","女",60),
                new Student("orange",null,150)
        );
        Map<String,String> map4 = new HashMap<String, String>();
        map4.put("pink",null);//原来为空，测试现在不为空
        map4.put("orange","女");//原来不为空，测试现在为空
        map4.put("apple","男");//原来不为空，测试现在不为空
        studentList4.stream().forEachOrdered(student->map4.computeIfPresent(student.getS(),(k,v)->{
            return student.getSs();}));
        System.out.println(map4);
        // {apple=女, pink=null}
        System.out.println("==============1===============");
        Map<String,String> map5 = new HashMap<String, String>();
        map5.put("a","aaa");
        map5.put("b",null);

        map5.merge("a","hahaha",String::concat);
        map5.merge("b","hahaha",String::concat);
        System.out.println(map5);
        //{a=aaahahaha, b=hahaha}
        System.out.println("=============2=============");
        Map<String,String> map6 = new HashMap<String, String>();
        map6.put("a","aaa");
        map6.put("b",null);

        map6.putIfAbsent("a","ddd");
        map6.putIfAbsent("b","ddd");
        map6.putIfAbsent("c","ddd");
        System.out.println(map6);
        //{a=aaa, b=ddd, c=ddd}

    }
}
