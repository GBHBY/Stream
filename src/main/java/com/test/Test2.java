package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author gb
 * @version 1.0
 * description:
 * @date 2021/2/5 9:53
 */

public class Test2 {
    public static void main(String[] args) {
        Student userOld1 = new Student(1, "aaa", "22");
        Student userOld2 = new Student(2, "bbb", "32");
        Student userOld3 = new Student(3, "ccc", "11");
        Student userOld4 = new Student(4, "ddd", "42");
        Student userOld5 = new Student(5, "bbb", "22");
        Student userOld6 = new Student(6, "eee", "24");

        Student userNew1 = new Student(7, "dada", "22");     //新增一个
        Student userNew2 = new Student(2, "bbb", "32");     //不变一个
        Student userNew3 = new Student(3, "kaka", "33");     //更新一个
        Student userNew4 = new Student(8, "dbdb", "42");     //新增一个
        Student userNew5 = new Student(5, "bbb", "100");     //更新一个
        //当然，少了1,4,6

        List<Student> mapAdd = new ArrayList<>();


        List<Student> oldList = new ArrayList<>();
        List<Student> newList = new ArrayList<>();

        //添加老数据
        oldList.add(userOld1);
        oldList.add(userOld2);
        oldList.add(userOld3);
        oldList.add(userOld4);
        oldList.add(userOld5);
        oldList.add(userOld6);
        //添加新数据
        newList.add(userNew1);
        newList.add(userNew2);
        newList.add(userNew3);
        newList.add(userNew4);
        newList.add(userNew5);

        //去交集,既获取id相同的交集，需要更新
        //1.先提取出id和结果，用map形式
        List<String> oldIds = new ArrayList<>();
        List<String> newIds = new ArrayList<>();
        oldList.stream().forEach(it -> oldIds.add(it.getId()));
        newList.stream().forEach(it -> newIds.add(it.getId()));
//        oldIds.stream().forEach(System.out::println);
//        newIds.stream().forEach(System.out::println);

   /*     //取交集id
        System.out.println("-----------------交集----------------------");
        List<String> collectUpdate = newIds.stream().filter(it -> oldIds.contains(it)).collect(Collectors.toList());
        collectUpdate.stream().forEach(System.out::println);
        //取对应交集的对象
        System.out.println("------------------交集的对象---------------------");
        List<Student> userUpdate = newList.stream().filter(it -> collectUpdate.contains(it.getId())).collect(Collectors.toList());
        userUpdate.stream().forEach(System.out::println);
*/
        //取old的差集
        System.out.println("-----------------old的差集----------------------");
        List<String> collectDelete = oldIds.stream().filter(it -> newIds.contains(it)).collect(Collectors.toList());
        collectDelete.stream().forEach((System.out::println));
        //取对应old差集对象
        System.out.println("-----------------old差集对象----------------------");
        List<Student> userDelete = oldList.stream().filter(it -> newIds.contains(it.getId())).collect(Collectors.toList());
        userDelete.stream().forEach(System.out::println);

      /*  //取new的差集
        System.out.println("-----------------new的差集----------------------");
        List<String> collectAdd = newIds.stream().filter(it -> !oldIds.contains(it)).collect(Collectors.toList());
        collectAdd.stream().forEach((System.out::println));
        //取对应old差集对象
        System.out.println("-------------------old差集对象--------------------");
        List<Student> userAdd = newList.stream().filter(it -> collectAdd.contains(it.getId())).collect(Collectors.toList());
        userAdd.stream().forEach(System.out::println);


        //取并集
        System.out.println("-------------------并集--------------------");
        List<String> allIds = new ArrayList<>();
        //获取一个包含了oldIds和newIds的总结合,但是没有去重
        allIds.addAll(oldIds);
        allIds.addAll(newIds);
        //去重，获取并集ids的新集合
        List<String> joinIds = allIds.stream().distinct().collect(Collectors.toList());
        joinIds.stream().forEach(System.out::println);*/
    }
}