package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setFullName("Maxim Yakovlev");
        student1.setGroup(2);
        student1.setDate(new Date());
        System.out.println("Студент " + student1.getFullName() + " поступил в группу №" + student1.getGroup() + " дата запроса: " + student1.getDate());
    }
}
