package com.test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author gb
 * @version 1.0
 * description:
 * @date 2021/2/18 17:03
 */

public class Test3 {
    public static void main(String[] args) {
        Student st1 = new Student(3, "薇薇", "10");
        Student st2 = new Student(7, "小轩轩", "11");
        Student st3 = new Student(4, "李宗盛", "12");
        Student st4 = new Student(2, "周华健", "13");
        Student st5 = new Student(6, "罗大佑", "13");
        Student st6 = new Student(7, "孙燕姿", "13");
        Student st7 = new Student(7, "薛之谦", "10");
        Student st8 = new Student(31, "李雨桐", "1");

        List<Student> st = new ArrayList<>();
        st.add(st1);
        st.add(st2);
        st.add(st3);
        st.add(st4);
        st.add(st5);
        st.add(st6);
        st.add(st7);
        List<Student> ss = new ArrayList<>();
        ss.add(st4);
        ss.add(st5);
        ss.add(st6);
        ss.add(st7);
        ss.add(st8);
        System.out.println("ss:");
        ss.stream().forEach(System.out::println);
        System.out.println("st:");
        st.stream().forEach(System.out::println);

        /**-----------------取集合中某个属性并转为集合-----------------**/
        List<String> nameList = st.stream().map(Student::getName).collect(Collectors.toList());
        System.out.println("-----------------取集合中某个属性并转为集合-----------------");
        nameList.stream().forEach(System.out::println);
        /**-----------------两个集合取交集-----------------**/
        List<Student> intersection = st.stream().filter(it -> ss.contains(it)).collect(Collectors.toList());
        System.out.println("-----------------两个集合取交集-----------------");
        intersection.stream().forEach(System.out::println);
        /**-----------------两个集合取并集并去重-----------------**/
        System.out.println("-----------------st,ss合取并集并去重-----------------");
        st.addAll(ss);
        /**-----------------较为麻烦--------------------------**/
        List<Student> s2 = st.stream().distinct().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Student::getName
        ))), ArrayList::new)).stream().collect(Collectors.toList());
        /**-----------------这个方法需要重写equals方法-----------------**/
//        List<Student> collect = st.stream().distinct().collect(Collectors.toList());
        s2.stream().forEach(System.out::println);
        /**-----------------过滤掉集合中某个属性值的对象-----------------**/
        System.out.println("-----------------过滤掉集合中某个属性值的对象-----------------");
        List<Student> s3 = st.stream().filter(a -> !Objects.equals("薛之谦", a.getName())).collect(Collectors.toList());
        s3.stream().forEach(System.out::println);
        /**-----------------根据某个属性排序-----------------**/
        System.out.println("-----------------先根据age属性排序，再根据id排序-----------------");
        List<Student> s4 = st.stream().sorted(Comparator.comparing(Student::getAge).thenComparing(x -> x.getId()))
                .collect(Collectors.toList());
        s4.stream().forEach(System.out::println);


    }
}
