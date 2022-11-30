package com.airline.userdemo.model;

import org.springframework.data.annotation.Id;

public class User {

    @Id
    private String id;

    private String name;
    private String surname;
    private String nationality;
    private int age;

    public User() {

    }

    public User(String id, String name, String surname, String nationality, int age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.nationality = nationality;
        this.age = age;
    }

    public User(String name, String surname, String nationality, int age) {
        this.name = name;
        this.surname = surname;
        this.nationality = nationality;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
