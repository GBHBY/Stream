package com.test;

import java.util.Objects;

/**
 * @author gb
 * @version 1.0
 * description:
 * @date 2021/2/4 21:31
 */

public class Student {
    private int age;
    private String name;
    private String id;

    public Student(int age, String name, String id) {
        this.age = age;
        this.name = name;
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return (student.getName()).equals(this.name) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
