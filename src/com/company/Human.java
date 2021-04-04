package com.company;

import java.util.Date;

/*
Напишите программу «Адрес человека». Есть сущность Человек, которая
связана с сущностью Адрес. Считается, что у каждого человека есть только
один адрес. Организовать массив объектов Человек (не менее 4) и по массиву:
 осуществить поиск Человека по фамилии;
 осуществить поиск человека по атрибуту адреса;
 вывести людей, родившихся между определенными датами;
 найти самого старого (молодого);
 найти людей, проживающих на одной улице.
*/
public class Human {
    private String name;
    private String surname;
    private int monthBirthday;
    private int dayBirthday;
    private int yearBirthday;
    private Address address;
    private int age;

    public Human(){

    }
    public Human(String name, String surname, int age, int dayBirthday, int monthBirthday, int yearBirthday, String address) {
        this.name = name;
        this.surname = surname;
        this.monthBirthday = monthBirthday;
        this.dayBirthday = dayBirthday;
        this.yearBirthday = yearBirthday;
        this.address = new Address(address);
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public String getSurname() {
        return surname;
    }

    public int[] getBirthday() {
        return new int[]{dayBirthday, monthBirthday, yearBirthday};
    }
    public String toString(){
        return String.format("%s %s %d %s",name,surname,age,address.toString());
    }
}
