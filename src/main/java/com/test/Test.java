package com.test;

import org.apache.commons.lang.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author gb
 * @version 1.0
 * description:
 * @date 2021/2/3 23:18
 */

public class Test {
    public static void main(String[] args) {
        Student st1 = new Student(3, null, "10");
        Student st2 = new Student(7, "asdc", "11");
        Student st3 = new Student(4, "a323sdb", "12");
        Student st4 = new Student(2, "asdewb", "13");
        Student st5 = new Student(6, "asddsdsb", "13");
        Student st6 = new Student(7, "asdb", "13");
        Student st7 = new Student(7, "asdb", "10");

        List<Student> st = new ArrayList<>();
        st.add(st1);
        st.add(st2);
        st.add(st3);
        st.add(st4);
        st.add(st5);
        st.add(st6);
        st.add(st7);
        List<String> s1 = new ArrayList<>();
        s1.add("10");

        List<Student> list = st.stream().filter(it -> s1.contains(it.getId())).filter(a -> !Objects.equals(a.getName(),null)).collect(Collectors.toList());
        list.stream().forEach(System.out::println);
        System.out.println("====");




     /*   st.stream().forEach(System.out::println);
        System.out.println("+==========");
*/
//
        List<Student> s = st.stream().filter(a -> !Objects.equals(a.getId(), 13)).filter(b -> !Objects.equals(b.getId(), 10))
                .collect(Collectors.toList());
        s.stream().forEach(System.out::println);

       /* System.out.println("===========");
        st.stream().sorted(Comparator.comparing(Student::getId).thenComparing(x -> x.getAge()))
                .collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("===");
        st.stream().forEach(System.out::println);*/

        String a = null;
        System.out.println(StringUtils.isBlank(a));


    }

}
