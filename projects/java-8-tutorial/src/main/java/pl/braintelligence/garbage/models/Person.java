package pl.braintelligence.garbage.models;

import java.util.Date;

public class Person {
    private String name;
    private int age;
    private Date createdAt;

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public Person(String name) {
        this.name = name;
        createdAt = new Date();
    }


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

